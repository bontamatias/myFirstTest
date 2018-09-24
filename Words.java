import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Words {
    public static void main (String[] args) throws FileNotFoundException {
        //create a TreeSet and a Scanner
        Set<String> data = new TreeSet<>();
        Scanner in = new Scanner(new File("text.txt"));
        
        while (in.hasNext()) data.add(in.next()); //add every word to the data set
        
        for (String scan : data) System.out.println(scan); //print all the found words
        
        System.out.println("\n" + data.size() + " unique words found");
    }
}
