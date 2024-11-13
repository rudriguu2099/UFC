
public class Animal {
    String especie;
    String barulho;
    int idade = 0;
    
    public Animal(String especie, String barulho){
        this.especie = especie;
        this.barulho = barulho; 
        this.idade = 0;
        
    }

    public String toString() {
        return String.format("%s:%d:%s", especie, idade, barulho);
    }

    void envelhecer(int qtd){
        idade += qtd;
        if (idade >= 4 ){
            System.out.printf("warning: %s morreu\n", especie);
            idade = 4;
        }
    }

    public String fazerBarulho(){
        if (idade == 0){
            return "---";
        }
        
        if(idade == 4) {
            return "RIP";
        }
        return this.barulho;
        
    }
}