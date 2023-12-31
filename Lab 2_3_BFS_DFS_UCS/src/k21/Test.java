package k21;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BreadthFirstSearchGraphAlgo();
		ISearchAlgo algo2 = new BreadthFirstSearchTreeAlgo();
		ISearchAlgo algo3 = new DepthFirstSearchGraphAlgo();
		ISearchAlgo algo4 = new DepthFirstSearchTreeAlgo();
		System.out.println(algo1.execute(nodeS, nodeA.getLabel(), "G"));
		System.out.println(NodeUtils.printPath(algo1.execute(nodeS, nodeA.getLabel(), "G")));
		
		UniformCostSearchAlgo algo5 = new UniformCostSearchAlgo();
        Node result = algo5.execute(nodeS, "G", 3);
        System.out.println("UCS: " + NodeUtils.printPath(result));
	}

}
