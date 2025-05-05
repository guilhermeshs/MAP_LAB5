package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Funcionario {
    private String nome;
    private String cpf;
    private List<Funcao> funcoes;
    private Map<String, List<Funcao>> filmografia;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.funcoes = new ArrayList();
        this.filmografia = new HashMap();
    }

    public void adicionarFilme(Funcao funcao, String filmeCodigo) {
        try {
            List<Funcao> funcoesNoFilme = (List)this.filmografia.get(filmeCodigo);
            if (funcoesNoFilme == null) {
                funcoesNoFilme = new ArrayList();
                this.filmografia.put(filmeCodigo, funcoesNoFilme);
            }

            if (!((List)funcoesNoFilme).contains(funcao)) {
                ((List)funcoesNoFilme).add(funcao);
            }

            if (!this.funcoes.contains(funcao)) {
                this.funcoes.add(funcao);
            }
        } catch (Exception var4) {
            Exception e = var4;
            System.out.println("Erro ao adicionar filme: " + e.getMessage());
        }

    }

    public void adicionarFuncao(String filmeCodigo, Funcao novaFuncao) {
        try {
            if (this.funcoes.contains(novaFuncao)) {
                System.out.println("Erro: A função já está atribuída ao funcionário.");
                return;
            }

            this.funcoes.add(novaFuncao);
            List<Funcao> funcoesNoFilme = (List)this.filmografia.get(filmeCodigo);
            if (funcoesNoFilme == null) {
                funcoesNoFilme = new ArrayList();
                this.filmografia.put(filmeCodigo, funcoesNoFilme);
            }

            if (((List)funcoesNoFilme).contains(novaFuncao)) {
                System.out.println("Erro: A função já está atribuída ao filme para este funcionário.");
            } else {
                ((List)funcoesNoFilme).add(novaFuncao);
            }
        } catch (Exception var4) {
            Exception e = var4;
            System.out.println("Erro ao adicionar função: " + e.getMessage());
        }

    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public List<Funcao> getFuncoes() {
        return this.funcoes;
    }

    public Map<String, List<Funcao>> getFilmografia() {
        return this.filmografia;
    }

    public String toStringFilmografia() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("_____________________________________________________________________\n");
            sb.append("Filmografia de: " + this.nome + "\n");
            sb.append(String.format("%-30s %-30s\n", "Filme", "Funcao"));
            sb.append("--------------------------------------------\n");
            Iterator var3 = this.filmografia.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<String, List<Funcao>> entry = (Map.Entry)var3.next();
                String filme = (String)entry.getKey();
                List<Funcao> funcoes = (List)entry.getValue();
                Iterator var7 = funcoes.iterator();

                while(var7.hasNext()) {
                    Funcao funcao = (Funcao)var7.next();
                    sb.append(String.format("%-30s %-30s\n", filme, funcao.getDescricao()));
                }
            }

            sb.append("_____________________________________________________________________\n");
            return sb.toString();
        } catch (Exception var8) {
            Exception e = var8;
            return "Erro ao gerar string da filmografia: " + e.getMessage();
        }
    }

    public String toString() {
        try {
            StringBuilder funcoesDescricao = new StringBuilder();
            Iterator var3 = this.funcoes.iterator();

            while(var3.hasNext()) {
                Funcao funcao = (Funcao)var3.next();
                funcoesDescricao.append("- ").append(funcao.getDescricao()).append("\n");
            }

            String descricaoFuncoes = funcoesDescricao.length() > 0 ? funcoesDescricao.toString() : "Nenhuma funcao atribuída";
            return "___________________________________________\nFuncionario: " + this.nome + "\nCPF: " + this.cpf + "\nFuncoes:\n" + descricaoFuncoes + "___________________________________________";
        } catch (Exception var4) {
            Exception e = var4;
            return "Erro ao gerar string do funcionário: " + e.getMessage();
        }
    }
}
