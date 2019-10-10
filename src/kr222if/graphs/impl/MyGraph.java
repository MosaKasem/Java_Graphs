package kr222if.graphs.impl;

import java.util.Iterator;
import java.util.List;

import kr222if.graphs.DirectedGraph;
import kr222if.graphs.Node;

public class MyGraph<T> implements DirectedGraph<T> {

	@Override
	public Node<T> addNodeFor(T item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> getNodeFor(T item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEdgeFor(T from, T to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsNodeFor(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeNodeFor(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsEdgeFor(T from, T to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdgeFor(T from, T to) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public int nodeCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Node<T>> heads() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int headCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<T>> tails() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int tailCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<T> allItems() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int edgeCount() {
        // TODO Auto-generated method stub
        return 0;
    }

}
