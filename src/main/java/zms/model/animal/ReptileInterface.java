package zms.model.animal;


public interface ReptileInterface {
    // Reptile group
    public enum ReptileGroup{LIZARD, SNAKE, TURTLE, CROCODILIAN};
    public ReptileGroup getReptileGroup();
    public void         setReptileGroup(ReptileGroup reptileGroup);
}