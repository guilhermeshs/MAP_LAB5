package org.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ControleDeAcesso {
    private Map<String, Filme> filmes = new HashMap();
    private Map<String, Funcionario> funcionarios = new HashMap();

    public ControleDeAcesso() {
    }

    public Funcionario cadastrarFuncionario(String nomeFuncionario, String funcionarioCPF) {
        try {
            Funcionario novoFuncionario = new Funcionario(nomeFuncionario, funcionarioCPF);
            this.funcionarios.put(funcionarioCPF, novoFuncionario);
            return novoFuncionario;
        } catch (Exception var4) {
            Exception e = var4;
            System.out.println("Ocorreu um erro ao cadastrar o funcionário: " + String.valueOf(e));
            return null;
        }
    }

    public void adicionarAoFilme(String nomeFilme, String funcionarioCpf, Funcao funcao) {
        try {
            Filme filme = (Filme)this.filmes.get(nomeFilme);
            Funcionario funcionario = (Funcionario)this.funcionarios.get(funcionarioCpf);
            if (filme == null) {
                System.out.println("Filme '" + nomeFilme + "' não encontrado.");
                return;
            }

            if (funcionario == null) {
                System.out.println("Funcionário com CPF '" + funcionarioCpf + "' não encontrado.");
                return;
            }

            filme.adicionarNoFilme(funcionario.getCpf(), funcionario.getNome(), funcao.getDescricao());
            funcionario.adicionarFilme(funcao, filme.getNome());
        } catch (Exception var6) {
            Exception e = var6;
            System.out.println("Houve um problema ao adicionar as informações: " + String.valueOf(e));
        }

    }

    public void atualizarFuncaoEmFilme(String nomeFilme, String funcionarioCpf, Funcao funcao) {
        try {
            Filme filme = (Filme)this.filmes.get(nomeFilme);
            Funcionario funcionario = this.getFuncionario(funcionarioCpf);
            filme.atualizarFuncoes(funcionario.getCpf(), funcionario.getNome(), funcao.getDescricao());
            funcionario.adicionarFuncao(filme.getNome(), funcao);
        } catch (Exception var6) {
            Exception e = var6;
            System.out.println("Erro ao atualizar a função do funcionário: " + String.valueOf(e));
        }

    }

    public Filme cadastrarFilme(String nomeFilme, int anoFilme) {
        try {
            // Verifica se o filme já está cadastrado
            if (this.filmes.containsKey(nomeFilme)) {
                System.out.println("O filme '" + nomeFilme + "' já está cadastrado.");
                return null;
            }

            // Cadastra o novo filme
            Filme novoFilme = new Filme(nomeFilme, anoFilme);
            this.filmes.put(nomeFilme, novoFilme);
            System.out.println("\nFilme '" + nomeFilme + "' cadastrado com sucesso!\n");
            return novoFilme;
        } catch (Exception var4) {
            Exception e = var4;
            System.out.println("Erro ao cadastrar o filme: " + String.valueOf(e));
            return null;
        }
    }


    public void obterFilmes() {
        try {
            if (this.filmes.isEmpty()) {
                System.out.println("Nenhum filme cadastrado.");
            } else {
                System.out.print("\nFilmes cadastrados:\n");
                Iterator var2 = this.filmes.values().iterator();

                while(var2.hasNext()) {
                    Filme filme = (Filme)var2.next();
                    System.out.println(filme.toString());
                }
            }
        } catch (Exception var3) {
            Exception e = var3;
            System.out.println("Erro ao realizar a consulta: " + String.valueOf(e));
        }

    }

    public Funcionario getFuncionario(String cpf) {
        return (Funcionario)this.funcionarios.get(cpf);
    }

    public Filme getFilme(String nome) {
        Filme filme = (Filme)this.filmes.get(nome);
        if (filme == null) {
            System.out.println("Filme '" + nome + "' não encontrado.");
        }

        return filme;
    }
}
