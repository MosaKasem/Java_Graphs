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
        this.successors = new HashSet<Node<T>>();
        this.predecessors = new HashSet<Node<T>>();
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
        for (Node<T> s : this.successors) {
            MyNode<T> node = (MyNode<T>) s;
            node.removePred(this);
        }
        for (Node<T> p : this.predecessors) {
            MyNode<T> node = (MyNode<T>) p;
            node.removePred(this);
        }
        this.successors.clear();
        this.predecessors.clear();
/*         Iterator<Node<T>> succsIt = succsOf();
        while (succsIt.hasNext()) {
            MyNode<T> node = (MyNode<T>) succsIt.next();
            
                node.removePred(this);
            
            
                this.removeSucc(node);
            
        }            
        Iterator<Node<T>> predsIt = predsOf();
        while (predsIt.hasNext()) {
            MyNode<T> node = (MyNode<T>) predsIt.next();
            
                node.removeSucc(this);
            
            
                this.removePred(node);
            
        } */
    }
}