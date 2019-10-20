package kr222if.graphs.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr222if.graphs.DirectedGraph;
import kr222if.graphs.GML;
import kr222if.graphs.Node;

public class MyGML<T> extends GML<T> {
    List<Node<T>> edges = new ArrayList<Node<T>>();
    public MyGML(DirectedGraph<T> dg) {
        super(dg);
    }

	@Override
    public String toGML() {
        String gmlString = "graph [\n";
        Iterator<Node<T>> graphIt = graph.iterator();
        MyGraph g=(MyGraph)graph; // in order to call indexOf
        while (graphIt.hasNext()) {
            Node<T> node=graphIt.next();
            int id = g.indexOf(node);
            gmlString += "node [ \n";
            gmlString += makeNode(id, "node " + id);
            Iterator<Node<T>>  nodesuccs=node.succsOf();
            while (nodesuccs.hasNext()) {
                Node<T> successor=nodesuccs.next();
                int succid = g.indexOf(successor);
                gmlString += makeEdge(id, succid, id + "->" + succid);
                // "1->2"
            }
        }
        return null;
    }

    public String makeNode(int id, String label) {
        return "\tid " + id + "\n\t\tlabel " + label + "\t\n]";
    } 

    public String makeEdge(int source, int target, String label) {
        return "\n\tedge [\n\t\tsource " + source + "\n\t\t" + "target " + target + "\n\t\tlabel " + label;
    }
   public static void main(String[] args) {
       DirectedGraph<Integer> g = new MyGraph<Integer>();
       		try {
			g.addNodeFor(1); // Add some nodes.
				
		} catch(Exception e) { e.printStackTrace(); } // Handles exception.
		
		MyGML<Integer> gml = new MyGML<Integer>(g);
		System.out.println(gml.toGML());
		gml.dumpGML();
   }
}
