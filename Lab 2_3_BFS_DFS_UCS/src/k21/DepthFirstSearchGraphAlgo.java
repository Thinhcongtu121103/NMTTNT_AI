package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchGraphAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node node = frontier.pop();
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
		return null;
	}

}
