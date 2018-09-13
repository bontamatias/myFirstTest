import java.util.Stack;

public class Grid {
	private static final int SIZE = 10;
	int[][] pixels = new int[SIZE][SIZE];

	/**
	Flood fill, starting with the given row and column.
	*/
	public void floodfill (int x,int y) {
		Stack<Pair> pairs = new Stack<>();
		
		pairs.push(new Pair(x,y));


		if (x >= 0 && pixels[x-1][y] == null) {
			pairs.push(new Pair(x-1,y));
		}
		if (y < SIZE  && pixels[x][y+1] == null) {
			pairs.push(new Pair(x,y+1));
		}
		if (y >= 0 && pixels[x][y-1] == null) {
			pairs.push(new Pair(x,y-1));
		}
		if (x < SIZE  && pixels[x+1][y] == null) {
			pairs.push(new Pair(x+1,y));
		}
	}

	@Override
	public String toString() {
		String r = "";
		for (int i = 0; i < SIZE; i++) {
 			for (int j = 0; j < SIZE; j++)
				r = r + String.format("%4d", pixels[i][j]);
				r = r + "\n";
			}
				return r;
		}
	}
}
