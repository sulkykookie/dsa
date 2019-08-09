import java.util.*;
import java.io.*;

class graph {
	int v;
	LinkedList<Integer>[] adj;

	graph(int n) {
		this.v = n;
		adj = new LinkedList[v];

		for (int i=0; i<n; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int src, int dest) {
		adj[src].add(dest);
	}

	void printGraph() {
		for (int i = 0; i<v; i++) {
			System.out.print(i);
			for (int j : adj[i])
				System.out.print("->"+(j));
			System.out.println();
		}
	}
}


class Graphs {
	public static void bfs(graph g, int v) {
		LinkedList<Integer> queue = new LinkedList<>();
		int[] visited = new int[g.v];

		queue.add(v);
		visited[v] = 1;

		while(queue.size() != 0) {
			int s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = g.adj[s].listIterator();
			while(i.hasNext()) {
				int next = i.next();
				if (visited[next]==0){
					queue.add(next);
					visited[next] = 1;
				}
			}
		}
		System.out.println();
	}

	public static void dfs(graph g, int v) {
		int[] visited = new int[g.v];
		dodfs(g, v, visited);
		System.out.println();
	}

	public static void dodfs(graph g, int v, int[] visited) {
		visited[v]=1;
		System.out.print(v + " ");

		Iterator<Integer> i = g.adj[v].listIterator();
		while(i.hasNext()) {
			int next = i.next();
			if (visited[next]==0)
				dodfs(g, next, visited);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		System.out.print("Enter number of vertices: ");
		int V = Integer.parseInt(br.readLine());
		graph g = new graph(V);

		System.out.print("Enter number of edges: ");
		int n = Integer.parseInt(br.readLine());

		System.out.println("Enter " + n + " edges: ");
		for (int i=0; i<n; i++) {
			s = br.readLine().trim().split("\\s+");
			g.addEdge(Integer.parseInt(s[0]) , Integer.parseInt(s[1]));
		}

		System.out.print("Enter the vertex to perform algorithms on: ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("BFS: ");
		bfs(g, b);
		System.out.print("DFS: ");
		dfs(g, b);
	}
}