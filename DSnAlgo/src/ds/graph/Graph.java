package ds.graph;

public interface Graph {
	
	void addVertex(char label);
	
	void addEdge(int source, int dest);
	void removeEdge(int source, int dest);
	
	void dfs();
	void bfs();
	
	void print();
}
