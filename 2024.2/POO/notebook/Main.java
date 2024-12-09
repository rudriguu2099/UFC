class Bateria {
    private int capacidade;
    private int carga;

    public Bateria(int capacidade){
        setCapacidade(capacidade);
        setCarga(capacidade);
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setCarga(int carga) {
        if (carga <= capacidade) this.carga = carga;
        else this.carga = capacidade;
    }

    public int getCarga() {
        return carga;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void usar(int minutos){
        if (minutos <= carga){
            carga -= minutos;
        } else{
            carga = 0;
        }
    }

    public void recarregar(){
        carga = capacidade;
    }

    public void mostrar() {
        System.out.println("(" + carga + "/" + capacidade + ")");
    }
}


class Notebook {
    private boolean ligado;
    private Bateria bateria;

    public Notebook(){
        setLigado(false);
        setBateria(null);
    }

    public void setBateria(Bateria bateria){
        this.bateria = bateria;
    }

    public Bateria rmBateria(){
        Bateria antiga = this.bateria;
        this.bateria = null;           
        System.out.println("Bateria removida");
        return antiga;
    }

    public void ligar(){
        if (bateria != null && bateria.getCarga() > 0){
            setLigado(true);
            System.out.println("notebook ligado");
        }
        else if (bateria == null){
            System.out.println("Erro: Nenhuma bateria instalada");
        }
        else{
            System.out.println("Erro: Bateria sem carga");
        }
    }

    public void desligar(){
        setLigado(false);
        System.out.println("notebook desligado");
    }

    public void mostrar(){
        String status = "";
        if (ligado) status = "Ligado";
        else status = "Desligado";

        if(bateria == null){
            System.out.println("Status: " + status + ", Bateria: Nenhuma");
        }
        else{
            System.out.println("Status: " + status + ", Bateria: (" + bateria.getCarga() + "/" + bateria.getCapacidade() + ")");
        }
    }

    public void usar(int tempo){
        if (!(getLigado())){
            System.out.println("erro: ligue o notebook primeiro");
        }
        else if (bateria == null){
            System.out.println("Erro: Nenhuma bateria instalada");
        }
        else{
            bateria.usar(tempo);
            if (bateria.getCarga() == 0) {
                desligar();
                System.out.println("Notebook descarregou");
            } else {
                System.out.println("Usando por " + tempo + " minutos");
            }
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
        
        
        Bateria bateria = new Bateria(50);  
        bateria.mostrar();    
        notebook.setBateria(bateria); 
        notebook.mostrar();    
        
        
        notebook.usar(10);     
        notebook.ligar();      
        notebook.mostrar();    
        notebook.usar(30);     
        notebook.mostrar();    
        notebook.usar(30);     
        notebook.mostrar();    
        
        
        notebook.ligar();      

        
        bateria = notebook.rmBateria(); 
        bateria.mostrar(); 
    }
}
