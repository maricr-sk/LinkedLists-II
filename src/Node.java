import java.util.*;

public class Node {

    double data;
    Node next;

    public Node() { this.data = 0.0; }

    public Node(double data) { this.data = data; this.next = null; }

    @Override public String toString() { return " " + data; }

}
