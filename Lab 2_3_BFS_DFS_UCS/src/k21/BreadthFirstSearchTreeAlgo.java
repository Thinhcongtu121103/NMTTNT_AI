package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchTreeAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            explored.add(current);
            if (current.getLabel().equals(goal)) return current;
            else {
                for (Node child :
                        current.getChildrenNodes()) {
//                    if (!explored.contains(child) && !frontier.contains(child)) {
                        frontier.add(child);
                        child.setParent(current);
//                    }
                }
            }
        }

        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        boolean started = false;
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            explored.add(current);
            if (current.getLabel().equals(goal)) return current;
            if (current.getLabel().equals(start) && !started) {
                frontier.clear();
                explored.clear();
                frontier.add(current);
                current.setParent(null);
                started = true;
            }
            for (Node child :
                    current.getChildrenNodes()) {
//                if (!frontier.contains(child) && !explored.contains(child)) {
                    frontier.add(child);
                    child.setParent(current);
//                }
            }
        }
        return null;
    }}
