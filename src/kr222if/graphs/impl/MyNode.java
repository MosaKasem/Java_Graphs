package kr222if.graphs.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
            List<MyNode> predecessors = new ArrayList<>();
            Iterator predsIt = this.predsOf();
            while (predsIt.hasNext()) {
                MyNode<T> pred = (MyNode<T> )predsIt.next();
                predecessors.add(((MyNode<T>)pred));
            }
            for (MyNode pred : predecessors) {
                this.removePred(pred);
                pred.removeSucc(this);
            }


            List<MyNode> successors = new ArrayList<>();
            Iterator succsIt = this.succsOf();
            while (succsIt.hasNext()) {
                MyNode<T> succ = (MyNode<T> )succsIt.next();
                successors.add(((MyNode<T>)succ));
            }
            for (MyNode succs : successors) {
                this.removeSucc(succs);
                succs.removePred(this);
            }
        
    }
}