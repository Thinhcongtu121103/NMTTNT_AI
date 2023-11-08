package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Greedy implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List explored = new ArrayList<>();
		frontier.add(model.getInitialState());
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getH() == 0) return current;
			else {
				explored.add(current);
				List<Node> children = model.getSuccessors(current);
				for (Node node : children) {
					if (!frontier.contains(node) && !explored.contains(node)) {
						frontier.add(node);
						node.setG(current.getG() + 1);
					}
				}
			}
		}
		return null;
	}

}
