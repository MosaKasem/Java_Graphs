package kr222if.graphs.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kr222if.graphs.BFS;
import kr222if.graphs.DirectedGraph;
import kr222if.graphs.Node;

public class MyBFS<T> implements BFS<T> {
    private Queue<Node<T>> toVisit;
    private List<Node<T>> visited;
    public MyBFS() {
        visited = new ArrayList<Node<T>>();
        toVisit = new LinkedList<Node<T>>(); // the nodes that will be visited
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

            BFS<Integer> breeathFirst = new MyBFS<Integer>();
            List<Node<Integer>> b = breeathFirst.bfs(graph, graph.getNodeFor(0));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Node<T>> bfs_iterateor(DirectedGraph<T> graph, Node<T> node) {
        toVisit.clear();
        visited.clear();
        if (nodeToVisit(node)) {
            return breadthFirstSearch();
        } else if (graph.headCount() >= 1) {
            for (Iterator<Node<T>> headIt = graph.heads(); headIt.hasNext();) {
                Node<T> head = headIt.next();
                toVisit.add(head);
            }
            return breadthFirstSearch();
        } else {
            toVisit.add(graph.getNodeFor(graph.allItems().get(0))); // get the nodes, add the first node from list
            return breadthFirstSearch();
        }
    }

    public ArrayList<Node<T>> breadthFirstSearch() {
        ArrayList<Node<T>> bfsSearch = new ArrayList<Node<T>>();
        while (!toVisit.isEmpty()) {
            // Store the node
            Node<T> node = toVisit.poll();
            if (!visited.contains(node)) {
                visited.add(node); // add node to visited (mark as visited)
                bfsSearch.add(node); // traverse.
                node.num = visited.size();
                Iterator<Node<T>> successors = node.succsOf();
                while (successors.hasNext()) {
                    Node<T> successor = successors.next();
                    if (!visited.contains(successor)) {
                        toVisit.add(successor); // add it to 
                    }
                }
            }
        }
        return bfsSearch;
    }

    public boolean nodeToVisit(Node<T> n) {
        if (n != null) {
            toVisit.add(n);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Node<T>> bfs(DirectedGraph<T> graph, Node<T> root) {
        return bfs_iterateor(graph, root);
    }

    @Override
    public List<Node<T>> bfs(DirectedGraph<T> graph) {
        return bfs_iterateor(graph, null);
    }

}
