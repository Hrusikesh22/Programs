package arrays;

public class MatrixPrintSprirally {
	
	public static void main(String[] str) {
		int rows = 5;
		int cols = 5;
		int[][] matrix = {
				{1,		2,		3,		4,		5},
				{16,	17,		18,		19,		6},
				{15,	24,		25,		20,		7},
				{14,	23,		22,		21,		8},				
				{13,	12,		11,		10,		9}	};
		
		int iStart=0, jStart=0;
		int iEnd = rows-1, jEnd = cols-1;
		
		while (iStart<=iEnd && jStart<=jEnd) {
			for(int j=jStart; j <= jEnd; j++) //Print Horizontally 0-3
				System.out.print(matrix[iStart][j] + " ");
			
			iStart++; 
			
			for(int i=iStart; i <= iEnd; i++) 
				System.out.print(matrix[i][jEnd] + " ");

			jEnd--;
			
			for(int j=jEnd; j>=jStart; j--)//jStart=0
				System.out.print(matrix[iEnd][j] + " ");

			iEnd--;
			
			if(iStart <= iEnd) {
				for(int i=iEnd; i>=iStart; i--) //iStart=1
					System.out.print(matrix[i][jStart] + " ");
				
				jStart++;
			}
			
			System.out.println("\n");
		}
			
		

	}
}
