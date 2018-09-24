import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Airport {
    
    public static void main (String[] args) {
        Queue<String> runway = new LinkedList<>();
        Queue<String> holdingPattern = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        String input = "";
        
        while (true) { //using true so I can add an easter egg... sorry...
            System.out.println();
            System.out.print("Enter: takeoff <flight>, land <flight>, next, quit: ");
            
            input = in.next().toLowerCase();
            
            if (input.equals("takeoff")) {
                runway.add(in.next());
                System.out.println("Outbound flight added. Goodbye flight " + runway.peek() + "!");
            }
            else if (input.equals("land")) {
                holdingPattern.add(in.next());
                System.out.print("Inbound flight added. Welcome to wherever-here-is flight " + holdingPattern.peek() + "!");
            }
            else if (input.equals("next")) {
                if (holdingPattern.size() > 0) System.out.println(holdingPattern.remove() + " has landed!");
                else if (runway.size() > 0) System.out.println(runway.remove() + " has taken off!");
                else System.out.println("The skies are boring! Nobody does anything! Yay!");
            }
            else if (input.equals("quit")) { //exit code with easter eggs because why not...
                if (holdingPattern.size() > 0) System.out.print("Exiting...   you just left " + holdingPattern.size() + " flight(s) in limbo... yay...");
                else System.out.println("Exiting...");
                break;
            }
            else System.out.println("Command not recognized");
        }
    }
}
