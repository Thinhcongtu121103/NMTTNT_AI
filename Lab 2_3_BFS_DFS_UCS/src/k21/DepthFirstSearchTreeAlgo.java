package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchTreeAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		ArrayList<Node> explored = new ArrayList<>();
		Stack<Node> frontiers = new Stack<>();
		frontiers.push(root);
		while (!frontiers.isEmpty()) {
			Node current = frontiers.pop();
			explored.add(current);
			if (current.getLabel().equals(goal))
				return current;
			else {
				for (Node child : current.getChildrenNodes()) {
//                    if (!frontiers.contains(child) && !explored.contains(child)) {
					frontiers.push(child);
					child.setParent(current);
//                    }
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		ArrayList<Node> explored = new ArrayList<>();
		Stack<Node> frontiers = new Stack<>();
		boolean started = false;
		frontiers.push(root);
		while (!frontiers.isEmpty()) {
			Node current = frontiers.pop();
			explored.add(current);
			if (current.getLabel().equals(goal))
				return current;
			if (current.getLabel().equals(start) && !started) {
				explored.clear();
				frontiers.clear();
				started = true;
				current.setParent(null);
				frontiers.push(current);
			} else {
				for (Node child : current.getChildrenNodes()) {
//                    if (!frontiers.contains(child) && !explored.contains(child)) {
					frontiers.push(child);
					child.setParent(current);
//                    }
				}
			}
		}
		return null;
	}
}
