import java.util.ArrayList;
import java.util.Stack;

public class IDS_Search {
	
	private int moveCounter = 0;
	private Stack<int[][]> stateStack = new Stack<int[][]>();
	private int[][] startState = new int[3][3];
	private int[][] currentState = new int[3][3];
	private State state = new State();
	private int[][] goalState = new int[3][3];
	private ArrayList<int[][]> closed = new ArrayList<int[][]>();
	
	public IDS_Search(int[][] start)
	{
		this.goalState = state.getGoalState();
		this.startState = start;
	}
	
	public void succesor(int[][] currentState)
	{
		int[][] newState = new int[3][3];
		State state = new State();
		
		newState = state.moveDown(currentState);
		
		if (newState != null)
		{
			stateStack.push(newState);
		}
		
		newState = state.moveUp(currentState);
		
		if (newState != null)
		{
			stateStack.push(newState);
		}
		
		newState = state.moveLeft(currentState);
		
		if (newState != null)
		{
			stateStack.push(newState);
		}
		
		newState = state.moveRight(currentState);
		
		if (newState != null)
		{
			stateStack.push(newState);
		}
	}
	
	public void search(int depthLimit)
	{
		boolean found = false;
		boolean exist = false;
		boolean checkElement = true;
		int[][] temp = new int[3][3];
		
		currentState = stateStack.pop();
		closed.add(currentState);
		succesor(currentState);
	}
}
