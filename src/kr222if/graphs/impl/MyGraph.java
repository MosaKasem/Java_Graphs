package kr222if.graphs.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kr222if.graphs.DirectedGraph;
import kr222if.graphs.Node;

public class MyGraph<T> implements DirectedGraph<T> {
    private List<Node<T>> nodes;
    private int Headcount = 0;
    public MyGraph() {
        nodes = new ArrayList<Node<T>>();
    }

	@Override
	public Node<T> addNodeFor(T item) {
        MyNode<T> node = null;
        if (item == null) {
            throw new NullPointerException("item does not contain any value!");
        }
        if (containsNodeFor(item)) {
            return nodes.get(Headcount);
        } else {
            node = new MyNode<T>(item);
            nodes.add(node);
        }
        System.out.println("Nodes :" + node);
		return node;
	}

	@Override
	public Node<T> getNodeFor(T item) {
		if (item == null) {
            throw new NullPointerException("item does not contain any value!");
        }

        Iterator<Node<T>> n = nodes.iterator();
        while (n.hasNext()) {
            Node<T> node = n.next();
            if (node.item().equals(item)) {
                return node;
            }
        }
        return null;
	}

	@Override
	public boolean addEdgeFor(T from, T to) {
        if (from == null || to == null) {
            throw new NullPointerException("input does not contain any value!");
        }
        if (containsEdgeFor(from, to)) {
            return false;
        }
        Node<T> nodePred = addNodeFor(from);
        Node<T> nodeSucc = addNodeFor(to);
        ((MyNode<T>) nodePred).addSucc(nodeSucc);
        ((MyNode<T>) nodeSucc).addPred(nodePred);
		return true;
	}

	@Override
	public boolean containsNodeFor(T item) {
        if (item == null) {
            throw new NullPointerException("item does not contain any value!");
        }
        Iterator<Node<T>> n = nodes.iterator();
        while (n.hasNext()) {
            if (n.next().item().equals(item)) {
                return true;
            }
        }
		return false;
	}

	@Override
	public void removeNodeFor(T item) {
        Node<T> theNode = getNodeFor(item);
        if (theNode != null) {
            nodes.remove(theNode);
        }
	}

	@Override
	public boolean containsEdgeFor(T from, T to) {
        Node<T> nodeFrom = this.getNodeFor(from);
        Node<T> nodeTo = this.getNodeFor(to);
		if (nodeFrom != null && nodeTo != null) {
            if (nodeFrom.hasSucc(nodeTo) && nodeTo.hasPred(nodeFrom)) {
                return true;
            }
        }
		return false;
	}

	@Override
	public boolean removeEdgeFor(T from, T to) {
        Node<T> nodeFrom = this.getNodeFor(from);
        Node<T> nodeTo = this.getNodeFor(to);
        if (nodeFrom != null && nodeTo != null) { 
            if (nodeFrom.hasSucc(nodeTo) && nodeTo.hasPred(nodeFrom)) {
                ((MyNode<T>) nodeFrom).removeSucc(nodeTo);
                ((MyNode<T>) nodeTo).removePred(nodeFrom);
                return true;
            }
        }
		return false;
	}

    @Override
    public int nodeCount() {
        return nodes.size();
    }

    @Override
    public Iterator<Node<T>> iterator() {
        List<Node<T>> it = new ArrayList<Node<T>>(nodes);
        return it.iterator();
    }

    @Override
    public Iterator<Node<T>> heads() {
        Iterator<Node<T>> it = iterator();
        List<Node<T>> headsList = new ArrayList<Node<T>>();
        while (it.hasNext()) {
            Node<T> node = it.next();
            if (node.isHead()) {
                headsList.add(node);
            }
        }
        return headsList.iterator();
    }

    @Override
    public int headCount() {
        int headCount = 0;
        Iterator <Node<T>> it = heads();
        while (it.hasNext()) {
            Node<T> node = it.next();
            if (node.isHead()) {
                headCount++;
            }
            it.next();
        }
        return headCount;
    }

    @Override
    public Iterator<Node<T>> tails() {
        Iterator<Node<T>> it = iterator();
        List<Node<T>> tailList = new ArrayList<Node<T>>();
        while (it.hasNext()) {
            Node<T> node = it.next();
            if (node.isTail()) {
                tailList.add(node);
            }
        }
        return tailList.iterator();
    }

    @Override
    public int tailCount() {
        int tailCount = 0;
        Iterator <Node<T>> it = heads();
        while (it.hasNext()) {
            Node<T> node = it.next();
            if (node.isTail()) {
                tailCount++;
            }
            it.next();
        }
        return tailCount;
    }

    @Override
    public List<T> allItems() {
        List<T> allItems = new ArrayList<T>();
        Iterator<Node<T>> it = iterator();
        while (it.hasNext()) {
            allItems.add(it.next().item());
        }
        return allItems;
    }

    @Override
    public int edgeCount() {
        int edgeCount = 0;
        Iterator<Node<T>> it = iterator();
        while (it.hasNext()) {
            edgeCount += it.next().inDegree();
        }
        return edgeCount;
    }
    public static void main(String[] args) {
        MyGraph<Integer> graph = new MyGraph<Integer>();
        graph.addNodeFor(1);
        graph.addNodeFor(2);
        graph.addNodeFor(3);
        graph.addNodeFor(4);
        graph.addNodeFor(9999);
        graph.addNodeFor(6);
        graph.addNodeFor(7);
        graph.addNodeFor(8);
        graph.addNodeFor(9);
        // graph.containsNodeFor(2);
        System.out.println(graph.getNodeFor(9999));
        System.out.println(graph.getNodeFor(1).getClass().getCanonicalName()); // magic
    }
}
