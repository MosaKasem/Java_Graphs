package kr222if.graphs.impl;

import java.util.Collection;

import kr222if.graphs.ConnectedComponents;
import kr222if.graphs.DirectedGraph;

public class MyConnectedComponents<T> implements ConnectedComponents<T> {

    private DirectedGraph dg;

    @Override
    public Collection computeComponents(DirectedGraph dg) {
        this.dg = dg;
        // TODO Auto-generated method stub
        return null;
    }

}
