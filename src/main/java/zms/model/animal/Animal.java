/**  Class Animal
 * 
 * * Purpose: 
 *   This Abstract class is a parent class and will be used by subclasses with the purpose of creating
 *   different Animal types
 * 
 * * This class has the following characteristics:
 *   int     id;
 *   String  specie
 *   String  name
 *   enum    Sex{MALE, FEMALE}  sex
 *   ArrayList<Animal>  offsprings
 */
package zms.model.animal;

import java.util.ArrayList;
import java.util.Objects;


public abstract class Animal {

    private  static  int      classId;
    private  final   int      id;
    private          String   specie;
    private          String   name;
    public           enum     Sex{MALE,FEMALE};
    private          Sex      sex;
    private ArrayList<Animal> offsprings;

    
    // #region: Constructors 
    public Animal(){
        classId++;
        this.id = classId;
    }

    public Animal(String specie, String name, Sex sex){
        classId++;
        id = classId;
        this.specie = specie;
        this.name   = name;
        this.sex    = sex;
        offsprings  = new ArrayList<Animal>();
    }
    //#endregion


    // #region: Getters and Setters
    public int getId(){
        return id;
    }

    public String getSpecie(){
        return specie;
    }

    public String getName(){
        return name;
    }

    public Sex getSex(){
        return sex;
    }

    public ArrayList<Animal> getOffsprings(){
        return offsprings;
    }

    public void setSpecie(String specie){
        this.specie = specie;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSex(Sex sex){
        this.sex = sex;
    }

    public void setOffsprings(ArrayList<Animal> offsprings){
        this.offsprings = offsprings;
    }

    // Fluent setters
    public Animal specie(String specie){
        this.specie = specie;
        return this;
    }

    public Animal name(String name) {
        this.name = name;
        return this;
    }

    public Animal sex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public Animal offsprings(ArrayList<Animal> offsprings) {
        this.offsprings = offsprings;
        return this;
    }
    //#endregion


    // #region: Equals/HashCode, and toStrig methods
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Animal))
            return false;
        Animal animal = (Animal) o;
        return  Objects.equals(specie, animal.specie)   &&   Objects.equals(name, animal.name)   &&   Objects.equals(sex, animal.sex)   &&   Objects.equals(offsprings, animal.offsprings);   
        // The id is omitted during checking
    }

    @Override
    public int hashCode() {
        // The id omitted
        return Objects.hash(specie, name, sex, offsprings);
    }
    
    /** toString method tells the print statement how to deal with this object
     ** The implementation of the «addOffspring» method will be defined in the children classes.
     *  @return  formatted string to print an Animal object
     */
    @Override
    public abstract String toString();
    //#endregion

    
    // #region: Other methods

    /** The implementation of the «addOffspring» method will be defined in the children classes. This way, we will make sure
     *  that when an offspring is added to a particular type of animal instance, the offspring and the parent are of the same 
     *  type. For example, a Reptile will onlyaccept Reptiles to be added as offsprings.
     * 
     *  @param offspring : Animal that will be added as offspring
     */
    public abstract void addOffspring(Animal offspring);
    //#endregion
    
}