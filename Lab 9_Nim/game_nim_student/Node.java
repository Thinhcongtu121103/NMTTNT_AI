package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		List<Node> successors = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			int current = data.get(i);
			for (int j = 1; j <= current / 2; j++) {
				if (current - j != current / 2) {
					Node node = new Node();
					node.addAll(data);
					node.data.set(i, data.get(i) - j);
					node.add(j);
					if (!successors.contains(node)) {
						successors.add(node);
					}
				}
				

			}
		}
		return successors;
	}
	

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		return this.data.get(0) < 3;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		Collections.sort(data, DESCOMPARATOR);
		Collections.sort(other.data, DESCOMPARATOR);
		return Objects.equals(data, other.data);
	}


	
	

}
