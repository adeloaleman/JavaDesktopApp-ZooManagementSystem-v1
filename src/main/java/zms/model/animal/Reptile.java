package zms.model.animal;

import java.util.ArrayList;


public class Reptile extends Animal implements ReptileInterface {
    
    // Instance variables
    private ReptileGroup reptileGroup;
    
    
    // Constructors 
    public Reptile(){
        super();
    }
    
    public Reptile(String specie, String name, Sex sex, ReptileGroup reptileGroup){
        super(specie, name, sex);
        this.reptileGroup = reptileGroup;
    }
    
    
    // Getters and Setters
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
        if ( offspring instanceof Reptile & offspring.getSpecie().equals(super.getSpecie()) ){
            super.getOffsprings().add(offspring);
        }else{
            throw new IllegalArgumentException("The offspring you are trying to associate is not of the same Class/Specie");
        }
    }

    @Override
    public String toString() {
        ArrayList<Integer> offsprings_ids = new ArrayList<Integer>();
        for (Animal offspring: super.getOffsprings()){
            offsprings_ids.add(offspring.getId());
        }
        return "Reptile:"
                    +"\n\t ID:            "+super.getId()
                    +"\n\t Specie:        "+super.getSpecie()
                    +"\n\t Name:          "+super.getName()
                    +"\n\t Sex:           "+super.getSex()
                    +"\n\t Reptile group: "+this.getReptileGroup()
                    +"\n\t Offspring IDs: "+offsprings_ids+"\n";
    }

}