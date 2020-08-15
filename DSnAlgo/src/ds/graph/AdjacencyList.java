package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
	
	public static void main(String[] str) {
		Graph graph = new AdjacencyListGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 0);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		
		graph.print();
		
		graph.removeEdge(0, 1);
		System.out.println();
		graph.print();
	}
}


class AdjacencyListGraph implements Graph {
	
	private int vCount;
	private Map<Integer, ArrayList<Integer>> adjListMap = new HashMap<>();
	
	public AdjacencyListGraph(int vCount) {
		this.vCount = vCount;
		for(int i=0; i<this.vCount; i++)
			adjListMap.put(i, new ArrayList<Integer>());
	}
	
	@Override
	public void addEdge(int i, int j) {
		
		List<Integer> list1 = adjListMap.get(i);
		list1.add(j);

		List<Integer> list2 = adjListMap.get(j);
		list2.add(i);
	}
	

	@Override
	public void removeEdge(int i, int j) {
		List<Integer> list1 = adjListMap.get(i);
		list1.remove(list1.indexOf(j));

		List<Integer> list2 = adjListMap.get(j);
		list2.remove(list2.indexOf(i));
	}

	@Override
	public void print() {
		Iterator<Integer> it = adjListMap.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			System.out.print(key);
			for(int i : adjListMap.get(key)) {
				System.out.print("->"+i);
			}
			System.out.println();
		}
	}
	
	@Override
	public void addVertex(char label) {
		//TODO
	}

	@Override
	public void dfs() {
		// TODO Auto-generated method stub
	}

	@Override
	public void bfs() {
		// TODO Auto-generated method stub
		
	}
	
}