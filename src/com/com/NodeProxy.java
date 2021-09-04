package com.com;

public class NodeProxy implements NodeProx{
    private final Node node;
    private final Graph graph;
    public NodeProxy(Node node, Graph graph) {
        this.node = node;
        this.graph = graph;
    }
    @Override
    public Object GetValue() {
        return node.GetValue();
    }

    public Node getNode() {
        return node;
    }

    public Graph getGraph() {
        return graph;
    }
}
