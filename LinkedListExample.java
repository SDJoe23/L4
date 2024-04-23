import java.util.NoSuchElementException;

class Node {
    int value;
    Node next;
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class LinkedList {
    Node root;

    public LinkedList() {
        this.root = null;
    }

    /**
     * Adds the value to the _beginning_ of the list
     * @param value the value to add
     */
    public void prepend(int value) {
        // Just add at the beginning
        this.root = new Node(value, this.root);
    }

    /**
     * Adds the value to the _end_ of the list
     * @param value the value to add
     */
    public void append(int value) {
        if (this.root == null) {
            this.root = new Node(value, null);
            return;
        }
        Node n = this.root;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(value, null); // Correctly append at the end
    }

    /**
     * Returns the value of the first element in the list
     * @return the value of the first node
     */
    public int first() {
        if (this.root == null) {
            throw new NoSuchElementException("The list is empty.");
        }
        return this.root.value;
    }

    /**
     * Returns the value of the last element in the list
     * @return the value of the last node
     */
    public int last() {
        if (this.root == null) {
            throw new NoSuchElementException("The list is empty.");
        }
        Node n = this.root;
        while (n.next != null) {
            n = n.next;
        }
        return n.value;
    }

    /**
     * Returns a string representation of the list
     * @return string representing the list values
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = this.root;
        while (n != null) {
            sb.append(n.value).append(" ");
            n = n.next;
        }
        return sb.toString().trim(); // Remove the trailing space
    }

    /**
     * Returns the number of elements in the list
     * @return the length of the list
     */
    public int length() {
        int length = 0;
        Node n = this.root;
        while (n != null) {
            length++;
            n = n.next;
        }
        return length;
    }
}
