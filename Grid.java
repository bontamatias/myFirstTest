import java.util.Stack;

public class Grid {
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    
    /**
    Flood fill, starting with the given row and column.
    */
    public void floodfill (int x,int y) {  
        //make a stack, add the starting position to the stack and create a temporary Pair object
        Stack<Pair> pairs = new Stack<>();
        pairs.push(new Pair(x,y));
        Pair temp;
        
        //declare a counter variable, then set the starting position to 1
        int count = 1;
        pixels[x][y] = count;
        
        while (!pairs.isEmpty()) { //run until the stack is empty
            
            //get the coordinate of whatever is on top of the stack (the last coordinate found below or the start position)
            temp = pairs.pop();
            x = temp.getX();
            y = temp.getY();
            
            //check each direction (N->E->S->W->... order), if a point is empty, number it and add it to the stack
            if (x > 0 && pixels[x-1][y] == 0) {
                pairs.push(new Pair(x-1,y));
                pixels[x-1][y] = ++count;
            }
            if (y < SIZE - 1 && pixels[x][y+1] == 0) {
                pairs.push(new Pair(x,y+1));
                pixels[x][y+1] = ++count;
            }
            if (x < SIZE - 1 && pixels[x+1][y] == 0) {
                pairs.push(new Pair(x+1,y));
                pixels[x+1][y] = ++count;
            }
            if (y > 0 && pixels[x][y-1] == 0) {
                pairs.push(new Pair(x,y-1));
                pixels[x][y-1] = ++count;
            }
        }
    }
        
    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}