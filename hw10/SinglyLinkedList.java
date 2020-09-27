import java.util.Collection;

/**
 * Created by Alex on 4/16/2015.
 * @author Alex
 * @version 1.0
 * @param <E> The type of elements to be held in the list
 */
public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Creates a singly linked list with no params
     */
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * An inner class of Nodes to hold data
     */
    private class Node {
        private E data;
        private Node next;

        /**
         * Instantiates a node holding data
         * @param data
         */
        private Node(E data) {
            this.data = data;
        }

        /**
         * Instantiates a node with no data. It holds null
         */
        private Node() {
            this.data = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            System.out.println("Attempted to access index: " + index);
            return null;
        } else {
            Node out = head;
            for (int i = 0; i < index; i++) {
                out = out.next;
            }
            return out.data;
        }
    }

    @Override
    public void add(E data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            size = 1;
        } else {
            Node newTail = new Node(data);
            tail.next = newTail;
            tail = newTail;
            size++;
        }
    }

    @Override
    public boolean add(int index, E data) {
        if (index > size || index < 0) {
            return false;
        } else if (index == size) { //accounts for empty list
            add(data);
            return true;
        } else if (index == 0) {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
            size++;
            return true;
        } else { //index from 1 to size - 1
            Node after = head, before = null;
            for (int i = 0; i < index; i++) {
                before = after;
                after = after.next;
            }
            Node newNode = new Node(data);
            before.next = newNode;
            newNode.next = after;
            size++;
            return true;
        }
    }

    @Override
    public void addAll(Collection<? extends E> c) {
        for (E elt: c) {
            this.add(elt);
        }
    }

    @Override
    public boolean contains(E data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends E> c) {
        for (E elt: c) {
            if (!this.contains(elt)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean remove(E data) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr.data == data) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            return false;
        } else if (curr == head && size == 1) {
            head = null;
            tail = null;
            size = 0;
            return true;
        } else if (curr == head) {
            Node oldHead = head;
            head = head.next; //old head is garbage collected
            oldHead.next = null; //disconnect old head
            size--;
            return true;
        } else {
            if (curr == tail) {
                tail = prev;
            }
            Node after = curr.next;
            prev.next = after; //curr is garbage collected
            size--;
            return true;
        }
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            return null;
        } else if (index == 0) {
            E out = head.data;
            head = head.next;
            if (head == null) { //head was end of list. List had 1 item
                tail = null;
            }
            size--;
            return out;
        } else { //index from 1 to size - 1
            Node after = head, toRemove = null, before = null;
            for (int i = 0; i <= index; i++) {
                before = toRemove;
                toRemove = after;
                after = after.next;
            }
            before.next = after;
            if (after == null) { //aka toRemove was tail
                tail = before;
            }
            size--;
            return toRemove.data;
        }
    }

    @Override
    public boolean removeAll(Collection<? extends E> c) {
        boolean counter = true;
        for (E elt: c) {
            if (!this.remove(elt)) {
                counter = false;
            }
        }
        return counter;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 && head == null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        Node curr = head;
        String out = "";
        System.out.println("Size is: " + size);
        for (int i = 0; i < size; i++) {
            if (curr == null) {
                System.out.println("Null at: " + i);
                continue;
            }
            if (curr.data != null) {
                out += curr.toString() + ", ";
                curr = curr.next;
            }
        }

        if (size != 0) {
            out = out.substring(0, out.length() - 2);
        }

        return out;
    }

    /**
     * Tester method
     * @param args Default param
     */
    /*public static void main(String[] args) {
        SinglyLinkedList<String> s = new SinglyLinkedList<>();
        s.add("Alex");
        s.add("M");
        s.add("Akash");
        s.add("Ryan");
        s.add("asdf");
        s.remove(0);
        s.remove(0);
        s.remove(0);
        s.remove(0);
        System.out.println(s);
    }*/
}
