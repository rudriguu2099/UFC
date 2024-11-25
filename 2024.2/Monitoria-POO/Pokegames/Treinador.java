class Treinador {
    private String nome;
    private int x;
    private int y;
    private Pokemon[] pokemons;
    private int capturados;

    public Treinador(String nome) {
        this.nome = nome;
        this.x = 0;
        this.y = 0;
        this.pokemons = new Pokemon[6];
        this.capturados = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosicao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void mover(String direcao) {
        switch (direcao.toLowerCase()) {
            case "cima":
                y -= 1;
                break;
            case "baixo":
                y += 1;
                break;
            case "esquerda":
                x -= 1;
                break;
            case "direita":
                x += 1;
                break;
            default:
                System.out.println("Direção inválida!");
        }
    }

    public boolean capturar(Pokemon p) {
        if (capturados < 6) {
            pokemons[capturados] = p;
            p.capturado();
            capturados++;
            System.out.println(p.getNome() + " foi capturado!");
            return true;
        } else {
            System.out.println("Sua equipe já está cheia!");
            return false;
        }
    }

    public void listar() {
        System.out.println("Seus Pokémons:");
        for (int i = 0; i < capturados; i++) {
            System.out.println((i + 1) + ". " + pokemons[i].getNome());
        }
    }
}