package com.com;

public class AdjacencyMatrix extends CartesianProduct<NodeProxy,NodeProxy,Boolean>{
    public AdjacencyMatrix(Graph graph) {
        super((Pair<NodeProxy,NodeProxy> input)->{
            Node n1 = input.getValue1().getNode();
            Node n2 = input.getValue2().getNode();
            return input.getValue1().getGraph().areNodesConnected(n1,n2);
        },graph.getPoxedNodes(),graph.getPoxedNodes());
    }
}
