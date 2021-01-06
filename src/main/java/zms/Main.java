package zms;

import java.io.IOException;

import zms.cli.Cli;
import zms.model.DataCreator;
import zms.model.DataOperations;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        DataOperations data = new DataOperations(new DataCreator(50,10));
        Cli cli = new Cli(data); 
        cli.mainMenu();
    }
}


























// Animall pepo1    = new ReptileCreator("Crocodile", "Pepo",   Animall.Sex.FEMALE, Reptile.ReptileGroup.CROCODILIAN);
// Animall pepo2    = new ReptileCreator("Crocodile", "Pepito", Animall.Sex.MALE,   Reptile.ReptileGroup.CROCODILIAN);
// Animall delphin1 = new AquaticCreator("Delphin",   "Ale",    Animall.Sex.MALE,   Aquatic.WaterType.SALT, 0);


// animals.forEach(animal -> {
//     /** This is not necessary:
//      *  We don't need to Upcasting to print a particular Animal. Even if the
//      *  specific Animal (Reptile, for example) was instantiated as an Animal type, the method that is 
//      *  used is the one that belong to the particular Animal
//      */
//     if  (animal instanceof Aquatic){
//         Aquatic acuatic = (Aquatic) animal;
//         System.out.println(acuatic);
//     }else if (animal instanceof Reptile){
//         Reptile reptile = (Reptile) animal;
//         System.out.println(reptile);
//     }else if (animal instanceof Aquatic & animal instanceof Reptile){
//         AquaticReptileCreator aquaticReptile = (AquaticReptileCreator) animal;
//         System.out.println(aquaticReptile);
//     }
// });