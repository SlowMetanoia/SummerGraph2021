package com.com;

import java.util.ArrayList;

public class Graph {
    final protected ArrayList<Node> nodes;
    final protected ArrayList<Edge> edges;

    public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public ArrayList<NodeProxy> getPoxedNodes() {
        ArrayList<NodeProxy> result = new ArrayList<NodeProxy>();
        for (Node n : getNodes()
        ) {
            result.add(new NodeProxy(n,this));
        }
        return result;
    }
    public Boolean areNodesConnected(Node n1, Node n2){
        for (Edge e:getEdges()
             ) {
            if(e.isConnected(n1)&&e.isConnected(n2))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Graph> GetConnectedSubgraphs() {
        ColoredGraph coloredGraph = new ColoredGraph(this);
        coloredGraph.ColorByConnectedParts();
        return coloredGraph.GetSubgraphsByColor();
    }
    public ArrayList<Node> GetAllConnectedNodes(Node node) {
        ArrayList<Node> result = new ArrayList<>();
        for (Edge e:getEdges()
             ) {
            if(e.isConnected(node)) if (node == e.getFirst())
                result.add(e.getSecond());
            else
                result.add(e.getFirst());
        }
        return result;
    }
    public Graph GetBiggestClick() {

    };
}
