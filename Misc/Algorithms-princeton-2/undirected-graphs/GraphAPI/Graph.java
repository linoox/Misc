
/* Ref: Sedgewick/Wayne*/



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Graph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	/* Inittializes an empty graph */
	public Graph(int V) {
		if(V<0) throw new IllegalArgumentException("Number of vertices must be non negative");
		this.V=V;
		this.E=0;

		adj = (Bag<Integer>[]) new Bag[V];
		for (int v=0;v<V;v++) {
			adj[v] = new Bag<Integer>();
		}
	}


	/* Initializes a graph from an input stream */
	public Graph(Scanner in) {
		this(in.nextInt());
		int E = in.nextInt();
		if(E < 0) throw new IllegalArgumentException("Number of edges must be non negative");

		for (int i=0;i<E;i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			addEdge(v,w);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
 
 	private void validateVertex(int v) {
 		if (v < 0 || v >= V)
 			throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
 	}


	void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}

	/* returns vertices adjacent to vertex */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	/* returns string representation of the graph */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v=0; v<V; v++ ) {
			s.append(v + ": ");
			for (int w: adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}

		return s.toString();
	}

	public static void main(String[] args) {
		

		try {
			File file = new File(args[0]);
			Scanner scanner = new Scanner(file);
			Graph G = new Graph(scanner);
			System.out.println(G);
		} catch(IOException e) {
			System.out.println("File Read Error: "+e.getMessage());
		}




	}

}