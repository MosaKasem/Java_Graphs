package kr222if.graphs.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import kr222if.graphs.ConnectedComponents;
import kr222if.graphs.DirectedGraph;
import kr222if.graphs.Node;

public class MyConnectedComponents<T> implements ConnectedComponents<T> {
    List<Node<T>> visited;
    List<Node<T>> connectedList; // this will hold connected components
    Collection<Collection<Node<T>>> connectedCollections; // this will hold multiple collection of connected components

    public MyConnectedComponents() {
        visited = new ArrayList<Node<T>>();
        connectedList = new ArrayList<Node<T>>();
        connectedCollections = new HashSet<Collection<Node<T>>>();
    }

    @Override
    public Collection computeComponents(DirectedGraph dg) {
        connectedList.clear();
        visited.clear();
        connectedCollections.clear();

        for (Iterator<Node<T>> graphIt = dg.iterator(); graphIt.hasNext();) {
            Node<T> n = graphIt.next();
            if (!visited.contains(n)) {
                recursiveConnected(n);
                for (Node<T> currentNode : visited) {
                    if (!connectedList.contains(currentNode)) {
                        for (Collection<Node<T>> collection : connectedCollections) {
                            if (!Collections.disjoint(collection, connectedList)) {
                                collection.addAll(connectedList);
                                connectedList = new ArrayList<Node<T>>();
                            }
                        }
                    }
                }
                if (!connectedList.isEmpty()) {
                    connectedCollections.add(connectedList);
                    connectedList = new ArrayList<Node<T>>();
                }
            }
        }
        // TODO Auto-generated method stub
        return connectedCollections;
    }

    public void recursiveConnected(Node<T> node) {
        visited.add(node); // mark as visited
        connectedList.add(node);
        Iterator<Node<T>> succ = node.succsOf(); // get successor
        Iterator<Node<T>> pred = node.predsOf(); // get successor
        while (succ.hasNext()) {
            Node<T> s = succ.next();
            if (!connectedList.contains(s)) {
                recursiveConnected(s);
            }
        }  
        while (pred.hasNext()) {
            Node<T> p = pred.next();
            if (!connectedList.contains(p)) {
                recursiveConnected(p);
            }
        }
    }

}

/*
 * public class MyConnectedComponents<E> implements ConnectedComponents<E> {
 * MyDFS<E> dfs = new MyDFS<E>(); List<Node<E>> newList = new
 * LinkedList<Node<E>>(); Collection<Collection<Node<E>>> newNodeCollection =
 * new HashSet<>(); private HashSet<Node<E>> nodeList = new HashSet<>(); boolean
 * connected;
 * 
 * // returns all connected components for a dg graph
 * 
 * @Override public Collection<Collection<Node<E>>>
 * computeComponents(DirectedGraph<E> dg) { Iterator<Node<E>> dgIterator =
 * dg.iterator(); Collection<Collection<Node<E>>> nodeCollection = new
 * HashSet<>(); Collection<Node<E>> nodes;
 * 
 * while(dgIterator.hasNext()){ connected = false; Node<E> nextNode =
 * dgIterator.next();
 * 
 * if(nodeList.contains(nextNode) == false){
 * 
 * // stackoverflow nodes = dfs.dfs(dg, nextNode);
 * 
 * for(Node<E> node : nodes){
 * 
 * if(nodeList.contains(node)){
 * 
 * for(Collection<Node<E>> n : nodeCollection){
 * 
 * if(n.contains(node)){ connected = true; nodeList.addAll(nodes);
 * n.addAll(nodes); } } } }
 * 
 * // if the components are not connected if(connected == false){
 * Collection<Node<E>> newNodeCollection = new HashSet<>();
 * nodeList.addAll(nodes); newNodeCollection.addAll(nodes);
 * nodeCollection.add(newNodeCollection); } } } return nodeCollection; } }
 */