import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFSUtil(int v,boolean visited[], StringBuilder sb)
    {
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> i = adj[v].listIterator();

        int j = 0;
        while (i.hasNext()){
            j++;
            int n = i.next();
            if (!visited[n]){
                sb.append("[ " + v + ", " + n + " ] ");
                DFSUtil(n, visited, sb);
            }
        }
    }

    void DFS(int v)
    {
        StringBuilder sb = new StringBuilder();
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited, sb);
        System.out.println("\n" + sb.toString());
    }

    void BFS(int s) {
        StringBuilder sb = new StringBuilder();
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                    sb.append("[ " + s + ", " + n + " ] ");
                }
            }
        }
        System.out.println("\n" + sb.toString());
    }

    public void printTree(){
        for(int i = 1; i < adj.length; i++){
            System.out.print(i + ": ");
            for(int j = 0; j < adj[i].size(); j++){
                System.out.print(adj[i].get(j) + ", ");
            }
            System.out.println();
        }
    }

}
