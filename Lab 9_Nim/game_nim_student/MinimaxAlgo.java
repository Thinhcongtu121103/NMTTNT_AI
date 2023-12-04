package game_nim_student;

import java.util.List;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		// Enter your code here
		int v = node.;
		if (node.isTerminal())
			return node.getValue();
		if (v < Integer.MIN_VALUE) {
			List<Node> list = node.getChildren();
			for (Node node2 : list) {
				v = Math.max(v, minValue(node2));
			}
		}
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		// Enter your code here
		int v = node.getValue();
		if (node.isTerminal())
			return node.getValue();
		if (v < Integer.MAX_VALUE) {
			List<Node> list = node.getChildren();
			for (Node node2 : list) {
				v = Math.min(v, maxValue(node2));
			}
		}
		return Integer.MAX_VALUE;
	}
}
