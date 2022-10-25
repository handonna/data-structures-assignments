package a5;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.
                             // key: name of node. value: a5.Node object associated with nameprivate int totaledges;private int totaledges;

    private int totaledges;

    public GraphImpl() {
        nodes = new HashMap<>();
        totaledges = 0;
    }

    @Override
    public boolean addNode(String name) {
        if(nodes.containsKey(name) || name == null){
            return false;
        }
        Node newnode = new NodeImpl(name);
        nodes.put(name, newnode);
        return true;
        //return false;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (nodes.containsKey(src) == false || nodes.containsKey(dest) == false || src == null || dest == null) {
            return false;
        }
        Node ournode = nodes.get(src);
        if (weight < 0){
            return false;
        }
        ArrayList<String> isedgethere = ournode.getoutgoingedge();
        if(isedgethere.contains(dest)){
            return false;
        }
        if (nodes.containsKey(src) && nodes.containsKey(dest)){
            Edge newedge = new EdgeImpl(src, dest, weight);
            ournode.addedge(newedge);
            totaledges++;
            return true;
        }
        return false;

        //return false;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public boolean deleteNode(String name) {
        if (nodes.containsKey(name) == false || name == null) {
            return false;
        }
        if(nodes.containsKey(name)){

            ArrayList neighbors = nodes.get(name).getedges();
            for(int i=0;i<neighbors.size();i++){
                String killit = nodes.get(name).getedges().get(i).getDest();
                Node nodetokill = nodes.get(killit);
                ArrayList node2neighbors = nodetokill.getedges();
                for(int j=0;j<node2neighbors.size();j++){
                    if(nodetokill.getedges().get(i).getDest() == name){
                        nodetokill.getedges().remove(i);
                    }
                }
            }
            nodes.remove(name);
            return true;
        }
        return false;

      //  return false;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if(nodes.containsKey(src)){
            Node ournode = nodes.get(src);
            ArrayList ouredges = ournode.getedges();
            for(int i=0;i<ouredges.size();i++){
                if(ournode.getedges().get(i).getDest() == dest){
                    ournode.getedges().remove(i);
                    totaledges--;
                    return true;
                }
            }
        }
        return false;
        //return false;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public int numNodes() {
        return nodes.size();
        //return 0;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public int numEdges() {
        return totaledges;
       // return 0;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public Map<String, Double> dijkstra(String start) {
        PriorityQueue<Node> processing = new PriorityQueue<>();
        ArrayList<Node> visited = new ArrayList<>();
        Map<String, Double> shortestnodes = new HashMap<>();
        Node srcsnode = nodes.get(start);
        for(Node n: nodes.values()){
            n.adddist(Double.POSITIVE_INFINITY);
        }
        srcsnode.adddist(0);
        processing.add(srcsnode);
        while (processing.size() > 0) {
            Node firstvalue = processing.peek();
            double firstd = firstvalue.distfromsrc();
            processing.poll();
            if(! visited.contains(firstvalue) ){
                visited.add(firstvalue);
                for(Edge e: firstvalue.getedges()){
                    Node ourd = nodes.get(e.getDest());
                    if(firstd+e.getWeight() < ourd.distfromsrc()){
                        ourd.adddist(firstd+e.getWeight());
                        processing.add(ourd);
                    }
                }
                shortestnodes.put(firstvalue.getName(),firstd);
            }
        }
        return shortestnodes;
    }

    public java.util.Set<String> getallnodes() {
        return nodes.keySet();
    }

    public Node getnode(String key) {
        return nodes.get(key);
    }
}
