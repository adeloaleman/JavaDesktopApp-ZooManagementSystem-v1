package zms.model.animal;

import java.util.ArrayList;


public class AquaticReptile extends Animal implements AquaticInterface, ReptileInterface {

    // Instance variables
    private WaterType waterType;
    private int canBeOutsideWater;
    private ReptileGroup reptileGroup;


    // Constructors
    public AquaticReptile(){
        super();
    }

    public AquaticReptile(String specie, String name, Sex sex, WaterType waterType, int canBeOutsideWater, ReptileGroup reptileGroup){
        super(specie, name, sex);
        this.waterType = waterType;
        this.canBeOutsideWater = canBeOutsideWater;
        this.reptileGroup = reptileGroup;
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

    @Override
    public ReptileGroup getReptileGroup() {
        return reptileGroup;
    }

    @Override
    public void setReptileGroup(ReptileGroup reptileGroup) {
        this.reptileGroup = reptileGroup;
    }


    // Other methods
    @Override
    public void addOffspring(Animal offspring) {
        if ( offspring instanceof AquaticReptile & offspring.getSpecie().equals(this.getSpecie()) ){
            this.getOffsprings().add(offspring);
        }else{
            throw new IllegalArgumentException("The offspring you are trying to associate is not of the same Class/Specie");
        }
    }

    @Override
    public String toString() {
        ArrayList<Integer> offspring_ids = new ArrayList<Integer>();
        this.getOffsprings().forEach( offspring -> offspring_ids.add(offspring.getId()) );
        return "AquaticReptile:"
                    +"\n\t ID:            "+this.getId()
                    +"\n\t Specie:        "+this.getSpecie()
                    +"\n\t Name:          "+this.getName()
                    +"\n\t Sex:           "+this.getSex()
                    +"\n\t Water type:    "+this.getWaterType()
                    +"\n\t Outside Water: "+this.getCanBeOutsideWater()
                    +"\n\t Reptile group: "+this.getReptileGroup()
                    +"\n\t Offspring IDs: "+offspring_ids+"\n";
    }
    
}