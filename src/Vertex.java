import java.awt.Color;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;

public class Vertex extends Rectangle{
	public Set<Edge> edges;
	static final int radius = 20;
	public Color color = Color.BLACK;
	
	public Vertex(int x, int y) {
		super(x, y, radius, radius);
		edges = new HashSet<Edge>();
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
}
