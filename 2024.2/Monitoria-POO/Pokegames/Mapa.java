class Mapa {
    private char[][] layout;
    private final int largura;
    private final int altura;

    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        inicializarMapa();
    }

    private void inicializarMapa() {
        layout = new char[altura][largura];
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                layout[i][j] = '.';
            }
        }
    }

    public void exibirMapa(int x, int y) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (i == y && j == x) {
                    System.out.print("O "); 
                } else {
                    System.out.print(layout[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean posicaoValida(int x, int y) {
        return x >= 0 && x < largura && y >= 0 && y < altura;
    }
}