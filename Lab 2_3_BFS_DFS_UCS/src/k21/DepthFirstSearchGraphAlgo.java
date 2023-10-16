package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchGraphAlgo implements ISearchAlgo {
	Stack<Node> frontier = new Stack<>();
	List<Node> explored = new ArrayList<>();
	
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		frontier.add(root);
		
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

        Node startNode = findNode(root, start);
        Node goalNode = findNode(root, goal);

        if (startNode == null || goalNode == null)
            return null;

        frontier.push(startNode);

        while (!frontier.isEmpty()) {
            Node cur = frontier.pop();

            if (cur.equals(goalNode))
                return cur;

            explored.add(cur);

            List<Edge> children = cur.getChildren();
            for (Edge child : children) {
                Node childNode = child.getEnd();
                if (!explored.contains(childNode) && !frontier.contains(childNode)) {
                    frontier.add(childNode);
                    childNode.setParent(cur);
                }
            }
        }

        return null;
    }

    private Node findNode(Node root, String label) {
        if (root.getLabel().equals(label))
            return root;

        for (Edge edge : root.getChildren()) {
            Node childNode = edge.getEnd();
            Node result = findNode(childNode, label);
            if (result != null)
                return result;
        }

        return null;
    }

}
