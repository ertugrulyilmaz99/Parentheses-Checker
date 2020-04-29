import java.util.Iterator;
import java.util.NoSuchElementException;
/** Ertuğrul Yılmaz, ID: 041701030, 16 November 2019 */
/**
 * This class is for stack implementation.
 * Class has the main stack constructor and functions for use.
 * @author Ertuğrul Yılmaz 
 */
public class myStack<Item> implements Iterable<Item> { 
	
	/**
	 * the array of the stack.
	 */
	private Item[] a; // array of items
	private int n; // number of elements on stack
	/**
	 * It is constructor of myStack.
	 */
	public myStack() { 
		a = (Item[]) new Object[2];
		n = 0;
	}
	/**
	 * Get the stack empty or not.
	 * @return The stack is empty or not.
	 */
	public boolean isEmpty() { return n == 0; }
	/**
	 * Get size the of the stack.
	 * @return The size of the stack.
	 */
	public int size() { return n; }
	/**
	 * Resizes the array for use.
	 * @param capacity Capacity of new array.
	 */
	private void resize(int capacity) {
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
		System.out.println(a);
	}
	/**
	 * Pushes the given item to stack.
	 * @param item The element that we want to push to stack.
	 */
	public void push(Item item) {
		if (n == a.length) {
			resize(2 * a.length); // double size of array if necessary
			System.out.print("\n\n << stack doubled >> \n\n");
		}
		a[n++] = item; // add item
	}
	/**
	 * It pops the last element of the stack.
	 * @return The element which was popped.
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = a[n - 1];
		a[n - 1] = null; // to avoid loitering
		n--;
		// shrink size of array if necessary
		if (n > 0 && n == a.length / 4)
			resize(a.length / 2);
		return item;
	}
	/**
	 * To get last element of the stack.
	 * @return the last element of the stack.
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return a[n - 1];
	}
	/**
	 *Creates a Iterator to see private variables.
	 */
	public Iterator<Item> iterator() { 
		return new ReverseArrayIterator();
	}
	/**
	 * @author ertugrulyilmaz
	 * Class allow us to get the private variables.
	 */
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i;
		/**
		 * Getting the index.
		 */
		public ReverseArrayIterator() { i = n - 1; }
		/**
		 *Checks the if there is a next element in array.
		 */
		public boolean hasNext() { return i >= 0; }
		public void remove() { throw new UnsupportedOperationException(); }
		/**
		 *Gets the next item.
		 */
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return a[i--];
		}
	}
}