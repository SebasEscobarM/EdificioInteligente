package model;

public class PairNode<T,E> {
	//T sera el nombre de la persona
	//E sera la oficina a la que se dirige
	private T key;
    private E item;
    private PairNode<T,E> next;
    private PairNode<T,E> previous;


    public PairNode(T key,E element) {
    	this.key = key;
        this.item = element;
        this.next = null;
        this.previous=null;

    }

    public PairNode<T,E> getPrevious() {
        return this.previous;
    }

    public void setPrevious(PairNode<T,E> previous) {
        this.previous = previous;
    }



    public void setItem(E item) {
        this.item = item;
    }


    public E getItem() {
        return item;
    }

    public T getKey() {
    	return key;
    }

    public PairNode<T,E> getNext() {
        return next;
    }

    public void setNext(PairNode<T,E> next) {
        this.next = next;
    }
}
