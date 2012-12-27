///////////////////////////////////////////////////////////////////////////////
// Main Class File:  TestStack.java
// File:             Stack.java
// Semester:         Fall 2011
//
// Author:           Peter Collins pmcollins2@wisc.edu
// CS Login:         pcollins
// Lecturer's Name:  Beck Hasti
// Lab Section:      NA
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A stack implementation which uses an array, and grows to the size needed.
 * 
 * <p>
 * Bugs: none known
 * 
 * @author Peter Collins
 */
public class Stack<E> implements StackADT<E> {
	/**
	 * A private array of the given generic object, used to hold our stack.
	 */
	private E[] data;
	/**
	 * A private representation of the elements in the stack.
	 */
	private int size;

	/**
	 * Constructs a stack with initial size of 32.
	 */
	public Stack() {
		this(32);
	}

	/**
	 * Contructs a stack with the given initial size.
	 * 
	 * @param initialSize
	 *            The initial size to give the underlying array for the stack.
	 */
	public Stack(int initialSize) {
		// Create new array of objects to hold our stack data with size
		// initialSize
		data = (E[]) new Object[initialSize];
		// Initial stack size to 0
		size = 0;
	}

	/**
	 * Is the stack empty?
	 * 
	 * @return true if the stack is empty; false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the top item on the stack (but does not remove it). If the stack
	 * is empty when this method is called, an EmptyStackException is thrown.
	 * 
	 * @return the item from the top of the stack
	 * 
	 * @throws EmptyStackException
	 *             - thrown when the user tries to peek at the top item in an
	 *             empty stack
	 */
	@Override
	public E peek() throws EmptyStackException {
		// If the stack is empty, throw an exception
		if (size == 0) {
			throw new EmptyStackException();
		}
		// Return the top element
		return data[size - 1];
	}

	/**
	 * Pops the top item off the stack. If the stack is empty when this method
	 * is called, an EmptyStackException is thrown.
	 * 
	 * @return the item from the top of the stack
	 * 
	 * @throws EmptyStackException
	 *             - thrown when the user tries to pop an item of the top of an
	 *             empty stack
	 */
	@Override
	public E pop() throws EmptyStackException {
		// If the stack is empty, throw an exception
		if (size == 0) {
			throw new EmptyStackException();
		}
		// Get the top element
		E poppedItem = data[--size];
		// Remove the reference to it in the stack
		data[size] = null;
		// Return that element
		return poppedItem;
	}

	/**
	 * Pushes the given item onto the top of the stack.
	 * 
	 * @param item
	 *            the item to push onto the stack
	 */
	@Override
	public void push(E item) {
		// If we are at the max capacity of the array, grow the array
		if (data.length == size) {
			// Create a new array twice the size
			E[] newData = (E[]) new Object[data.length * 2];
			// Copy the old array to the new bigger array
			System.arraycopy(data, 0, newData, 0, data.length);
			// Set the new array as the data reference
			data = newData;
		}
		// Add the element to the end of the array
		data[size++] = item;
	}

	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return number of items in the stack
	 */
	@Override
	public int size() {
		return size;
	}

}
