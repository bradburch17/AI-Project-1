import java.util.ArrayList;
import java.util.Stack;

public class IDS_Search {
	
	private int moveCounter = 0;
	private Stack<Node> stateStack = new Stack<>();
	private Node startNode;
	private State currentState;
	private Node currentNode;
	private Node goalNode;
	private boolean isGoalFound;
	private ArrayList<Node> closed = new ArrayList<Node>();
	
	public IDS_Search(Node goalNode)
	{
		this.goalNode = goalNode;
	}
	
	public void runIDS(Node startNode){
		
		int depth = 0;
		
		while(!isGoalFound){
			System.out.println();
			dfs(startNode, depth);
			depth++;
		}
	}
	
	public void dfs(Node startNode, int depth){
		Stack<int[][]> stack = new Stack<int[][]>();
		currentState.setState(startNode.getCurrentState());
		currentState.setDepthLimit(0);
		stateStack.push(startNode);
		
		while( !stack.isEmpty() ){
			
			Node actualNode = stateStack.pop();
			System.out.println(actualNode+"");
			
			if(actualNode.getCurrentState() == currentState.getGoalState()){
				// GOAL NODE HAS BEEN FOUND
				isGoalFound = true;
				return;
				
			}
			else if(actualNode.getCurrentState() != currentState.getGoalState()){
				currentState.setDepthLimit(currentState.getDepthLimit()+1);
			}
		}
			
	}
	
//	public void succesor(int[][] currentState)
//	{
//		int[][] newState = new int[3][3];
//		State state = new State();
//		
//		newState = state.moveDown(currentState);
//		
//		if (newState != null)
//		{
//			stateStack.push(newState);
//		}
//		
//		newState = state.moveUp(currentState);
//		
//		if (newState != null)
//		{
//			stateStack.push(newState);
//		}
//		
//		newState = state.moveLeft(currentState);
//		
//		if (newState != null)
//		{
//			stateStack.push(newState);
//		}
//		
//		newState = state.moveRight(currentState);
//		
//		if (newState != null)
//		{
//			stateStack.push(newState);
//		}
//	}
//	
//	public void search(int depthLimit)
//	{
//		boolean found = false;
//		boolean exist = false;
//		boolean checkElement = true;
//		int[][] temp = new int[3][3];
//		
//		currentState = stateStack.pop();
//		closed.add(currentState);
//		succesor(currentState);
//	}
}
