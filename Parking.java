import java.util.Stack;
import java.util.Scanner;

public class Parking {
    
    public static void main (String[] args) {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> curbside = new Stack<>();
        Scanner in = new Scanner(System.in);
        
        System.out.print("License plate # + modifier: ");
        int input = in.nextInt();
        
        while (input != 0) {
            if (input > 0){ //add a car
                driveway.push(input);
                info(driveway, curbside);
            }
            else if (driveway.contains(Math.abs(input))) { //remove a car if it is in the list
                while (driveway.peek() != Math.abs(input)) { //move cars onto the curb until the selected car is the first one on the driveway
                    curbside.push(driveway.pop());
                }
                driveway.pop(); //remove the selected car
                info(driveway, curbside);
                
                while (!curbside.isEmpty()) driveway.push(curbside.pop()); //restore all moved cars to the driveway
                info(driveway, curbside);
            }
            else {
                System.out.println("Car not found"); //self-explanatory
                info(driveway, curbside);
            }
            
            System.out.print("License plate # + modifier: ");
            input = in.nextInt();
        }
    }
    
    private static void info (Stack<Integer> driveway, Stack<Integer> curbside) {
        System.out.println();
        System.out.println("driveway:" + driveway);
        System.out.println("curbside" + curbside);
        System.out.println();
    }
}
