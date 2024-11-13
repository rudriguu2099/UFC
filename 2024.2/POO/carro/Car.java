public class Car{
    int pass;
    int passMax;
    int gas;
    int gasMax;
    int km;

    public Car(){
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0 ;
        this.gasMax = 100;
        this.km = 0 ;
    }

    public void enter(){
        if (pass >= passMax){
            System.out.println("fail: limite de pessoas atingido");
        }
        else{
            pass++;
        }
    }

    public void leave(){
        if (pass <= 0){
            System.out.println("fail: nao ha ninguem no carro");
        }
        else{
            pass--;
        }
    }

    public void fuel(int qtd){
        if (gas + qtd >= gasMax){
                gas = gasMax;
        }
        else{
            gas += qtd;
        }
    }

    public void drive(int qtd){
        if (pass == 0){
            System.out.println("fail: nao ha ninguem no carro");
        }
        else if (gas == 0){
            System.out.println("fail: tanque vazio");
        }
        else if (qtd > gas) {
            System.out.println("fail: tanque vazio apos andar " + (gas) + " km");
            km += gas;
            gas = 0;   
        } 
        else {
            km += qtd;
            gas -= qtd;
        }
    }
    public String toString() {
    return "pass: " + pass + ", gas: " + gas + ", km: " + km;
    }
}