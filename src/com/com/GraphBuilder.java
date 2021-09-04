package com.com;

import java.util.ArrayList;

public class GraphBuilder {
    public GraphBuilder() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public GraphBuilder(ArrayList<Node> nodes, ArrayList<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    ArrayList<Node> nodes;
    ArrayList<Edge> edges;
    public Graph build(){
        Graph graph = new Graph(nodes, edges);
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        return graph;
    }
    public void add(Node node) {
        nodes.add(node);
    }
    public void add(Edge edge){
        edges.add(edge);
    }
    public void addNodes(ArrayList<Node> nodes)
    {
        nodes.forEach(node -> this.nodes.add(node));
    }
    public void addEdges(ArrayList<Edge> edges)
    {
        edges.forEach(edge -> this.edges.add(edge));
    }

}
