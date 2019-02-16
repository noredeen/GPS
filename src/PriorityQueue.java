import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueue<E> {
	
	private ArrayList<Node<E>> queue = new ArrayList<Node<E>>();
	
	public void add(E info, int p) {
		
		Node<E> node = new Node<E>(info, p);
		
		int start = 0;
		int end = queue.size()-1;
		
		if (queue.size() == 0) {
			queue.add(node);
			return;
		}
		if(queue.get(0).priority < p) {
			queue.add(0, node);
			return;
		}
		if(queue.get(queue.size()-1).priority > p) {
			queue.add(node);
			return;
		}
		
		int middle = 0;
		while(start <= end) {
			middle = (start + end)/2;
			if(p < queue.get(middle).priority) {
				start = middle + 1;
			}
			else if(p > queue.get(middle).priority) {
				end = middle - 1;
			}
			else if(p == queue.get(middle).priority) {
				//add here
				break;
			}
			
		}
		middle = (start + end)/2;
		queue.add(middle+1, node);
		
		
	}
	
	public void updatePriority(E info, int new_p) {
		for (Node<E> node : queue) {
			if(node.info.equals(info)) {
				node = new Node<E>(node.info, new_p);
			}
		}
	}
	
	public boolean contains(E info) {
		for (Node<E> node : queue) {
			if(node.info.equals(info)) {
				return true;
			}
		}
		return false;
	}
	
	public Node<E> pop(){
		return queue.remove(queue.size()-1);
	}
	
	public String toString() {
		String output = "||''''''''''''''''''''''||";
		
		for (Node<E> node : queue) {
			output += "\nInfo:" + node.info + " --> P: " + node.priority;
		}
		
		return output + "\n||''''''''''''''''''''''||";
		
	}
	

	public int size() {
		return queue.size();
	}
	
	
	
	

}
