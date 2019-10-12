package kr222if.graphs.impl;

import java.util.HashSet;
import java.util.Iterator;

import kr222if.graphs.Node;

/**
 * MyNode
 */
public class MyNode<T> extends Node<T> {

    private HashSet< Node < T > > successors; 
    private HashSet< Node < T > > predecessors; 

    protected MyNode(T item) {
        super(item); // Node constructor is called
        successors = new HashSet<Node<T>>();
        predecessors = new HashSet<Node<T>>();
    }

    @Override
    public boolean hasSucc(Node<T> node) {
        if (this.successors.contains(node)) {
            return true;
        }
        return false;
    }

    @Override
    public int outDegree() {
        return successors.size();
    }

    @Override
    public Iterator<Node<T>> succsOf() {
        return successors.iterator();
    }

    @Override
    public boolean hasPred(Node<T> node) {
        if (this.predecessors.contains(node)) {
            return true;
        }
        return false;
    }

    @Override
    public int inDegree() {
        return predecessors.size();
    }

    @Override
    public Iterator<Node<T>> predsOf() {
        return predecessors.iterator();
    }

    @Override
    protected void addSucc(Node<T> succ) {
        successors.add(succ);

    }

    @Override
    protected void removeSucc(Node<T> succ) {
        successors.remove(succ);

    }

    @Override
    protected void addPred(Node<T> pred) {
        predecessors.add(pred);

    }

    @Override
    protected void removePred(Node<T> pred) {
        predecessors.remove(pred);

    }

    @Override
    protected void disconnect() {
        Iterator predsIt = predsOf();
        while(predsIt.hasNext()) {
            MyNode<T> n = (MyNode<T>)predsIt.next();
            n.removeSucc(n);
        }
        Iterator succIt = succsOf();
        while (succIt.hasNext()) {
            MyNode<T> n = (MyNode<T>)succIt.next();
            n.removeSucc(this);
        }
    }
    
}