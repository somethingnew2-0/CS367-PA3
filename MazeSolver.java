///////////////////////////////////////////////////////////////////////////////
//Main Class File:  MazeSolverDriver.java
//File:             MazeSolver.java
//Semester:         Fall 2011
//
//Author:           Peter Collins pmcollins2@wisc.edu
//CS Login:         pcollins
//Lecturer's Name:  Beck Hasti
//Lab Section:      NA
//
///////////////////////////////////////////////////////////////////////////////

import maze.*;

/**
 * A solver that can solve and print a give maze file.
 * 
 * <p>
 * Bugs: none known
 * 
 * @author Peter Collins
 */
public class MazeSolver {
	/**
	 * A private representation of a given maze file
	 */
	private Maze maze;
	/**
	 * A private representation whether we've tried to solve a maze, and failed.
	 */
	private boolean tried;
	/**
	 * A private representation whether we've tried to solve a maze, and
	 * succeeded.
	 */
	private boolean solved;
	/**
	 * The private representation of the solution in the form of a stack.
	 */
	private Stack<MazePosition> solution;

	/**
	 * Creates a maze solver that is set up to use the maze designated in
	 * filename. If filename does not meet the specifications for a valid maze
	 * file, it throws an InvalidMazeFileException.
	 * 
	 * @param filename
	 *            the maze filename to load
	 * @throws InvalidMazeFileException
	 *             if the maze file is formatted incorrectly
	 */
	public MazeSolver(String filename) throws InvalidMazeFileException {
		setMaze(filename); // Avoiding redundant code, set the maze filename
	}

	/**
	 * Resets the current maze to the one given in filename. If filename does
	 * not meet the specifications for a valid maze file, it throws an
	 * InvalidMazeFileException.
	 * 
	 * @param filename
	 *            the maze filename to load
	 * @throws InvalidMazeFileException
	 *             if the maze file is formatted incorrectly
	 */
	public void setMaze(String filename) throws InvalidMazeFileException {
		// Create new maze representation
		maze = new Maze(filename);
		// Reset tried and solved flags
		tried = false;
		solved = false;
		// Create a new solution stack
		solution = new Stack<MazePosition>();
	}

	/**
	 * Print the current maze (to the console).
	 */
	public void printMaze() {
		// Call the maze print method
		maze.print();
	}

	/**
	 * Solve the current maze.
	 */
	public void solve() {
		// First find the start position in the maze, search through all the
		// rows and columns
		MazePosition start = null;
		MazePosition tmpSearcher;
		for (int col = 0; col < maze.COLS; col++) {
			for (int row = 0; row < maze.ROWS; row++) {
				// Get the current position to search for
				tmpSearcher = maze.getMazePosition(row, col);
				// Is this the start position?
				if (tmpSearcher.isStart()) {
					// Record the start position
					start = tmpSearcher;
					// Break the nested loops
					col = maze.COLS;
					break;
				}
			}
		}

		// Push the start position to the stack, so it it our current position
		solution.push(start);
		// Test going recursively to the north, east, south, and west. If we
		// fail say we tried, otherwise say it's solved.
		if (goNorth() || goEast() || goSouth() || goWest()) {
			solved = true;
		} else {
			tried = true;
		}
	}

	/**
	 * A private method for maze solving that tests going north from the top
	 * position in the solution stack. If it finds the finish either recursively
	 * or at the north position, then it returns true, false if otherwise.
	 * 
	 * @return true if we successful in finding a path, false if otherwise
	 */
	private boolean goNorth() {
		// Get the current position off the solution stack
		MazePosition currentPosition = solution.peek();
		// Get the north position from the maze
		MazePosition northPosition = maze.getMazePosition(
				currentPosition.getRow() - 1, currentPosition.getColumn());
		// Make sure the position exists
		if (northPosition != null) {
			// Add the north position to the path, so it becomes the
			// next current position
			solution.push(northPosition);
			if (northPosition.isFinish()) {
				// If it's the finish then we're done, return true
				return true;
			} else if (northPosition.isClear() && !northPosition.isVisited()) {
				// If it's clear and not already visited, mark it as on the path
				northPosition.markOnPath();
				if (goNorth() || goEast() || goWest()) {
					// If we recursively found a path, then we're done, return
					// true
					return true;
				} else {
					// If we didn't find a path mark this position as visited
					// and remove it from the solution
					northPosition.markVisited();
					solution.pop();
				}
			} else {
				// If it's a wall, already visited, etc. remove it from the
				// solution
				solution.pop();
			}
		}
		// It didn't find a path in this direction
		return false;
	}

