package zms.cli;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import zms.model.DataOperations;


public class Cli {

    private DataOperations data;
    private Scanner        scanner;
    public  static  final  String  ANSI_RESET="\u001B[0m",   ANSI_WHITE="\u001B[37m",   ANSI_BLUE="\u001B[34m",   ANSI_RED="\u001B[31m",   ANSI_BLUE_BACKG="\u001B[44m";   
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    
    
    /** Constructors
     *  @param animals
     */
    public Cli(DataOperations data){
        this.data    = data;
        this.scanner = new Scanner(System.in);
    }
    

    /** This method prints the header of the menu.
     *  The header is just a 3 lines blue background with the menu title in the middle
     ** Highlighted commend
     *? Should this method do...?
     *! Alert
     *  TODO:  We need to add...
     *            __________________________________
     *  println( |__________________________________|
     *           |____________Menu_Title____________|
     *           |__________________________________| )
     * 
     *  @param  menuTitle 
     *  @throws IOException
     *  @throws InterruptedException
     */
    public void menuHeader(String menuTitle) throws IOException, InterruptedException {
        this.clearConsole();                 // The console is cleared before printing the header
        int          menuWidth        = 70;  // Width of the Menu in number of characters
        String       spaceMenuWidth   = " ".repeat(menuWidth);                                                     // «spaceMenuWidth» is a String of «menuWidth» blank spaces that represents the width of the Menu. This is the simplest way of creating a String of «n» charts in Java 11
        String       spaceBeforeTitle = new String(new char[(menuWidth-menuTitle.length())/2]).replace("\0"," ");  // Another way of creating a String of «n» charts
        StringBuffer spaceAfterTitle  = new StringBuffer();                                                        // Another way of creating a String of «n» charts
        for (int i=0  ;  i < ( menuWidth - spaceBeforeTitle.length() - menuTitle.length() )  ;  i++)  { spaceAfterTitle.append(" "); }

        // Printing the header
        System.out.println(ANSI_BLUE_BACKG+ANSI_WHITE+  // Define backgroud/font colors
                           spaceMenuWidth   + "\n" +
                           spaceBeforeTitle + menuTitle + spaceAfterTitle + "\n" +
                           spaceMenuWidth   + ANSI_RESET);
    }


    /** This is the Main Menu
     *                                   __________________________________
     *  menuHeader("Main Menu"): print( |__________________________________|
     *                                  |____________Menu_Title____________|
     *                                  |__________________________________| )
     *               mainMenu(): print( | [1] Animals                      |
     *                                  | [2] Keepers                      |
     *                                  | [3] Exit                         |
     *                                  | Insert selection: __             | 
     *                                  |__________________________________| )
     *  @throws IOException
     *  @throws InterruptedException
     */
    public void mainMenu() throws IOException, InterruptedException {
        String       input        = null;
        String[]     options      = {input, "1","2","3"};
        List<String> optionsLista = Arrays.asList(options);
        do {
            if ( optionsLista.contains(input) ){
                this.menuHeader("Main Menu");
                System.out.print("\n"+coloredBrackets("1") + "Animals\n"  // «  [1] Animals»
                                     +coloredBrackets("2") + "Keepers\n"  // «  [2] Keepers»
                                     +coloredBrackets("3") + "Exit\n");   // «  [3] Exit»
            }
            System.out.print("\n  Insert selection: ");
            input = this.scanner.nextLine();
            switch ( input ){
                case "1":  animalsMenu();         break;
                case "2":  keepersMenu();         break;
                case "3":  this.scanner.close();  break;
                default :  System.out.print("  "+ANSI_RED+"Invalid selection. Try again!\n"+ANSI_RESET);
            }
        }while(!input.equals("3"));  // The loop is broken when the user enters "3"
    }


    /** Animals Menu
     *  @throws IOException
     *  @throws InterruptedException
     */
    public void animalsMenu() throws IOException, InterruptedException {
        String   input   = null;
        String[] options = {input, "1","2","3","4","5"};
        List<String> optionsLista = Arrays.asList(options);
        do {
            if ( optionsLista.contains(input) ){
                this.menuHeader("Animals Menu");
                System.out.print("\n"+coloredBrackets(options[1]) + "Show all animals\n"      // «  [1] Show all animals»
                                     +coloredBrackets(options[2]) + "Seaarch animals by..\n"  // «  [2] Seaarch animals by..»
                                     +coloredBrackets(options[3]) + "Add a new animal\n"
                                     +coloredBrackets(options[4]) + "Go back\n"
                                     +coloredBrackets(options[5]) + "Exit\n");
            }
            System.out.print("\n  Insert selection: ");
            input = this.scanner.nextLine();
            if      ( input.equals(options[1]) )  { data.printAnimals(); goBackMenu(); }
            else if ( input.equals(options[2]) )  { data.searchAnimalsBy(); }
            else if ( input.equals(options[3]) )  { data.addAnimal(); }
            else if ( input.equals(options[4]) )  { break; }
            else if ( input.equals(options[5]) )  { this.scanner.close(); System.exit(0); }
            else    { System.out.print("  "+ANSI_RED+"Invalid selection. Try again!\n"+ANSI_RESET); }
        }while(!input.equals("4"));
    }


    /** Keepers Menu 
     ** ...
    */
    public void keepersMenu() throws IOException, InterruptedException {
        
    }


    /** Menu to Go Back to the main menus after a result is displayed in the console
     *  @throws IOException
     *  @throws InterruptedException
     */
    public void goBackMenu() throws IOException, InterruptedException {
        String input = null;
        System.out.print("\n"+coloredBrackets("1") + "Go back\n"
                             +coloredBrackets("2") + "Exit\n");
        System.out.print("\n  Insert selection: ");
        while ( !(input = this.scanner.nextLine()).equals("1") ) {
            if   ( input.equals("2") )  { this.scanner.close(); System.exit(0); }
            else { System.out.print("  "+ANSI_RED+"Invalid selection. Try again!\n\n"+ANSI_RESET); }
            System.out.print("  Insert selection: ");
        }
    }


    /** This method is in charge of clearing the Linux console
     ** This method is called by some of the Menus methods so the console is cleared before the menu is printed
     *  https://stackoverflow.com/questions/2979383/java-clear-the-console   
     * 
     *  @throws IOException
     *  @throws InterruptedException
     */
    public void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
    }


    /** This method return  [«number»]  with brackerts in blue
     *  @param number
     *  @return A formatted String: [«number»] with brackerts in blue
     */
    public String coloredBrackets(String number){
        return "  "+ANSI_BLUE +"["+ ANSI_RESET +  number  + ANSI_BLUE +"]"+ ANSI_RESET+" ";  // return «  [1] » in blue
    }

}