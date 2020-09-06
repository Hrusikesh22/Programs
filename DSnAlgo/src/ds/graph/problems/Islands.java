package ds.graph.problems;

public class Islands {
	
	private static boolean[][] visitedArr = null;
	private static int noOfIslands = 0;
	private static boolean isParentIsland = false;
	
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
					findIslands(matrix, matrixDimension, i, j, isParentIsland);
				}
				isParentIsland = false;
			}
		}
		
		System.out.println("No Of Islands = " + noOfIslands);
	}

	static void findIslands(int[][] matrix, int matrixDimension, int i, int j, boolean isParentIsland) {
		
		if(!isWithinBoundary(i, j, matrixDimension))
			return;
		
		if(visitedArr[i][j])
			return;
		
		if(matrix[i][j] == 0) {
			visitedArr[i][j] = true;
			return;
		}
		
		visitedArr[i][j] = true;
		
		if(!isParentIsland)
			noOfIslands += 1; 

		isParentIsland = true;
		
		findIslands(matrix, matrixDimension, i-1, j, isParentIsland);//Top
		findIslands(matrix, matrixDimension, i+1, j, isParentIsland);//Bottom
		findIslands(matrix, matrixDimension, i, j-1, isParentIsland);//left
		findIslands(matrix, matrixDimension, i, j+1, isParentIsland);//right
		findIslands(matrix, matrixDimension, i-1, j-1, isParentIsland);//N-W
		findIslands(matrix, matrixDimension, i-1, j+1, isParentIsland);//N-E
		findIslands(matrix, matrixDimension, i+1, j-1, isParentIsland);//S-W
		findIslands(matrix, matrixDimension, i+1, j+1, isParentIsland);//S-E
	}
	
	static boolean isWithinBoundary(int i, int j, int matrixSize) {
		return (i>=0 && j>=0) && (i<=matrixSize-1 && j<=matrixSize-1);
	}
}
