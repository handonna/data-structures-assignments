package a5;
import java.util.ArrayList;

public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */
    private ArrayList<Edge> _edges = new ArrayList<>();
    private String _name;
    private double _distfromsrcs;

    public NodeImpl(String name) {
        _name = name;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public ArrayList<Edge> getedges() {
        return _edges;
    }

    @Override
    public void addedge(Edge newedge) {
        _edges.add(newedge);
    }

    @Override
    public ArrayList<String> getoutgoingedge() {
        ArrayList<String> outgoingedges = new ArrayList<String>();
        if (_edges.isEmpty()) {
            return outgoingedges;
        }

        for (int i = 0; i < _edges.size(); i++) {
            outgoingedges.add(_edges.get(i).getDest());
        }
        return outgoingedges;
    }

    @Override
    public double distfromsrc() {
        return _distfromsrcs;
    }

    public void adddist(double setd) {
        _distfromsrcs = setd;
    }

    @Override
    public int compareTo(Node ournode) {
        if (this.distfromsrc() < ournode.distfromsrc()) {
            return -1;
        }
        if (this.distfromsrc() > ournode.distfromsrc()) {
            return 1;
        }
        return 0;
    }
}


