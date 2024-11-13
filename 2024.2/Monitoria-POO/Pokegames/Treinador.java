public class Treinador {
    String nome;
    int x, y;
    Pokemon[] dex = new Pokemon[6];

    public Treinador(String nome, int x, int y, Pokemon[] dex) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.dex = dex;
    }

    public void capturar(Pokemon p) {
        for (int i = 0; i < this.dex.length; i++) {
            if (this.dex[i] == null) {
                this.dex[i] = p;
                System.out.println(p.nome + " foi capturado!");
                break;
            }
        }
    }
    

    public void mover(String movimento) {
        switch(movimento) {
            case "cim": this.y++; break;
            case "bai": this.y--; break;
            case "esq": this.x--; break;
            case "dir": this.x++; break;
            default: System.out.println("Movimento inválido!");
        }
    }

    public void listar() {
        System.out.println("Pokémons capturados:");
        for (int i = 0; i < this.dex.length; i++) {
            if (this.dex[i] != null) { // Verifica se há um Pokémon na posição
                System.out.println("Pokemon " + i + ": " + this.dex[i].nome);
            }
        }
    }
    
}
