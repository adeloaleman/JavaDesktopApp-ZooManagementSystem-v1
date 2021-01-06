package zms.model.animal;


public interface AquaticInterface {
    // Methods in an interface are implicitly public. Creo que es redundante indicar que son «public»
    // Private interface methods are not sopported in -source 8. Use -source 9 or highter to enable private interface methods

    // Water type
    public enum WaterType{FRESH, SALT, FRESH_AND_SALT};
    public WaterType getWaterType();
    public void      setWaterType(WaterType waterType);

    // Can be outsice water?
    public int  getCanBeOutsideWater();
    public void setCanBeOutsideWater(int canBeOutsideWater);
}