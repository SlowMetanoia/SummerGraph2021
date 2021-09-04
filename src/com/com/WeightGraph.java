package com.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class WeightGraph extends Graph{
    public WeightGraph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
        super(nodes, edges);
    }
    public WeightGraph(Graph graph) {
        super(graph.getNodes(), graph.getEdges());
    }
    HashMap<Integer,ArrayList<Node>> WeightNodeMap;
    HashMap<Integer,ArrayList<Edge>> WeightEdgeMap;
    Function<NodeProxy,Integer> NodeWeightFunction;
    Function<EdgeProxy,Integer> EdgeWeightFunction;

    public void SortNodesByWeight() {
        nodes.forEach(node ->{
            Integer weight = NodeWeightFunction.apply(new NodeProxy(node,this));
            if(WeightNodeMap.get(weight)==null)
                WeightNodeMap.put(weight,new ArrayList<>());
            WeightNodeMap.get(weight).add(node);
        });
    }
    public Graph GetTheBiggestClick() {
        //Клика - подграф, являющийся полным графом.
        //n - число вершин в клике
        //E - число рёбер
        //Ограничения сверху:
        //1. Рёбер в графе: E(G) > n*(n-1)/2, где
        //2. Рёбер в клике: E(K) = n*(n-1)/2
        //3. У всех нод в клике должно быть не менее чем n-1 рёбер
        //Общие положения:
        //1. Функция веса ноды - возвращает количество смежных рёбер.
        //2. Ноды отсортированны в группы с одинаковым весом.
        //3. Проверять на принадлежность к наибольшей клике стоит начиная с самого большого веса.
        //4. В конце работы функция должна вернуть граф к изначальному состоянию.
        //5. Вернуть функция должна пограф, проверив, что выполнено условие (2)
        //6. Если найдена клика размером n, то нет смысла искать клику меньшего или равного размера.
        //7. Поиск можно распаралелить по компонентам связности, однако ограничение снизу для размера клики должно быть общее.
        //8.
        //Варианты алгоритомов:
        /*(1) "В лоб"
        * Рекурсивно перебираем все возможные способы выбрать n из всех вершин, пока n может расти.
        * (2) "В лоб, но хитрее"
        * Начинаем с того, что делим граф на компоненты связности и работаем в рамках каждой отдельно.
        * Если мы удостоверились, что есть клика размера n, убираем из графа все вершины, где n-1 ребро и меньше.
        * Останавливаемся, если упёрлись в ограничения сверху.
        * В остальном - повторяем алгоритм "В лоб"
        * Понятие триангулированного графа
        * 
        * */
        return null;
    }
}
