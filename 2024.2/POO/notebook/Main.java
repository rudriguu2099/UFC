class Notebook {
    private boolean ligado;

    public Notebook(){
        setLigado(false);
    }

    public void ligar(){
        setLigado(true);
        System.out.println("notebook ligado");
    }

    public void desligar(){
        setLigado(false);
        System.out.println("notebook desligado");
    }

    public void mostrar(){
        if(!(getLigado())){
            System.out.println("Status: Desligado");
        }
        else{
            System.out.println("Status: Ligado");
        }
    }

    public void usar(int tempo){
        if (!(getLigado())){
            System.out.println("erro: ligue o notebook primeiro");
        }
        else{
            System.out.println("Usando por " + tempo + " minutos");
        }
    }

    public boolean getLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    

}

public class Main {
    public static void main(String args[]) {
        Notebook notebook = new Notebook();
        notebook.mostrar();  
        notebook.usar(10);     
        notebook.ligar();     
        notebook.mostrar();    
        notebook.usar(10);    
        notebook.desligar();
    }
}
