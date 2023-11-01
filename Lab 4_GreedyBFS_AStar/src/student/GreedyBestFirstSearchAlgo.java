package student;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontiers = new PriorityQueue<Node>(new NodeComparatorByHn());
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
					frontiers.add(n);
					n.setPathCost(current.getG() + e.getWeight());
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
