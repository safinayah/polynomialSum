package polynomialsumgui;

class Node {
    // reference to the next node in the chain, or null if there isn't one.

    Node next;

    // data carried by this node. could be of any type you need.
    int expo;
   int coe;

    Node() {
    }

    Node(int coe) {
        this.coe = coe;
    }
    // Node constructor

    Node(int expo, int coe) {
        next = null;
        this.coe = coe;
        this.expo = expo;

    }

    public Node(int exp, int coe, Node nextValue) {
        this.next = nextValue;
        this.coe = coe;
        this.expo = expo;

    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        this.next = nextValue;
    }

    public Object getExpo() {
        return expo;
    }

    public void setExpo(int expo) {
        this.expo = expo;
    }

    public Object getCoe() {
        return coe;
    }

    public void setCoe(int coe) {
        this.coe = coe;
    }

    @Override
    public String toString() {
        return ( "+"+this.coe+"x^"+this.expo );

    }
}
