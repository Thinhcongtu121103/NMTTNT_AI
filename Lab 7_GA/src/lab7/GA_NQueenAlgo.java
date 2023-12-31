package lab7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		initPopulation();
		int k = 0;
		while (k++ < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByTournamentSelection();
				Node child = reproduce(x, y);
				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
					newPopulation.add(child);
					if (child.getH() == 0) return child;
				}
			}
			population = newPopulation;
		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		 Queen queen = node.getState()[rd.nextInt(Node.N)];
		 queen.setRow(rd.nextInt(Node.N));
	}

	public Node reproduce(Node x, Node y) {
		// Enter your code here
		Node node = new Node();
		int c = rd.nextInt(Node.N);
		node.generateBoard();
		for (int i = 0; i < c; i++) {
			node.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			node.setRow(i, y.getRow(i));
		}
		return node;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		// Enter your code here
		int k = rd.nextInt(POP_SIZE);
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(population.get(rd.nextInt(POP_SIZE)));
		}
		
		Node best = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getH() < best.getH()) {
				best = list.get(i);
			}
		}
		return best;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		initPopulation();
		Node node = population.get(rd.nextInt(POP_SIZE));
		return node;
	}
}
