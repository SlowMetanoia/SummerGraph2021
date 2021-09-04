package com.com;

public class IncidenceMatrix extends CartesianProduct<Node,Edge,Boolean>{
    public IncidenceMatrix(Graph graph) {
        super((Pair<Node, Edge> input)->{
            return input.getValue2().isConnected(input.getValue1());
        },
                graph.getNodes(), graph.getEdges());
    }
}
