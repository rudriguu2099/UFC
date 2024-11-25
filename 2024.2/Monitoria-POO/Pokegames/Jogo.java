import java.util.Scanner;

class Jogo {
    private Mapa mapa;
    private Treinador treinador;
    private Pokemon[] pokemons;

    public Jogo(String nomeTreinador) {
        this.mapa = new Mapa(10, 10);
        this.treinador = new Treinador(nomeTreinador);
        inicializarPokemons();
    }

    private void inicializarPokemons() {
        pokemons = new Pokemon[] {
            new Pokemon("Pikachu", 2, 2),
            new Pokemon("Charmander", 4, 4),
            new Pokemon("Bulbasaur", 6, 6),
            new Pokemon("Squirtle", 7, 3),
            new Pokemon("Jigglypuff", 1, 8),
            new Pokemon("Meowth", 9, 9)
        };
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mapa.exibirMapa(treinador.getX(), treinador.getY());
            exibirPokemons();
            System.out.println("Digite uma direção (cima, baixo, esquerda, direita), 'listar' ou 'sair':");
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("sair")) {
                System.out.println("Jogo encerrado!");
                break;
            }

            if (comando.equalsIgnoreCase("listar")) {
                treinador.listar();
                continue;
            }

            int novoX = treinador.getX();
            int novoY = treinador.getY();

            switch (comando.toLowerCase()) {
                case "cima":
                    novoY -= 1;
                    break;
                case "baixo":
                    novoY += 1;
                    break;
                case "esquerda":
                    novoX -= 1;
                    break;
                case "direita":
                    novoX += 1;
                    break;
                default:
                    System.out.println("Comando inválido!");
                    continue;
            }

            if (mapa.posicaoValida(novoX, novoY)) {
                treinador.setPosicao(novoX, novoY);
                verificarCaptura();
            } else {
                System.out.println("Movimento inválido! Fora do mapa.");
            }
        }
        scanner.close();
    }

    private void exibirPokemons() {
        for (Pokemon p : pokemons) {
            if (p.getX() != -1 && p.getY() != -1) {
                System.out.println(p.getNome() + " está na posição (" + p.getX() + ", " + p.getY() + ")");
            }
        }
    }

    private void verificarCaptura() {
        for (Pokemon p : pokemons) {
            if (p.getX() == treinador.getX() && p.getY() == treinador.getY()) {
                System.out.println("Você encontrou um " + p.getNome() + "! Deseja capturá-lo? (sim/não)");
                Scanner scanner = new Scanner(System.in);
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("sim")) {
                    treinador.capturar(p);
                } else {
                    System.out.println(p.getNome() + " escapou!");
                }
                return;
            }
        }
        System.out.println("Nenhum Pokémon para capturar aqui.");
    }
}