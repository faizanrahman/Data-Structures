import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addLast(int item) {
        // create a new node
        var newNode = new Node(item);

        // if our list is empty, we need to point both the first(head)/last(tail) nodes to this new node.
        // make this newNode the last node.
        if (isEmpty()) { // this means that list is empty
            first = newNode;
            last = newNode;
        } else { // else we need to append this node at the end of the list.
            last.next = newNode; // we are linking the current last node to this new one.
            last = newNode;
        }
    }

    public void addFirst(int item) {
        // create new node
        var newNode = new Node(item);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while(current != null) {
            if(current.value == item) {
                return index;
            } else {
                current = current.next;
                index++;
            }
        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException();

        // if there is only element
        if (first == last) {
            first = null;
            last = null;
            return;
        }

        var second = first.next;
        first.next = null; // this is done so that garbage collector can remove this variable.
        first = second;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if(first == last) {
            first = null;
            last = null;
            return;
        }

        var previous = getPrevious(last);
        last = previous;
        last.next = null;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while(current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
