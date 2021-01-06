package zms.model.animal;

import java.util.ArrayList;


public class Aquatic extends Animal implements AquaticInterface {

    // Instance variables 
    private WaterType waterType;
    private int canBeOutsideWater;


    // Constructors
    public Aquatic(){
        super();
    }

    public Aquatic(String specie, String name, Sex sex, WaterType waterType, int canBeOutsideWater){
        super(specie, name, sex);
        this.waterType = waterType;
        this.canBeOutsideWater = canBeOutsideWater;
    }


    // Getters and Setters
    @Override
    public WaterType getWaterType() {
        return waterType;
    }

    @Override
    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }

    @Override
    public int getCanBeOutsideWater() {
        return canBeOutsideWater;
    }

    @Override
    public void setCanBeOutsideWater(int canBeOutsideWater) {
        this.canBeOutsideWater = canBeOutsideWater;
    }


    // Other methods
    @Override
    public void addOffspring(Animal offspring) {
        if ( offspring instanceof Aquatic & offspring.getSpecie().equals(this.getSpecie()) ){
            this.getOffsprings().add(offspring);
        }else{
            throw new IllegalArgumentException("The offspring you are trying to associate is not of the same Class/Specie");
        }
    }
    
    @Override
    public String toString() {
        ArrayList<Integer> offspring_ids = new ArrayList<Integer>();
        this.getOffsprings().forEach( offspring -> offspring_ids.add(offspring.getId()) );
        return "Aquatic:"
                    +"\n\t ID:            "+this.getId()
                    +"\n\t Specie:        "+this.getSpecie()
                    +"\n\t Name:          "+this.getName()
                    +"\n\t Sex:           "+this.getSex()
                    +"\n\t Water type:    "+this.getWaterType()
                    +"\n\t Outside Water: "+this.getCanBeOutsideWater()
                    +"\n\t Offspring IDs: "+offspring_ids+"\n";
    }

}