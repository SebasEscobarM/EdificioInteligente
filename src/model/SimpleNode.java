package model;

public class SimpleNode<E> {
	
	private E item;
    private SimpleNode<E> next;
    private SimpleNode<E> previous;


    public SimpleNode(E element) {
        this.item = element;
        this.next = null;
        this.previous=null;

    }

    public SimpleNode<E> getPrevious() {
        return this.previous;
    }

    public void setPrevious(SimpleNode<E> previous) {
        this.previous = previous;
    }



    public void setItem(E item) {
        this.item = item;
    }


    public E getItem() {
        return item;
    }

    public SimpleNode<E> getNext() {
        return next;
    }

    public void setNext(SimpleNode<E> next) {
        this.next = next;
    }
}

