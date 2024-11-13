import java.util.Scanner;

class Game {
    private boolean alive;
    private int clean;
    private int cleanMax;
    private int energy;
    private int energyMax;
    private int hungry;
    private int hungryMax;
    private int age;
    private int diamonds;

    // Método privado que verifica se o pet está vivo
    private boolean testAlive() {
        if (energy == 0 || hungry == 0 || clean == 0){
            System.out.println("fail: pet esta morto");
            this.alive = false;
            return false;
        }
        this.alive = true;
        return true;
    }

    // Construtor para inicializar os atributos
    public Pet(int energyMax, int hungryMax, int cleanMax) {
        this.energyMax = energyMax;
        this.hungryMax = hungryMax;
        this.cleanMax = cleanMax;
        this.energy = energyMax;
        this.hungry = hungryMax;
        this.clean = cleanMax;
        this.alive = true;
        this.age = 0;
        this.diamonds = 0; 
    }

    public String toString() {
        return "E:" + getEnergy() + "/" + getEnergyMax() + ", " + 
        "S:" + getHungry() + "/" + getHungryMax() + ", " + 
        "L:" + getClean() + "/" + getCleanMax() + ", " +
        "D:" + getDiamonds() + ", " + 
        "I:" + getAge();
    }

    // Métodos públicos para ações do pet
    public void eat() {
        if (testAlive()){
            setEnergy(getEnergy() - 1);
            setHungry(getHungry() + 4);
            setClean(getClean() - 2);
            age++;
        }
    }

    public void play() {
        if (testAlive()){
            setEnergy(getEnergy() - 2);
            setHungry(getHungry() - 1);
            setClean(getClean() - 3);
            diamonds++;
            age++;
        }
    }

    public void shower() {
        if (testAlive()){
            setEnergy(getEnergy() - 3);
            setHungry(getHungry() - 1);
            setClean(getCleanMax());
            age += 2;
        }
    }

    public void sleep() {
        if (testAlive()){
            if ((getEnergyMax() - getEnergy()) < 5){
                System.out.println("fail: nao esta com sono");
            }
            else{
                age += 5;
                setEnergy(getEnergyMax());
                setHungry(getHungry() - 1);
            }
        }
    }

    //getters
    public boolean isAlive() {
        return alive;
    }

    public int getClean() {
        return clean;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getEnergy() {
        return energy;
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getHungry() {
        return hungry;
    }

    public int getHungryMax() {
        return hungryMax;
    }

    public int getAge() {
        return age;
    }

    public int getDiamonds() {
        return diamonds;
    }

     // Métodos setter com verificações
    public void setClean(int value) {
        this.clean = value;
        if (this.clean <= 0){
            this.clean = 0;
            System.out.println("fail: pet morreu de sujeira");
            alive = false;
        }
        else{
            this.alive = true;
        }
    }
    
    public void setEnergy(int value) {
        this.energy = value;
        if (this.energy <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        }
        else{
            this.alive = true;
        }
    }

    public void setHungry(int value) {
        
        this.hungry = value;
        if (this.hungry <= 0){
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            alive = false;
        }
        else{
            if (this.hungry > getHungryMax()){
                this.hungry = getHungryMax();
            }
            this.alive = true;
        }
    }

    //setters
    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }
}