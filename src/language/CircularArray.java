package language;

import java.util.Iterator;

/**
 * Implement a CircularArray class that 
 * 1. supports an array like data structure which can be efficiently rotated.
 * The class should use a generic type, 
 * 2. and should support iteration via the standard for (Obj o: circularArray) notation
 */

public class CircularArray<T> implements Iterable<T>{

	private T[] items;
	private int head = 0;
	
	public Iterator<T> iterator(){
		return new CircularArrayIterator<T>(this);
	}
	
	private class CircularArrayIterator<I> implements Iterator<I>{
		private int _current = -1;
		private CircularArray<I> _items;
		
		public CircularArrayIterator(CircularArray<I> array){
			_items = array;
		}
		
		public boolean hasNext(){
			return _current < items.length -1;
		}
		
		public I next(){
			_current ++ ;
			return _items.get(_current);
		}
		public void remove(){
			throw new UnsupportedOperationException("...");
		}
	}
	@SuppressWarnings("unchecked")
	public CircularArray(int size){
		items = (T[]) new Object[size];
	}
	

	public int getPhysicalIndex(int index){
		if(index < 0){
			index += items.length;
		}
		return (head + index) % items.length;
	}
	
	public void rotate(int shiftRight){
		head = this.getPhysicalIndex(shiftRight);
	}
	
	public T get(int i){
		if( i < 0 || i >= items.length){
			throw new java.lang.IndexOutOfBoundsException("..");
		}
		return items[getPhysicalIndex(i)];
	}
	
	public void set(int i, T item){
		items[getPhysicalIndex(i)] = item;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-3%2);
	}

}
