package zms.model;

import java.util.ArrayList;

import zms.model.animal.Animal;
import zms.model.keeper.Keeper;


public class DataOperations {

    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Keeper> keepers = new ArrayList<Keeper>();
    

    /** Constructors 
     ** ... 
     */ 
    public DataOperations(){}

    public DataOperations(DataCreator dataCreator){
        this.animals = dataCreator.getAnimals();
        this.keepers = dataCreator.getKeepers();
    }
    
    public DataOperations(ArrayList<Animal> animals, ArrayList<Keeper> keepers){
        this.animals = animals;
        this.keepers = keepers;
    }


    /** Getters and Setters
     ** ...
    */
    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    public ArrayList<Keeper> getKeepers() {
        return this.keepers;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void setKeepers(ArrayList<Keeper> keepers) {
        this.keepers = keepers;
    }


    /** Methods
     ** ...
     */

     /** Print the list of all Animals in the console
     **  ...
     */
    public void printAnimals(){
        this.animals.forEach(animal -> System.out.println(animal));
    }

    /** Print the list of all Keepers in the console
     **  ...
     */
    public void printKeepers(){
        this.keepers.forEach(keeper -> System.out.println(keeper));
    }

    public void searchAnimalsBy(){}

    public void addAnimal(){}

    public void assignKeepersToAnimals(){}

}