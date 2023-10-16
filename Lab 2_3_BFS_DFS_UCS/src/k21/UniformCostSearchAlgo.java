package k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontiers = new PriorityQueue<Node>(new NodeComparator());
		ArrayList<Node> explored = new ArrayList<>();
		frontiers.offer(root);
		root.setPathCost(0);
		while (!frontiers.isEmpty()) {
			Node current = frontiers.poll();
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			for (Edge e : current.getChildren()) {
				Node n = e.getEnd();
				if (!frontiers.contains(n) && !explored.contains(n)) {
					n.setParent(current);
					n.setPathCost(current.getPathCost() + e.getWeight());
					frontiers.add(n);
				} else if (frontiers.contains(n) && n.getPathCost() > (current.getPathCost() + e.getWeight())) {
					n.setPathCost(current.getPathCost() + e.getWeight());
					n.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontiers = new PriorityQueue<Node>(new NodeComparator());
		ArrayList<Node> explored = new ArrayList<>();
		frontiers.offer(root);
		boolean started = false;
		root.setPathCost(0);
		while (!frontiers.isEmpty()) {
			Node current = frontiers.poll();
			if (current.getLabel().equals(start) && !started) {
				started = true;
				for (Node e : frontiers) {
					e.setPathCost(0);
				}
				frontiers.clear();
				for (Node e : explored) {
					e.setPathCost(0);
				}
				explored.clear();
				current.setParent(null);
				frontiers.offer(current);
			}
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			for (Edge e : current.getChildren()) {
				Node n = e.getEnd();
				if (!frontiers.contains(n) && !explored.contains(n)) {
					n.setParent(current);
					n.setPathCost(current.getPathCost() + e.getWeight());
					frontiers.add(n);
				} else if (frontiers.contains(n) && n.getPathCost() > (current.getPathCost() + e.getWeight())) {
					n.setPathCost(current.getPathCost() + e.getWeight());
					n.setParent(current);
				}
			}
		}
		return null;
	}

	public Node execute(Node root, String goal, int limit) {
		if (root.getLabel().equals(goal))
			return root;
		else if (limit == 0)
			return null;
		else {
			if (limit != 0) {
				for (Node child : root.getChildrenNodes()) {
					child.setParent(root);
					Node result = execute(child, goal, limit - 1);
					if (result != null) {
						return result;
					}
				}
			}
			return null;
		}
	}
}