	/**
	 * A private method for maze solving that tests going east from the top
	 * position in the solution stack. If it finds the finish either recursively
	 * or at the east position, then it returns true, false if otherwise.
	 * 
	 * @return true if we successful in finding a path, false if otherwise
	 */
	private boolean goEast() {
		// Get the current position off the solution stack
		MazePosition currentPosition = solution.peek();
		// Get the east position from the maze
		MazePosition eastPosition = maze.getMazePosition(
				currentPosition.getRow(), currentPosition.getColumn() + 1);
		// Make sure the position exists
		if (eastPosition != null) {
			// Add the east position to the path, so it becomes the
			// next current position
			solution.push(eastPosition);
			if (eastPosition.isFinish()) {
				// If it's the finish then we're done, return true
				return true;
			} else if (eastPosition.isClear() && !eastPosition.isVisited()) {
				// If it's clear and not already visited, mark it as on the path
				eastPosition.markOnPath();
				if (goEast() || goSouth() || goNorth()) {
					// If we recursively found a path, then we're done, return
					// true
					return true;
				} else {
					// If we didn't find a path mark this position as visited
					// and remove it from the solution
					eastPosition.markVisited();
					solution.pop();
				}
			} else {
				// If it's a wall, already visited, etc. remove it from the
				// solution
				solution.pop();
			}
		}
		// It didn't find a path in this direction
		return false;
	}

	/**
	 * A private method for maze solving that tests going south from the top
	 * position in the solution stack. If it finds the finish either recursively
	 * or at the south position, then it returns true, false if otherwise.
	 * 
	 * @return true if we successful in finding a path, false if otherwise
	 */
	private boolean goSouth() {
		// Get the current position off the solution stack
		MazePosition currentPosition = solution.peek();
		// Get the south position from the maze
		MazePosition southPosition = maze.getMazePosition(
				currentPosition.getRow() + 1, currentPosition.getColumn());
		// Make sure the position exists
		if (southPosition != null) {
			// Add the south position to the path, so it becomes the
			// next current position
			solution.push(southPosition);
			if (southPosition.isFinish()) {
				// If it's the finish then we're done, return true
				return true;
			} else if (southPosition.isClear() && !southPosition.isVisited()) {
				// If it's clear and not already visited, mark it as on the path
				southPosition.markOnPath();
				if (goSouth() || goWest() || goEast()) {
					// If we recursively found a path, then we're done, return
					// true
					return true;
				} else {
					// If we didn't find a path mark this position as visited
					// and remove it from the solution
					southPosition.markVisited();
					solution.pop();
				}
			} else {
				// If it's a wall, already visited, etc. remove it from the
				// solution
				solution.pop();
			}
		}
		// It didn't find a path in this direction
		return false;
	}

	/**
	 * A private method for maze solving that tests going west from the top
	 * position in the solution stack. If it finds the finish either recursively
	 * or at the west position, then it returns true, false if otherwise.
	 * 
	 * @return true if we successful in finding a path, false if otherwise
	 */
	private boolean goWest() {
		// Get the current position off the solution stack
		MazePosition currentPosition = solution.peek();
		// Get the west position from the maze
		MazePosition westPosition = maze.getMazePosition(
				currentPosition.getRow(), currentPosition.getColumn() - 1);
		// Make sure the position exists
		if (westPosition != null) {
			// Add the west position to the path, so it becomes the
			// next current position
			solution.push(westPosition);
			if (westPosition.isFinish()) {
				// If it's the finish then we're done, return true
				return true;
			} else if (westPosition.isClear() && !westPosition.isVisited()) {
				// If it's clear and not already visited, mark it as on the path
				westPosition.markOnPath();
				if (goWest() || goNorth() || goSouth()) {
					// If we recursively found a path, then we're done, return
					// true
					return true;
				} else {
					// If we didn't find a path mark this position as visited
					// and remove it from the solution
					westPosition.markVisited();
					solution.pop();
				}
			} else {
				// If it's a wall, already visited, etc. remove it from the
				// solution
				solution.pop();
			}
		}
		// It didn't find a path in this direction
		return false;
	}

	/**
	 * Prints the solved path to the console, unless it hasn't been solved yet
	 * or is unsolvable.
	 */
	public void printPath() {
		if (tried) {
			// If it tried, but found no solution say so
			System.out
					.println("The current maze has no path from start to finish");
		} else if (solved) {
			// If it solved the maze, print the solution
			int solutionLength = solution.size();
			Stack<MazePosition> tmpSolution = new Stack<MazePosition>();
			// First put the current solution in a temp stack, or reverse order
			for (int i = 0; i < solutionLength; i++) {
				tmpSolution.push(solution.pop());
			}
			// Iterate through this temp stack and print it's maze position, and
			// put the solution back into the solution stack
			for (int i = 0; i < solutionLength; i++) {
				System.out.print(tmpSolution.peek().toString());
				solution.push(tmpSolution.pop());
			}
			// Add a print ln for formatting reasons
			System.out.println();
		} else {
			// If the maze hasn't been attempted to be solved yet, say so
			System.out.println("The current maze has not been solved yet");
		}
	}

}
