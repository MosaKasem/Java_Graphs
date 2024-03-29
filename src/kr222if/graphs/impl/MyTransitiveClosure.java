package kr222if.graphs.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import kr222if.graphs.DirectedGraph;
import kr222if.graphs.Node;
import kr222if.graphs.TransitiveClosure;

public class MyTransitiveClosure<T> implements TransitiveClosure<T> {
    List<Node<T>> visited;
    Map<Node<T>, Collection<Node<T>>> graph;
    public MyTransitiveClosure() {
        visited = new ArrayList<Node<T>>();
        graph = new LinkedHashMap<Node<T>, Collection<Node<T>>>();
    }

    private void dfsRecursion(Node<T> node) {
        visited.add(node);
        Iterator<Node<T>> nodeSucc = node.succsOf();
        while (nodeSucc.hasNext()) {
            Node<T> n = nodeSucc.next();
            if (!visited.contains(n)) {
                dfsRecursion(n);
            }
        }
    }
    
    @Override
    public Map<Node<T>, Collection<Node<T>>> computeClosure(DirectedGraph<T> dg) {
        visited.clear();
        
        for (Node<T> node : dg) {
            visited = new ArrayList<Node<T>>();
            dfsRecursion(node);
            graph.put(node, visited);
        }
        /* for (Map.Entry<Node<T>, Collection<Node<T>>> entry : graph.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        } */ // prints out the graph or "map"
        return graph;
    }
}
