package org.example;

public class Main {
    public static final Funcao ATOR = new Ator();
    public static final Funcao DIRETOR = new Diretor();
    public static final Funcao ROTEIRISTA = new Roteirista();
    public static final Funcao CINEGRAFISTA = new Cinegrafista();
    public static final Funcao CAMERA = new Camera();

    public static void main(String[] args) {

        ControleDeAcesso controleGloboFilmes = new ControleDeAcesso();

        // Cadastro de funcionários
        controleGloboFilmes.cadastrarFuncionario("Nick Cassavetes", "3339992221");
        controleGloboFilmes.cadastrarFuncionario("Rachel MCaddams", "3338887772");
        controleGloboFilmes.cadastrarFuncionario("Nicholas Sparks", "3337776663");
        controleGloboFilmes.cadastrarFuncionario("Ryan Gosling", "3336665554");
        controleGloboFilmes.cadastrarFuncionario("Mark Waters", "3335553335");
        controleGloboFilmes.cadastrarFuncionario("Tina Fey", "3334442226");

        // Cadastro de filmes
        controleGloboFilmes.cadastrarFilme("Diario de uma Paixao", 2004);
        controleGloboFilmes.cadastrarFilme("Diario de uma Paixao", 2004);

        //  equipe   "Diario de uma Paixao"
        controleGloboFilmes.adicionarAoFilme("Diario de uma Paixao", "3339992221", DIRETOR);     // Nick
        controleGloboFilmes.adicionarAoFilme("Diario de uma Paixao", "3339992221", ATOR);        // Nick
        controleGloboFilmes.adicionarAoFilme("Diario de uma Paixao", "3338887772", ATOR);        // Rachel
        controleGloboFilmes.adicionarAoFilme("Diario de uma Paixao", "3337776663", ROTEIRISTA);  // Sparks
        controleGloboFilmes.adicionarAoFilme("Diario de uma Paixao", "3336665554", ATOR);        // Ryan

        //  trilha "Diario de uma Paixao"
        try {
            Filme filme = controleGloboFilmes.getFilme("Diario de uma Paixao");
            if (filme != null) {
                filme.setTrilhaSonora("I'll Be Seeing You, Billie Holiday");
            } else {
                System.out.println("Filme 'Diario de uma Paixao' não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao definir a trilha sonora: " + e.getMessage());
        }

        // equipe "Meninas Malvadas"
        controleGloboFilmes.adicionarAoFilme("Meninas Malvadas", "3338887772", ATOR);         // Rachel

        controleGloboFilmes.cadastrarFilme("Meninas Malvadas", 2004);

        controleGloboFilmes.adicionarAoFilme("Meninas Malvadas", "3339992221", DIRETOR);     // Nick
        controleGloboFilmes.adicionarAoFilme("Meninas Malvadas", "3335553335", DIRETOR);      // Mark
        controleGloboFilmes.adicionarAoFilme("Meninas Malvadas", "3334442226", ROTEIRISTA);   // Tina


        //  trilha "Meninas Malvadas"
        try {
            Filme filme = controleGloboFilmes.getFilme("Meninas Malvadas");
            if (filme != null) {
                filme.setTrilhaSonora("Naughty Girl, Beyoncé");
            } else {
                System.out.println("Filme 'Meninas Malvadas' não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao definir a trilha sonora: " + e.getMessage());
        }


        controleGloboFilmes.obterFilmes();
        System.out.println(controleGloboFilmes.getFuncionario("3339992221")); // toStrin, info geral
        System.out.println(controleGloboFilmes.getFuncionario("3339992221").toStringFilmografia());
        System.out.println(controleGloboFilmes.getFuncionario("3338887772")); // toStrin, info geral
        System.out.println(controleGloboFilmes.getFuncionario("3338887772").toStringFilmografia());
    }
}
