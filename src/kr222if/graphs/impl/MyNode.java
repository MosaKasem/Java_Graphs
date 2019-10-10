package kr222if.graphs.impl;

import java.util.Iterator;

import kr222if.graphs.Node;

/**
 * MyNode
 */
public class MyNode<T> extends Node<T> {

    protected MyNode(T item) {
        super(item);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean hasSucc(Node<T> node) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int outDegree() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<T>> succsOf() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasPred(Node<T> node) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int inDegree() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<T>> predsOf() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void addSucc(Node<T> succ) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void removeSucc(Node<T> succ) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void addPred(Node<T> pred) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void removePred(Node<T> pred) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void disconnect() {
        // TODO Auto-generated method stub

    }

    
}