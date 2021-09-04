package com.com;

import java.util.ArrayList;
import java.util.HashMap;
//"раскрашенный граф" удобен для решения задач выделения непересекающихся множеств вершин графа.
public class ColoredGraph extends Graph{
    Integer IterationsCounter = 0;
    //"схема раскраски" Таким образом можно избавиться от написания поиска.
    HashMap<Node, Integer> NodeColorScheme;
    HashMap<Edge, Integer> EdgeColorScheme;
    //текущий цвет
    Integer NodeColor = 0;
    Integer EdgeColor = 0;
    public ColoredGraph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
        super(nodes, edges);
    }
    public ColoredGraph(Graph graph) {
        super(graph.getNodes(), graph.getEdges());
    }
    public void ColorByConnectedParts() {
        while (GetNotColored(getNodes()).size()==0)
        {
            NodeColor++;
            FullColorConnectedPart(GetNotColored(getNodes()).get(0));
        }
        ColorEdgesByNodes();
    }
    private ArrayList<Node> GetNotColored(ArrayList<Node> nodes) {
        ArrayList<Node> result = new ArrayList<>();
        for (Node n:nodes) if (NodeColorScheme.get(n) == null) result.add(n);
        return result;
    }
    private void FullColorConnectedPart(Node node) {
        IterationsCounter++;
        if(NodeColorScheme.get(node)==null) NodeColorScheme.put(node, NodeColor);
        for(Node n: GetAllConnectedNodes(node)) FullColorConnectedPart(n);
        ColorEdgesByNodes();
    }
    private void ColorEdgesByNodes() {
        for (Edge e:getEdges()
             ) {
            if(GetColor(e.getFirst())==GetColor(e.getSecond()))
                EdgeColorScheme.put(e,GetColor(e.getFirst()));
        }
    }
    private Integer GetColor(Node node) { return NodeColorScheme.get(node);}
    private Integer GetColor(Edge edge) { return EdgeColorScheme.get(edge);}
    public ArrayList<Graph> GetSubgraphsByColor() {
        ArrayList<Integer> Colors = new ArrayList<>();
        //Определяем все возможные цвета
        for (Integer color:NodeColorScheme.values())
            if (!Colors.contains(color))
                Colors.add(color);
        GraphBuilder graphBuilder = new GraphBuilder();
        //Для каждого цвета создаём свой граф
        ArrayList<Graph> result = new ArrayList<Graph>();
        for (Integer color:Colors) {
            for (Node node : nodes) if (GetColor(node) == color) graphBuilder.add(node);
            for (Edge edge:edges) if (GetColor(edge) == color) graphBuilder.add(edge);
            result.add(graphBuilder.build());
        }
        return result;
    }
}