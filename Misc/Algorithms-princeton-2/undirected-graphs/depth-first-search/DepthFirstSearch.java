/* ref: Sedgewick/Wayne */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


// incomplete
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;


	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		
		try {
			File file = new File(args[0]);
			Scanner scanner = new Scanner(file);
			Graph G = new Graph(scanner);
			System.out.println(G);

			int s = Integer.parseInt(args[1]);

			DepthFirstSearch search = new DepthFirstSearch(G, s);

			for (int v=0;v<G.V();v++) {
				if(search.marked(v))
					System.out.println(v + " ");
			}

			System.out.println();

			if(search.count() != G.V())
				System.out.println("NOT connected");
			else 
				System.out.println("connect");

		} catch(IOException e) {
			System.out.println("File Read Error: "+e.getMessage());
		}

	}

}