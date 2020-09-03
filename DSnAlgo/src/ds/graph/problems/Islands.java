package ds.graph.problems;

public class Islands {
	
	static boolean[][] visitedArr = null;
	
	public static void main(String[] str) {
		int matrixDimension = 5;
		visitedArr = new boolean[5][5];
		int[][] matrix = {
							{1,	1,	0,	0,	0},
							{0,	1,	0,	0,	1},
							{1, 0, 	0, 	1,	1},
							{0,	0, 	1, 	0, 	0},
							{1, 1, 	1, 	1,	0} 				};
		
		for(int i=0; i<matrixDimension; i++) {
			for(int j=0; j<matrixDimension; j++) {
				if(!visitedArr[i][j]) {
					noOfIslands(matrix, matrixDimension, i, j, foundIsland);
				}
				foundIsland = false;
			}
		}
		
		System.out.println("No Of Islands = " + noOfIslands);
	}

	static int noOfIslands = 0;
	static boolean foundIsland = false;
	
	static void noOfIslands(int[][] matrix, int matrixDimension, int i, int j, boolean foundIsland) {
		
		if(!isWithinBoundary(i, j, matrixDimension))
			return;
		
		if(visitedArr[i][j])
			return;
		
		if(matrix[i][j] == 0) {
			visitedArr[i][j] = true;
			return;
		}
		
		visitedArr[i][j] = true;
		
		if(!foundIsland)
			noOfIslands += 1; 

		foundIsland = true;
		
		noOfIslands(matrix, matrixDimension, i-1, j, foundIsland);//Top
		noOfIslands(matrix, matrixDimension, i+1, j, foundIsland);//Bottom
		noOfIslands(matrix, matrixDimension, i, j-1, foundIsland);//left
		noOfIslands(matrix, matrixDimension, i, j+1, foundIsland);//right
		noOfIslands(matrix, matrixDimension, i-1, j-1, foundIsland);//N-W
		noOfIslands(matrix, matrixDimension, i-1, j+1, foundIsland);//N-E
		noOfIslands(matrix, matrixDimension, i+1, j-1, foundIsland);//S-W
		noOfIslands(matrix, matrixDimension, i+1, j+1, foundIsland);//S-E
	}
	
	static boolean isWithinBoundary(int i, int j, int matrixSize) {
		
		if( (i>=0 && j>=0) && (i<=matrixSize-1 && j<=matrixSize-1) ) {
			return true;
		}
		return false;
	}
}
