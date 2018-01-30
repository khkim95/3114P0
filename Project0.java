import java.util.*;
import java.io.*;

//Add imports as needed

public class Project0
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        //Insert your code here
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        int M = scan.nextInt();
        int Q = scan.nextInt();
        
        Graph graph = new Graph(N);            //create a graph with N number of vertices
        
        for (int i = 0; i < M; i++)            //add edges to following vertices
        {
            int src = scan.nextInt();
            int dest = scan.nextInt();
            addEdge(graph, src, dest);
        }
        
        for (int i = 0; i < Q; i++)
        {
            int src = scan.nextInt();
            printVertices(graph,src);
        }
        scan.close();
    }
    
    static class Graph
    {
        int V;
        LinkedList<Integer> adjListArray[];
        
        
        @SuppressWarnings("unchecked")
        Graph(int V)    //constructor
        {
            this.V = V;
            adjListArray = new LinkedList[V+1];
            
            for (int i = 1; i < adjListArray.length; i++)
            {
                adjListArray[i] = new LinkedList<Integer>();
            }
        }
    }
    
    static void addEdge(Graph graph, int src, int dest)
    {
        graph.adjListArray[src].add(dest);        //add edges to both direction since it is undirected.
        graph.adjListArray[dest].add(src);
    }
    
    static void printVertices(Graph graph, int src)
    {
        String out = "";
        if (graph.adjListArray[src].isEmpty())
            out = String.valueOf(-1);
        else
        {
            for (int i = 0; i < graph.adjListArray[src].size(); i++)
            {
                int value = graph.adjListArray[src].get(i);
                out += value + " ";
            }
        }
        System.out.println(out);
    }
    
}

