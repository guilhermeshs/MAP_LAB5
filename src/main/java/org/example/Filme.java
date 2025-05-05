package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Filme {
    private String nome;
    private int ano;
    private Map<String, Map<String, List<String>>> funcionarios;
    private String trilhaSonora;

    public Filme(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
        this.funcionarios = new HashMap();
    }

    public String getNome() {
        return this.nome;
    }

    public int getAno() {
        return this.ano;
    }

    public Map<String, Map<String, List<String>>> getFuncionarios() {
        return this.funcionarios;
    }

    public boolean adicionarNoFilme(String cpf, String nome, String funcaoDescricao) {
        try {
            Map<String, List<String>> mapaNomeFuncoes = (Map)this.funcionarios.computeIfAbsent(cpf, (k) -> {
                return new HashMap();
            });
            List<String> listaFuncoes = (List)mapaNomeFuncoes.computeIfAbsent(nome, (k) -> {
                return new ArrayList();
            });
            if (!listaFuncoes.contains(funcaoDescricao)) {
                listaFuncoes.add(funcaoDescricao);
                return true;
            } else {
                System.out.println("A função já está associada ao funcionário.");
                return false;
            }
        } catch (Exception var6) {
            Exception e = var6;
            System.out.println("Erro ao adicionar funcionário no filme: " + e.getMessage());
            return false;
        }
    }

    public void atualizarFuncoes(String cpf, String nome, String funcaoDescricao) {
        try {
            Map<String, List<String>> mapaNomeFuncoes = (Map)this.funcionarios.get(cpf);
            if (mapaNomeFuncoes != null) {
                List<String> listaFuncoes = (List)mapaNomeFuncoes.get(nome);
                if (listaFuncoes != null) {
                    if (!listaFuncoes.contains(funcaoDescricao)) {
                        listaFuncoes.add(funcaoDescricao);
                    } else {
                        System.out.println("A função já está associada ao funcionário.");
                    }
                } else {
                    System.out.println("Nome do funcionário não encontrado.");
                }
            } else {
                System.out.println("CPF não encontrado.");
            }
        } catch (Exception var6) {
            Exception e = var6;
            System.out.println("Erro ao atualizar funções: " + e.getMessage());
        }

    }

    public void setTrilhaSonora(String trilhaSonora) {
        this.trilhaSonora = trilhaSonora;
        System.out.println("Trilha sonora definida com sucesso!");
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_____________________________________________________________________\n");
            sb.append(String.format("Filme: %s (%d)\n", this.nome, this.ano));
            sb.append(String.format("Trilha sonora: %s\n", this.trilhaSonora != null ? this.trilhaSonora : "Não definida"));
            sb.append("\nFuncionarios e Funcoes:\n");
            sb.append(String.format("%-30s %-30s %-20s\n", "CPF", "Funcionario", "Funcao"));
            sb.append("--------------------------------------------------------------------\n");
            Iterator var3 = this.funcionarios.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<String, Map<String, List<String>>> entryCpf = (Map.Entry)var3.next();
                String cpf = (String)entryCpf.getKey();
                Map<String, List<String>> mapaNomeFuncoes = (Map)entryCpf.getValue();
                Iterator var7 = mapaNomeFuncoes.entrySet().iterator();

                while(var7.hasNext()) {
                    Map.Entry<String, List<String>> entryNome = (Map.Entry)var7.next();
                    String nomeFuncionario = (String)entryNome.getKey();
                    List<String> funcoes = (List)entryNome.getValue();
                    Iterator var11 = funcoes.iterator();

                    while(var11.hasNext()) {
                        String funcao = (String)var11.next();
                        sb.append(String.format("%-30s %-30s %-20s\n", cpf, nomeFuncionario, funcao));
                    }
                }
            }

            sb.append("_____________________________________________________________________\n");
            return sb.toString();
        } catch (Exception var12) {
            Exception e = var12;
            return "Erro ao gerar string do filme: " + e.getMessage();
        }
    }
}
