package polynomialsumgui;

class LinkedList {

    private static int counter;
    Node head;
    private Node last;

    // Default constructor
    public LinkedList() {
        Node n = new Node();
        this.head = n;
        this.last = this.head;
    }

    public void add(Node n) {
        this.last.next = n;
        this.last = this.last.next;
    
     
        incrementCounter();

    }
    
   public void del(Node l,Node n){
       l.next = n.next;
       n.next = null;
   }
            
    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    // returns the number of elements in this list.
    public int size() {
        return getCounter();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node current = this.head.next;

        while (current != null) {
            output.append(current.toString());
            current = current.getNext();
        }

        return output.toString();
    }

    public void cleanup() {//removes all 0 elements from the array. 
        Node curr = this.head;
        Node pos;
        while(curr.next!=null)
        {   curr = curr.next;    
         
            pos = curr;
            while(pos!=null){
                pos=pos.next;
                if( pos == null || pos.coe!=0 ){//search for the next non-zero node, or stop at null.
                   
                    break;//stop
                }
            }
             curr.next=pos;//the next node is either the next null or non-zero
        }
    }


}

