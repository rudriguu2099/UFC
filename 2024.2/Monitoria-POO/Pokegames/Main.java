import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu nome de usuário:");
        String userName = scanner.nextLine();
        Treinador novo = new Treinador(userName, 0, 0, new Pokemon[6]);
        
        Pokemon[] pokemons = {
            new Pokemon("Rayquaza", 2, 2),
            new Pokemon("Charmander", -2, -2),
            new Pokemon("Deoxys", 0, 3),
            new Pokemon("Pikachu Shiny", 3, 0)
        };
    
        while(true) {
            System.out.println("Digite para se mover: cim, bai, esq, dir / sair para encerrar");
            String comando = scanner.nextLine();

            if (comando.equals("listar")) {
                novo.listar();
            } else if (comando.equals("sair")) {
                break;
            } else {
                novo.mover(comando);
            }

            for (int i = 0; i < pokemons.length; i++) {
                if (novo.x == pokemons[i].tokenX && novo.y == pokemons[i].tokenY) {
                    System.out.println("Legal! " + userName + " encontrou o " + pokemons[i].nome + "! Deseja capturá-lo? (sim/nao)");
                    
                    String resposta = scanner.nextLine().trim().toLowerCase();
                    if (resposta.equals("sim")) {
                        novo.capturar(pokemons[i]);
                        System.out.println("Você capturou " + pokemons[i].nome + "!");
                    } else {
                        System.out.println("Você decidiu não capturar " + pokemons[i].nome + ".");
                    }
                }
            }

            System.out.println("Posição atual: (" + novo.x + ", " + novo.y + ")");
        }
        scanner.close();
    }
}
