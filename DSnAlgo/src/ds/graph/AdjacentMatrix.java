package ds.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacentMatrix {

	public static void main(String[] args) {
		
		Graph graph = new AdjacentMatrixGraph();
		
		graph.addVertex('A'); graph.addVertex('B');
		graph.addVertex('C'); graph.addVertex('D');
		
		graph.addEdge(0, 1); //graph.addEdge(1, 0); Not required. 
		graph.addEdge(0, 3); //graph.addEdge(2, 0); Not required.
		graph.addEdge(1, 2); //graph.addEdge(2, 1); Not required.
		graph.addEdge(3, 2);
		
		//graph.removeEdge(1, 1);
		
		graph.print(); 
		
		System.out.println("\n--------- DFS ---------");
		graph.dfs();

		System.out.println("\n\n--------- BFS ---------");
		graph.bfs();
	}
}

//Assumption : Undirected graph

class AdjacentMatrixGraph implements Graph {
	
	private int MAX_VERTICES = 4;//change as required.
	private int vCount = 0;
	private int[][] todArr;
	private Vertex[] vertices;
	
	public AdjacentMatrixGraph() {
		todArr = new int[MAX_VERTICES][MAX_VERTICES]; 
		vertices = new Vertex[MAX_VERTICES];
	}
	
	@Override
	public void addVertex(char label) {
		vertices[vCount++] = new Vertex(label);
	}

	@Override
	public void addEdge(int i, int j) {
		todArr[i][j] = 1;
		todArr[j][i] = 1;
	}

	@Override
	public void removeEdge(int i, int j) {
		todArr[i][j] = 0;
		todArr[j][i] = 0;
	}
	
	@Override
	public void print() {
		for(int[] row : todArr) {
			for(int rowElem : row) {
				System.out.print(rowElem + " ");
			}
			System.out.println();
		}
	}
	
	private void markVisited(int index) {
		Vertex vertex = vertices[index];
		vertex.setVisited(true);
		System.out.print(vertex.getLabel() + " ");
	}
	
	public void dfs() {
		
		Stack<Integer> stk = new Stack<Integer>();			//IMP :: S
		
		markVisited(0);//Start with 0th vertex
		stk.push(0);
		
		while(!stk.isEmpty()) {
		
			int i = stk.peek(); 							//Not POP
			int j = getAdjUnvisitedVertex(i);
			
			if(j != -1) {									//Has Adjacent
				markVisited(j);
				stk.push(j);
			} else {										//No Adjacent, then POP/Remove
				stk.pop();
			}
		}
		
		resetVerticesVisitedFlag();
	}
	
	public int getAdjUnvisitedVertex(int i) {
		for(int j = 0; j < vCount; j++) {
			if(todArr[i][j] == 1 && !( vertices[j].isVisited()) )
				return j;
		}
		return -1;
	}
	
	private void resetVerticesVisitedFlag() {
		for(Vertex v : vertices) {
			v.setVisited(false);
		}
	}

	@Override
	public void bfs() {
		
		Queue<Integer> q = new LinkedList<Integer>();			//IMP :: Q 
				
		markVisited(0);
		q.offer(0);
		
		while(!q.isEmpty()) {
			
			int i = q.poll();									//Remove/POLL after each level
			int j = 0;
			
			while( (j = getAdjUnvisitedVertex(i)) != -1) {
				markVisited(j);
				q.offer(j);
			}
		}
		
		resetVerticesVisitedFlag();
	}
}

class Vertex {
	
	private char label;
	private boolean isVisited = false;
	
	public Vertex(char label) {
		this.label = label;
	}

	public char getLabel() { return label; }
	public void setLabel(char label) { this.label = label; }
	public boolean isVisited() { return isVisited; }
	public void setVisited(boolean isVisited) { this.isVisited = isVisited; }
}
