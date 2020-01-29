package com.queue;

import java.util.NoSuchElementException;

public class ImmutableQueue<T> implements Queue<T>{
	private static class Node<T>{
		
		private T top;
		private Node<T> next;
		private int size;
		
		/**
		 * Constructor and variable initialize
		 */
		private Node() {
			this.top = null;
			this.next = null;
			this.size = 0;
		}
		
		/**
		 * Constructor Overloading
		 * @param t 
		 * @param next 
		 */
		private Node(T t, Node<T> next) {
			this.top = t;
			this.next = next;
			this.size = next.size + 1;
		}
	    
		/**
		 * Push Node (Insert a new node and the current node becomes the next node)
		 * @param t new item
		 */
		public Node<T> push(T t) {
			return new Node<T>(t, this);
		}
		
		/**
		 * Pop Node (Removes current Node and return next Node)
		 * @return Node Next Node
		 */
		public Node<T> pop() {
			if (!this.next.isEmpty()) {
				this.top = this.next.top;
				this.next = this.next.next;
			} else {
				this.top = null;
				this.size = 0;
			}
			return this;
		}
		
		/**
		 * Check the Empty
		 * @return true is empty / false is not empty
		 */
	    public boolean isEmpty(){
	    	return this.size == 0 ;
	    };
	}
	
	private Node<T> head;
	private Node<T> next;
	
	/**
	 * Constructor 
	 * initialize variable head and next(tail);
	 */
	public ImmutableQueue () {
		this.head = new Node<T>();
		this.next = new Node<T>();
	}
	
	/**
	 * Constructor overloading
	 * @param currentQueue
	 * @param newQueue
	 */
	private ImmutableQueue (Node<T> head, Node<T> next) {
		this.head = head;
		this.next = next;
	}

	/**
	 * add a new item and the current item becomes the next item
	 * 
	 * @return Queue Added queue
	 * @throws IllegalArgumentException (if argument is null)
	 */
	public Queue<T> enQueue(T t) {
		if(t != null) {
			return new ImmutableQueue<T>(this.head.push(t), this.head);
		}
		throw new IllegalArgumentException();
	};
	
	/**
	 * Removes the element at the beginning of the immutable queue
	 * and returns the new queue.
	 * @return Queue deQueued queue
	 */
	public Queue<T> deQueue(){
    	if (this.isEmpty())
			throw new NoSuchElementException();
    	if (!this.next.isEmpty())
    		return new ImmutableQueue<T>(this.next, this.next.next);
    	else {
    		return new ImmutableQueue<T>(this.next, new Node<T>());
    	}
	};

	/**
	 * get head
	 * @exception NoSuchElementException (if this.head is null)
	 */
	@Override
    public T head(){
    	if(this.isEmpty())
			throw new NoSuchElementException();
		return this.head.top;
    };
    
	/**
	 * Check the Empty
	 * @return true is empty / false is not empty
	 */
	@Override
    public boolean isEmpty(){
    	return this.head.size == 0;
    };
}
