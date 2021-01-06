package zms.model;

import java.util.ArrayList;
import java.util.Random;

import zms.model.animal.Animal;
import zms.model.animal.Aquatic;
import zms.model.animal.AquaticReptile;
import zms.model.animal.Reptile;
import zms.model.keeper.Keeper;


public class DataCreator {

    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Keeper> keepers = new ArrayList<Keeper>();


    /** Constructors 
     ** ...
     */ 
    public DataCreator(){}

    public DataCreator(int num_of_animals, int num_of_keepers){
        this.createAnimals(num_of_animals);
        this.createKeepers(num_of_keepers);
    }


    /** Methods 
     * 
    */
    
    public ArrayList<Animal> getAnimals(){
        return animals;
    }

    public ArrayList<Keeper> getKeepers(){
        return keepers;
    }

    public ArrayList<Animal> animals(int num_of_animals){
        this.createAnimals(num_of_animals);
        return this.animals;
    }

    public ArrayList<Keeper> keepers(int num_of_keepers){
        this.createKeepers(num_of_keepers);
        return this.keepers;
    }

    public void createAnimals(int num_of_animals){
        String[] animalClasses         = {"Aquatic",   "Reptile",  "AquaticReptile"};        
        String[] aquaticSpecies        = {"Dolphin",   "Wale",     "Manatee",     "Longfin",      "River shark", "White shark", "Ragfish",    "Abudefduf", "Arapaima",     "Goldfish", "Goosefish", "Greeneye", "Terapontidae" };    
        String[] reptileSpecies        = {"Geckos",    "Skink",    "Gekkota",     "Iguanidae",    "Chamaleons",  "Morrocoy",    "Snake",      "Lacertid",  "Gila Monster", "Viper",    "Tuatara",   "Alligator"};    
        String[] aquaticReptileSpecies = {"Crocodile", "Anaconda", "Coral Snake", "Watter Snake", "Emydidae",    "Homalopsis",  "Salamander", "Turtle",    "Busmaster"};    
        String[] names                 = {"Pepo",      "Gordo",    "Charlene",    "Benny",        "Della",       "Herietta",    "Dixie",      "Guadalupe", "Nancy", "Byron", "Cora", "Nora", "Jody", "Blanca", "Sara", "Jeannie", "Ginger"};    

        Random random = new Random();
        while (this.animals.size() < num_of_animals) {

            // Assigning random values to «enum» variables with more than 2 possible values:
            int randomWaterType = random.nextInt(3);
            Aquatic.WaterType waterType = ( randomWaterType == 0  ?  Aquatic.WaterType.FRESH  :  randomWaterType == 1  ?  Aquatic.WaterType.SALT : Aquatic.WaterType.FRESH_AND_SALT );

            Reptile.ReptileGroup reptileGroup;
            switch ( random.nextInt(4) ){
                case 0:  reptileGroup = Reptile.ReptileGroup.LIZARD;  break;
                case 1:  reptileGroup = Reptile.ReptileGroup.SNAKE;   break;
                case 2:  reptileGroup = Reptile.ReptileGroup.TURTLE;  break;
                default: reptileGroup = Reptile.ReptileGroup.CROCODILIAN;
            }

            // Creating Animals:
            Animal animal = null;
            switch ( random.nextInt(animalClasses.length) ){

                case 0: // Aquatic:       Specie                                                   Name                                   Sex                                                                 Water        Outside water?          
                    animal = new Aquatic( aquaticSpecies[random.nextInt(aquaticSpecies.length)],   names[random.nextInt(names.length)],   ( random.nextInt(2) == 0 ? Animal.Sex.MALE : Animal.Sex.FEMALE ),   waterType,   random.nextInt(2)  );   
                    this.animals.add(animal);
                    // Creating its offsprings
                    Aquatic aquatic = (Aquatic) animal;
                    for (int c=0 ; c < random.nextInt(4) ; c++){
                        if (this.animals.size() == num_of_animals)  { break; } 
                        Aquatic offspring = new Aquatic( aquatic.getSpecie(),   names[random.nextInt(names.length)],   ( random.nextInt(2) == 0 ? Animal.Sex.MALE : Animal.Sex.FEMALE ),   aquatic.getWaterType(),   aquatic.getCanBeOutsideWater() );   
                        this.animals.add(offspring);
                        aquatic.addOffspring(offspring);
                    }
                    break;

                case 1: // Reptile:                Specie                                                   Name                                   Sex                                                                 Reptile group     
                    Reptile reptile = new Reptile( reptileSpecies[random.nextInt(reptileSpecies.length)],   names[random.nextInt(names.length)],   ( random.nextInt(2) == 0 ? Animal.Sex.MALE : Animal.Sex.FEMALE ),   reptileGroup );   
                    this.animals.add(reptile);
                    // Creating its offsprings
                    for (int c=0 ; c < random.nextInt(4) ; c++){
                        if (this.animals.size() == num_of_animals)  { break; } 
                        Reptile offspring = new Reptile( reptile.getSpecie(),   names[random.nextInt(names.length)],   ( random.nextInt(2) == 0 ? Animal.Sex.MALE : Animal.Sex.FEMALE ),   reptile.getReptileGroup() );    
                        this.animals.add(offspring);
                        reptile.addOffspring(offspring);
                    }
                    break;

                default: // AquaticReptile:                             Specie                                                                 Name                                  Sex                                                                 Water Type   Outside water?       Reptile group    
                    AquaticReptile aquaticReptile = new AquaticReptile( aquaticReptileSpecies[random.nextInt(aquaticReptileSpecies.length)],   names[random.nextInt(names.length)],  ( random.nextInt(2) == 0 ? Animal.Sex.MALE : Animal.Sex.FEMALE ),   waterType,   random.nextInt(2),   reptileGroup );    
                    this.animals.add(aquaticReptile);
                    // Creating its offsprings
                    for (int c=0 ; c < random.nextInt(4) ; c++){
                        if (this.animals.size() == num_of_animals)  { break; } 
                        AquaticReptile offspring = new AquaticReptile( aquaticReptile.getSpecie(),   names[random.nextInt(names.length)],   ( random.nextInt(2) == 0 ? Animal.Sex.MALE : Animal.Sex.FEMALE ),   aquaticReptile.getWaterType(),   aquaticReptile.getCanBeOutsideWater(),   aquaticReptile.getReptileGroup() ); 
                        this.animals.add(offspring);
                        aquaticReptile.addOffspring(offspring);
                    }

            }

        }
    
    }

    public void createKeepers(int num_of_keepers){

    }

}