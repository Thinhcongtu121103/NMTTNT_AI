package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchGraphAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equals(goal)) {
				return node;
			}
			explored.add(node);
			List<Node> nodeChilds = node.getChildrenNodes();
			for (Node nodeChild : nodeChilds) {
				if (!frontier.contains(nodeChild) && !explored.contains(nodeChild)) {
					frontier.add(nodeChild);
					nodeChild.setParent(node);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		boolean started = true;
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equals(start)) {
				frontier.clear();
				explored.clear();
				node.setParent(null);
			}
			
			if (node.getLabel().equals(goal) && started) {
				return node;
			}
			explored.add(node);
			List<Node> nodeChilds = node.getChildrenNodes();
			for (Node nodeChild : nodeChilds) {
				if (!frontier.contains(nodeChild) && !explored.contains(nodeChild)) {
					frontier.add(nodeChild);
					nodeChild.setParent(node);
				}
			}
		}
		return null;
	}

}
