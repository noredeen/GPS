import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.RepaintManager;

// a data structure representing a Graph 
public class Graph {
	
	//HashMap<E, Vertex<E>> vertices;
	
	HashSet<Vertex> vertices;
	HashMap<Vertex, Edge> leads_to;
	//Set<Vertex<E>> vertices;
	
	public Graph() {
		vertices = new HashSet<Vertex>();
		leads_to = new HashMap<Vertex,Edge>();
	}
	
	public Vertex addVertex(int x, int y) {
		Vertex v = new Vertex(x, y);
		vertices.add(v);
		return v;
	}
	
	public void addEdge(int x1, int y1, int x2, int y2) {
		boolean c1 = false;
		boolean c2 = false;
		for (Vertex vertex : vertices) {
			
			if(vertex.x == x1 && vertex.y == y1) {
				c1 = true;
			}
			else if(vertex.x == x2 && vertex.y== y2) {
				c2 = true;
			}
			
		}
		
		if (c1 && c2) {
			Edge e = new Edge(getVertex(x1, y1), getVertex(x2, y2));
			getVertex(x1, y1).addEdge(e);
			getVertex(x2, y2).addEdge(e);
		}
		else {
			System.out.println("Graph does not contain the inputted vertices.");
		}

	}
	
	public Vertex getVertex(int x, int y) {
		
		for (Vertex vertex : vertices) {
			
			if(vertex.x == x && vertex.y == y) 
				return vertex;
			
		}
		System.out.println("vertex does not exist");
		return null;
		
	}
	
	public void search(Vertex starting_vertex, Vertex target) {
		
		System.out.println("Started searching");
		
		
		HashMap<Vertex, Integer> distances = new HashMap<Vertex, Integer>();
		
		distances.put(starting_vertex, 0);
		
		for (Vertex vertex : vertices) {
			if(!vertex.equals(starting_vertex))
				distances.put(vertex, Integer.MAX_VALUE);
		}
			
		Vertex start = starting_vertex;
		
		PriorityQueue<Vertex> to_visit = new PriorityQueue<Vertex>();
		
		HashSet<Vertex> visited = new HashSet<Vertex>();
		
		to_visit.add(start, distances.get(start));
		
		//add the first vertex to leads_to with no edge for first time.
		leads_to.put(start, null);
		
		
		
		while(to_visit.size() > 0) {
			System.out.println("run");
			System.out.println(to_visit.size());
			start = to_visit.pop().info;
			//System.out.println(start.x + " " + start.y + " -- " + target.x + " " + target.y);
			
			if(start.equals(target)) {
				buildPath(leads_to, target, starting_vertex);
				break;
			}
			
			
			
			
			for (Edge edge : start.edges) {
				
				if((edge.distance + distances.get(start)) < distances.get(edge.get(start)) && !(visited.contains(edge.get(start)))) {
					distances.put(edge.get(start), edge.distance + distances.get(start));
					System.out.println("added to to_visit");
					if(to_visit.contains(edge.get(start))) {
						//update
						to_visit.updatePriority(edge.get(start), edge.distance + distances.get(start));
					}else {
						//add
						
						to_visit.add(edge.get(start), edge.distance + distances.get(start));
					}
					
					leads_to.put(edge.get(start), edge);
					
				}
				
				
				
				
			}
			
			visited.add(start);
			
			
			//###loop over neighbors
				//###set distances
				//###add all to to_visit priority queue
				//###find minimum distance
			
			
			/*to_visit.remove(0);
			
			//get all edges of a vertex
			for (Edge<E> edge : start.edges) {
				
				//is our target actor connected to the other side of this edge of the current vertex?
				if(edge.get(start).value.equals(target_actor)) {
					
					//put it in leads_to to track its path
					leads_to.put(edge.get(start), edge);
					
					System.out.println();
					
					System.out.println("Kevin Bacon #: " + path_distance(leads_to, edge.get(start), (String)first_vertex.value));
					
					return;
					
				}
				
				//if the vertix on the other side of the current edge hasn't been visited
				//or added to to_visit, then add it to to_visit and its path to leads_to to track in the future.
				if(!leads_to.containsKey(edge.get(start)) && !to_visit.contains(edge.get(start))) {
					leads_to.put(edge.get(start), edge);
					to_visit.add(edge.get(start));
				}
			}
			*/
			
			
			
		}
		
		System.out.println("Done");
		
		//path
		
		
		
		
		
		
		
		System.out.println("done w/ recursion");
		for (Edge edge : path) {
			edge.active = true;
		}
		
		System.out.println("done building");
		System.out.println(path);
		
		
		
	}
	
	
	ArrayList<Edge> path = new ArrayList<Edge>();
	
	public void buildPath(HashMap<Vertex, Edge> leads_to, Vertex start, Vertex target) {
		System.out.println(path);
		
		if(start.equals(target)) 
			return;
		
		path.add(leads_to.get(start));
		
		buildPath(leads_to, leads_to.get(start).get(start), target);
		
		//drawPath(path, leads_to, leads_to.get(start).get(start), target);
		
	}
	
	
	
	
}
