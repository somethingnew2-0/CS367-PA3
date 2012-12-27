///////////////////////////////////////////////////////////////////////////////
// Title:            TestStack
// Files:            TestStack.java, Stack.java
// Semester:         Fall 2011
//
// Author:           Peter Collins pmcollins2@wisc.edu
// CS Login:         pcollins
// Lecturer's Name:  Beck, Hasti
// Lab Section:      NA
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A unit tester for my implementation of the stack class.
 * 
 * <p>
 * Bugs: none known
 * 
 * @author Peter Collins
 */
public class TestStack {

	/**
	 * The main method of the stack unit tester, takes no command line
	 * arguments, prints to stdout for normal operations, and to stderr for test
	 * errors.
	 * 
	 * @param args
	 *            Takes no command line arguments.
	 */
	public static void main(String[] args) {
		// First test all methods (besides push) on a fresh empty stack
		System.out.println("Testing empty stack");
		// Create an empty stack
		Stack<Integer> test = new Stack<Integer>();
		// Test isEmpty
		if (test.isEmpty()) {
			System.out.println("\tisEmpty() correctly returned true");
		} else {
			System.err.println("isEmpty() incorrectly returned false");
		}
		// Test size
		if (test.size() == 0) {
			System.out.println("\tsize() correctly returned 0");
		} else {
			System.err.println("size() incorrectly returned " + test.size());
		}
		// Test peek, should throw error, catch it
		try {
			test.peek();
			System.err.println("peek() didn't throw EmptyStackException");
		} catch (EmptyStackException e) {
			System.out.println("\tpeek() correctly threw EmptyStackException");
		}
		// Test pop, should throw error, catch it
		try {
			test.pop();
			System.err.println("pop() didn't throw EmptyStackException");
		} catch (EmptyStackException e) {
			System.out.println("\tpop() correctly threw EmptyStackException");
		}

		// Test all methods on a fresh stack when adding and removing one object
		System.out
				.println("Testing filling and emptying a stack with one value");
		// Create an empty stack
		test = new Stack<Integer>();
		// Add an object
		test.push(32);
		System.out.println("\tpush(32) to the stack");
		// Test isEmpty
		if (test.isEmpty()) {
			System.err.println("isEmpty() incorrectly returned true");
		} else {
			System.out.println("\tisEmpty() correctly returned false");
		}
		// Test size
		if (test.size() == 1) {
			System.out.println("\tsize() correctly returned 1");
		} else {
			System.err.println("size() incorrectly returned " + test.size());
		}
		// Test peek, shouldn't throw error
		try {
			int i = test.peek();
			if (i == 32) {
				System.out.println("\tpeek() correctly returned 32");
			} else {
				System.err.println("peek() incorrectly returned " + i);
			}
		} catch (EmptyStackException e) {
			System.err.println("peek() incorrectly threw EmptyStackException");
		}
		// Test pop, shouldn't throw error
		try {
			int i = test.pop();
			if (i == 32) {
				System.out.println("\tpop() correctly returned 32");
			} else {
				System.err.println("pop() incorrectly returned " + i);
			}
		} catch (EmptyStackException e) {
			System.err.println("pop() incorrectly threw EmptyStackException");
		}
		// Test isEmpty on newly emptied stack
		if (test.isEmpty()) {
			System.out.println("\tisEmpty() correctly returned true");
		} else {
			System.err.println("isEmpty() incorrectly returned false");
		}
		// Test size on newly emptied stack
		if (test.size() == 0) {
			System.out.println("\tsize() correctly returned 0");
		} else {
			System.err.println("size() incorrectly returned " + test.size());
		}
		// Test peek, should throw error, catch it
		try {
			test.peek();
			System.err.println("peek() didn't throw EmptyStackException");
		} catch (EmptyStackException e) {
			System.out.println("\tpeek() correctly threw EmptyStackException");
		}
		// Test pop, should throw error, catch it
		try {
			test.pop();
			System.err.println("pop() didn't throw EmptyStackException");
		} catch (EmptyStackException e) {
			System.out.println("\tpop() correctly threw EmptyStackException");
		}

		// Test all methods on a fresh stack when adding and removing multiple
		// (three) objects
		System.out
				.println("Testing filling and emptying a stack with multiple values");
		// Create an empty stack
		test = new Stack<Integer>();
		// Add an object
		test.push(32);
		System.out.println("\tpush(32) to the stack");
		// Add an object
		test.push(64);
		System.out.println("\tpush(64) to the stack");
		// Add an object
		test.push(128);
		System.out.println("\tpush(128) to the stack");
		// Test isEmpty
		if (test.isEmpty()) {
			System.err.println("isEmpty() incorrectly returned true");
		} else {
			System.out.println("\tisEmpty() correctly returned false");
		}
		// Test size
		if (test.size() == 3) {
			System.out.println("\tsize() correctly returned 3");
		} else {
			System.err.println("size() incorrectly returned " + test.size());
		}
		// Test peek, shouldn't throw an error
		try {
			int i = test.peek();
			if (i == 128) {
				System.out.println("\tpeek() correctly returned 128");
			} else {
				System.err.println("peek() incorrectly returned " + i);
			}
		} catch (EmptyStackException e) {
			System.err.println("peek() incorrectly threw EmptyStackException");
		}
		// Test pop, shouldn't throw an error
		try {
			int i = test.pop();
			if (i == 128) {
				System.out.println("\tpop() correctly returned 128");
			} else {
				System.err.println("pop() incorrectly returned " + i);
			}
		} catch (EmptyStackException e) {
			System.err.println("pop() incorrectly threw EmptyStackException");
		}
		// Test isEmpty, after first pop
		if (test.isEmpty()) {
			System.err.println("isEmpty() incorrectly returned true");
		} else {
			System.out.println("\tisEmpty() correctly returned false");
		}
		// Test size, after first pop
		if (test.size() == 2) {
			System.out.println("\tsize() correctly returned 2");
		} else {
			System.err.println("size() incorrectly returned " + test.size());
		}
		// Test peek, shouldn't throw an error
		try {
			int i = test.peek();
			if (i == 64) {
				System.out.println("\tpeek() correctly returned 64");
			} else {
				System.err.println("peek() incorrectly returned " + i);
			}
		} catch (EmptyStackException e) {
			System.err.println("peek() incorrectly threw EmptyStackException");
		}
		// Test pop, shouldn't throw an error
		try {
			int i = test.pop();
			if (i == 64) {
				System.out.println("\tpop() correctly returned 64");
			} else {
				System.err.println("pop() incorrectly returned " + i);
			}
		} catch (EmptyStackException e) {
			System.err.println("pop() incorrectly threw EmptyStackException");
		}
		// Test isEmpty after second pop
		if (test.isEmpty()) {
			System.err.println("isEmpty() incorrectly returned true");
		} else {
			System.out.println("\tisEmpty() correctly returned false");
		}
		// Test size after second pop
		if (test.size() == 1) {
			System.out.println("\tsize() correctly returned 1");
		} else {
			System.err.println("size() incorrectly returned " + test.size());
		}
		// Test peek, shouldn't throw an error
		try {
			int i = test.peek();
			if (i == 32) {
				System.out.println("\tpeek() correctly returned 32");
			} else {
				System.err.println("peek() incorrectly returned " + i);
			}
		} catch (EmptyStackException e) {
			System.err.println("peek() incorrectly threw EmptyStackException");
		}
		// Test pop, shouldn't throw an error
		try {
			int i = test.pop();
			if (i == 32) {
				System.out.println("\tpop() correctly returned 32");
			} else {
				System.err.println("pop() incorrectly returned " + i);
			}
		} catch (EmptyStackException e) {
			System.err.println("pop() incorrectly threw EmptyStackException");
		}
		// Test isEmpty, after third and final pop
		if (test.isEmpty()) {
			System.out.println("\tisEmpty() correctly returned true");
		} else {
			System.err.println("isEmpty() incorrectly returned false");
		}
		// Test size, after third and final pop
		if (test.size() == 0) {
			System.out.println("\tsize() correctly returned 0");
		} else {
			System.err.println("size() incorrectly returned " + test.size());
		}
		// Test peek, should throw error, catch it
		try {
			test.peek();
			System.err.println("peek() didn't throw EmptyStackException");
		} catch (EmptyStackException e) {
			System.out.println("\tpeek() correctly threw EmptyStackException");
		}
		// Test pop, should throw error, catch it
		try {
			test.pop();
			System.err.println("pop() didn't throw EmptyStackException");
		} catch (EmptyStackException e) {
			System.out.println("\tpop() correctly threw EmptyStackException");
		}

		// Test the underlying array growth in the stack,
		// shouldn't ever throw an IndexOutOfBoundsException
		System.out.println("Testing stack growth");
		// Create a new stack with underlying array of initial size 1
		test = new Stack<Integer>(1);
		try {
			// Add an object
			test.push(32);
			System.out.println("\tpush(32) to the stack");
			// Add an object, should grow underlying array to 2
			test.push(64);
			System.out.println("\tpush(64) to the stack");
			// Add an object, should grow underlying array to 4
			test.push(128);
			System.out.println("\tpush(128) to the stack");
			// Test isEmpty
			if (test.isEmpty()) {
				System.err.println("isEmpty() incorrectly returned true");
			} else {
				System.out.println("\tisEmpty() correctly returned false");
			}
			// Test size
			if (test.size() == 3) {
				System.out.println("\tsize() correctly returned 3");
			} else {
				System.err
						.println("size() incorrectly returned " + test.size());
			}
			// Test peek, shouldn't throw an error
			try {
				int i = test.peek();
				if (i == 128) {
					System.out.println("\tpeek() correctly returned 128");
				} else {
					System.err.println("peek() incorrectly returned " + i);
				}
			} catch (EmptyStackException e) {
				System.err
						.println("peek() incorrectly threw EmptyStackException");
			}
			// Test pop, shouldn't throw an error
			try {
				int i = test.pop();
				if (i == 128) {
					System.out.println("\tpop() correctly returned 128");
				} else {
					System.err.println("pop() incorrectly returned " + i);
				}
			} catch (EmptyStackException e) {
				System.err
						.println("pop() incorrectly threw EmptyStackException");
			}
			// Test isEmpty, after first pop
			if (test.isEmpty()) {
				System.err.println("isEmpty() incorrectly returned true");
			} else {
				System.out.println("\tisEmpty() correctly returned false");
			}
			// Test size, after first pop
			if (test.size() == 2) {
				System.out.println("\tsize() correctly returned 2");
			} else {
				System.err
						.println("size() incorrectly returned " + test.size());
			}
			// Test peek, shouldn't throw an error
			try {
				int i = test.peek();
				if (i == 64) {
					System.out.println("\tpeek() correctly returned 64");
				} else {
					System.err.println("peek() incorrectly returned " + i);
				}
			} catch (EmptyStackException e) {
				System.err
						.println("peek() incorrectly threw EmptyStackException");
			}
			// Test pop, shouldn't throw an error
			try {
				int i = test.pop();
				if (i == 64) {
					System.out.println("\tpop() correctly returned 64");
				} else {
					System.err.println("pop() incorrectly returned " + i);
				}
			} catch (EmptyStackException e) {
				System.err
						.println("pop() incorrectly threw EmptyStackException");
			}
			// Test isEmpty after second pop
			if (test.isEmpty()) {
				System.err.println("isEmpty() incorrectly returned true");
			} else {
				System.out.println("\tisEmpty() correctly returned false");
			}
			// Test size after second pop
			if (test.size() == 1) {
				System.out.println("\tsize() correctly returned 1");
			} else {
				System.err
						.println("size() incorrectly returned " + test.size());
			}
			// Test peek, shouldn't throw an error
			try {
				int i = test.peek();
				if (i == 32) {
					System.out.println("\tpeek() correctly returned 32");
				} else {
					System.err.println("peek() incorrectly returned " + i);
				}
			} catch (EmptyStackException e) {
				System.err
						.println("peek() incorrectly threw EmptyStackException");
			}
			// Test pop, shouldn't throw an error
			try {
				int i = test.pop();
				if (i == 32) {
					System.out.println("\tpop() correctly returned 32");
				} else {
					System.err.println("pop() incorrectly returned " + i);
				}
			} catch (EmptyStackException e) {
				System.err
						.println("pop() incorrectly threw EmptyStackException");
			}
			// Test isEmpty, after third and final pop
			if (test.isEmpty()) {
				System.out.println("\tisEmpty() correctly returned true");
			} else {
				System.err.println("isEmpty() incorrectly returned false");
			}
			// Test size, after third and final pop
			if (test.size() == 0) {
				System.out.println("\tsize() correctly returned 0");
			} else {
				System.err
						.println("size() incorrectly returned " + test.size());
			}
			// Test peek, should throw error, catch it
			try {
				test.peek();
				System.err.println("peek() didn't throw EmptyStackException");
			} catch (EmptyStackException e) {
				System.out
						.println("\tpeek() correctly threw EmptyStackException");
			}
			// Test pop, should throw error, catch it
			try {
				test.pop();
				System.err.println("pop() didn't throw EmptyStackException");
			} catch (EmptyStackException e) {
				System.out
						.println("\tpop() correctly threw EmptyStackException");
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Stack ran out of space, grew incorrectly");
		}
	}

}
