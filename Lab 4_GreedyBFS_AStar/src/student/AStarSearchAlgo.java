package student;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Node node = null;;
		PriorityQueue<Node> frontiers = new PriorityQueue<Node>(new NodeComparatorByFn());
		ArrayList<Node> explored = new ArrayList<>();
		frontiers.add(root);
		while (!frontiers.isEmpty()) {
			Node current = frontiers.poll();
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			for (Edge e : current.getChildren()) {
				Node n = e.getEnd();
				if (!frontiers.contains(n) && !explored.contains(n)) {
					n.setParent(current);
					n.setG(current.getG() + e.getWeight());
					frontiers.add(n);
					n = node;
				}  else if (frontiers.contains(n) && (n.getG() + n.getH()) > (current.getG() + e.getWeight())) {
					n.setG(current.getG() + e.getWeight());
					n.setParent(current);
					n = node;
				}
			}
		}
		return node;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isAdmissibleH(Node root, String goal) {
	}

}
