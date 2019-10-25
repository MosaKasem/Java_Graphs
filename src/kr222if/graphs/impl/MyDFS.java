package kr222if.graphs.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr222if.graphs.DFS;
import kr222if.graphs.DirectedGraph;
import kr222if.graphs.Node;

public class MyDFS<T> implements DFS<T> {
    List<Node<T>> visited;
    List<Node<T>> postOrder;

    int counter;
    public MyDFS() {
        visited = new ArrayList<Node<T>>();
        postOrder = new ArrayList<Node<T>>();
        counter = 0;
    }

    public static void main(String[] args) {
        DirectedGraph<Integer> graph = new MyGraph<Integer>();
        try {
            graph.addNodeFor(0);
            graph.addNodeFor(1);
            graph.addNodeFor(2);
            graph.addNodeFor(3);
            graph.addNodeFor(4);
            graph.addNodeFor(5);
            graph.addNodeFor(6);

            graph.addEdgeFor(0, 1);
            graph.addEdgeFor(0, 2);
            graph.addEdgeFor(2, 3);
            graph.addEdgeFor(2, 5);
            graph.addEdgeFor(5, 3);

            DFS<Integer> depthSearch = new MyDFS<Integer>();
            depthSearch.dfs(graph, graph.getNodeFor(2));
            depthSearch.dfs(graph);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Node<T>> dfsRecursive(Node<T> node) {
        visited.add(node); // Mark as visited
        Iterator<Node<T>> succsIt = node.succsOf();
        node.num = this.counter++;
        while (succsIt.hasNext()) {
            Node<T> successor = succsIt.next();
            if (!visited.contains(successor)) {
                dfsRecursive(successor);
            }
        }
        return visited;
    }

    public List<Node<T>> postOrderRecursive(Node node) {
        Iterator<Node<T>> succsIt = node.succsOf();
        while (succsIt.hasNext()) {
            Node<T> successor = succsIt.next();
            if (!visited.contains(successor)) {
                visited.add(node);
                postOrderRecursive(successor);
            }
        }
        if (!postOrder.contains(node)) {
            postOrder.add(node);
            node.num = this.counter++;
        }
    
        return postOrder;
    }

    @Override
    public List<Node<T>> dfs(DirectedGraph<T> graph, Node<T> root) {
        visited.clear();
        dfsRecursive(root);
        return visited;
    }

    @Override
    public List<Node<T>> dfs(DirectedGraph<T> graph) {
        visited.clear();
        Iterator<Node<T>> graphIt = graph.iterator();
        while (graphIt.hasNext()) {
            Node<T> node = graphIt.next();
            if (!visited.contains(node)) {
                dfsRecursive(node);
            }
        }
        return visited;
    }

    @Override
    public List<Node<T>> postOrder(DirectedGraph<T> g, Node<T> root) {
        visited.clear();
        postOrder.clear();
        this.counter = 0;
        return postOrderRecursive(root);
    }

    @Override
    public List<Node<T>> postOrder(DirectedGraph<T> g) {
        visited.clear();
        postOrder.clear();
        this.counter = 0;
        Iterator<Node<T>> graphIt = g.iterator();
        while (graphIt.hasNext()) {
            Node<T> node = graphIt.next();
            if (!visited.contains(node)) {
                postOrderRecursive(node);
            }
        }
        return postOrder;
    }

    @Override
    public List<Node<T>> postOrder(DirectedGraph<T> g, boolean attach_dfs_number) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<T> graph) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Node<T>> topSort(DirectedGraph<T> graph) {
        // TODO Auto-generated method stub
        return null;
    }

}
