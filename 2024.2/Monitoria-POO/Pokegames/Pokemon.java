class Pokemon {
    private String nome;
    private int x;
    private int y;

    public Pokemon(String nome, int x, int y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
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

    public void capturado() {
        x = -1;
        y = -1;
    }
}