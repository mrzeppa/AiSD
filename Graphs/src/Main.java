import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        FileSupport fs = new FileSupport();
        StringBuilder sb = new StringBuilder();
        Graph g = fs.getEdges(FileSupport.getElemFromFile());
        g.DFS(3);
        System.out.println();
        System.out.println(sb);
        g.BFS(5);
        System.out.println();

        g.printTree();



    }
}
