import java.util.Iterator;
import java.util.ListIterator;

public class LinkList {

    private Node head;

    //constructor
    //make a Node

    //need to have an error for length exception

    //add to end of list
    public void add(double target) {
        Node a = new Node(target);
        Node ptr = head;
        if(ptr == null) {ptr = a; return;}
        while(ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = a;
    }

    public void add(int index, double target){
        int count = 0;
        Node a = new Node(target);
        Node ptr = head;

        if(ptr == null && target != 0) {
            ptr = a;
        }
        while(ptr.next != null && count != target){
            count++;
            ptr = ptr.next;
        }
        if (count == target) {
            ptr = a;
        }
    }

    public void remove(int index){
        if (index == 0) {
            head = head.next;
            return;
        }
        if( index == 1){
            head.next = head.next.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        if(current.next != null)
            current.next = current.next.next;
    }

    public void remove(double target){
        Node ptr = head;
        Node count = null;

        if (head == null){
            return;
        }

        while(ptr != null && ptr.data != target) {
            count = ptr;
            ptr = ptr.next;
        }

        if (ptr != null && ptr.data == target){
            count.next = ptr.next;
            return;
        }
    }

    public void clear(){
        Node ptr = null;
        head = ptr;
    }

    public int size(){
        int count = 0;
        Node ptr = head;
        while(ptr != null){
            count++;
            ptr = ptr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkList moo = new LinkList();
        System.out.println(moo);
        Node a = new Node(1.0);
        Node b = new Node(2.0);
        a.next = b;
        moo.head = a;

        System.out.println(moo);
        moo.clear();
        System.out.println(moo);

        Node g = new Node(1.0);
        Node h = new Node(2.0);
        Node c = new Node(3.0);
        Node d = new Node(4.0);
        Node e = new Node(5.0);
        Node f = new Node(6.0);
        Node i = new Node(7.0);
        Node j = new Node(8.0);
        Node k = new Node(9.0);

        g.next = h;
        h.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = i;
        i.next = j;
        j.next = k;
        moo.head = g;

        System.out.println(moo);
        System.out.println(moo.size());

        for(int m = 1; m <= moo.size(); ++m) {
            if(moo.get(m).data % 2 == 0.0 )
                moo.remove(m);
        }
        System.out.println(moo);
    }

    @Override
    public String toString() {
        Node ptr = head;
        String answer = "[ ";
        while (ptr != null) {
            answer += ptr.toString();
            if (ptr.next != null) {
                answer += ", ";
            }
            ptr = ptr.next;
        }
        answer += " ]";
        return answer;
    }

    
    public Node get(int index){
        Node ptr = head;
        int count = 0;
        while (ptr.next != null && (count+1) != index) {
            ptr = ptr.next;
            ++count;
        }

        if (ptr != null) {
            return ptr;
        }
        return head;
    }

    public void set(int index, double target){
        Node ptr = head;
        int count = 0;
        while (ptr.next != null && (count+1) != index) {
            ptr = ptr.next;
            ++count;
        }
        if (ptr.next != null) {
            ptr.next.data = target;
        }
    }
}
