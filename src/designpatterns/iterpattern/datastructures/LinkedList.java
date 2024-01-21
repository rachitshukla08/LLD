package designpatterns.iterpattern.datastructures;

import designpatterns.iterpattern.Iterable;
import designpatterns.iterpattern.Iterator;

public class LinkedList implements Iterable {
    private LinkedListNode head;

    public LinkedList(LinkedListNode head) {
        this.head = head;
    }

    public void insert(LinkedListNode node) {
        LinkedListNode previous = head;
        while (previous.getNext() != null)
            previous = previous.getNext();
        previous.setNext(node);
    }


    @Override
    public Iterator getIterator() {
        return new LinkedListIterator(this.head);
    }
}