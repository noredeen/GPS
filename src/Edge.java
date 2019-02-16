public class Edge {
	
	public Vertex v1, v2;
	public int distance;
	public boolean active = false;
	
	public Edge(Vertex v1, Vertex v2) {
		this.v1 = v1;
		this.v2 = v2;
		distance = (int) Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
	}
	
	public Vertex get(Vertex v) {
		if (v.equals(v1))
			return v2;
		return v1;
	}
}
