package kr222if.graphs.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import kr222if.graphs.ConnectedComponents;
import kr222if.graphs.DirectedGraph;
import kr222if.graphs.Node;

public class MyConnectedComponents<T> implements ConnectedComponents<T> {

    List<Node<T>> visited;
    List<Node<T>> collectionList;
    Collection<Collection<Node<T>>> connectedCollection;
    public MyConnectedComponents() {
        visited = new ArrayList<Node<T>>();
        collectionList = new ArrayList<Node<T>>();
        connectedCollection = new HashSet<Collection<Node<T>>>();
    }

    @Override
    public Collection computeComponents(DirectedGraph dg) {
        collectionList.clear();
        visited.clear();

         
        Iterator<Node<T>> graphIt = dg.iterator();
        while (graphIt.hasNext()) {
            Node<T> n = graphIt.next();
            if (!visited.contains(n)) {
                recursiveConnected(n);
            }
            for (Collection<Node<T>> collection : connectedCollection) {

            }
        }
        // TODO Auto-generated method stub
        return null;
    }

    public void recursiveConnected(Node<T> node) {
        visited.add(node); // mark as visited
        collectionList.add(node);
        Iterator<Node<T>> n = node.succsOf(); // get successor
        while (n.hasNext()) {
            Node<T> succ = n.next();
            if (!collectionList.contains(succ)) {
                recursiveConnected(succ);
            }
        }
    }

}
