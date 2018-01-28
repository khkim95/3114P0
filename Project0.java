package Project0.java;

import java.util.*;
import java.io.*;

//Add imports as needed

public class Project0 
{	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		//Insert your code here
		readFile("test1.in");
	}
	
	static class Graph
	{
		int V;
		LinkedList<Integer> adjListArray[];
		
		Graph(int V)	//constructor
		{
			this.V = V;
			adjListArray = new LinkedList[V];
			
			for (int i = 0; i < V; i++)
			{
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	static void addEdge(Graph graph, int src, int dest)
	{
		graph.adjListArray[src].add(dest);		//add edges to both direction since it is undirected.
		//graph.adjListArray[dest].add(src);
	}
	
	static void printGraph(Graph graph)
	{
		for (int v = 0; v < graph.V; v++)
		{
			System.out.println("Adjacency list of vertex " +v);
			System.out.print("head");
			for (Integer i: graph.adjListArray[v])
			{
				System.out.print(" -> " + i);
			}
			System.out.println("\n");
		}
	}
	
	static void printVertices(Graph graph, int src)
	{
		for (Integer i: graph.adjListArray[src])
		{
			System.out.print("At " + src +": ");
			System.out.print(i);
		}
		System.out.print("\n");
	}
	
	
	public static void readFile(String filename) throws FileNotFoundException, IOException
	{
		FileReader fileReader = new FileReader(filename);
		BufferedReader in = new BufferedReader(fileReader);
		

		String s = in.readLine();

		Scanner scan = new Scanner(s);
			
		int N = scan.nextInt();
		int M = scan.nextInt();
		int Q = scan.nextInt();
		
		Graph graph = new Graph(N);			//
		
		for (int i = 0; i < M; i++)			//add edges to following vertices
		{
			String lines = in.readLine();
			Scanner sc = new Scanner(lines);
			int src = sc.nextInt();
			int dest = sc.nextInt();			
			addEdge(graph, src, dest);
		}
		
		printGraph(graph);
		
		for (int i = 0; i < Q; i++)
		{
			String lines = in.readLine();
			Scanner sc = new Scanner(lines);
			int src = sc.nextInt();
			printVertices(graph,src);
		}
		scan.close();
	}
	
}
