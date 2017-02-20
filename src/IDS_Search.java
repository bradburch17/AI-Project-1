import java.util.ArrayList;
import java.util.Stack;

/**
 * IDS Search class 
 * 
 * Created 2-15-2017
 * @author Brad Burch and Katherine Martin
 */
public class IDS_Search 
{

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

	public void runIDS(Node startNode) 
	{
		int depth = 0;

		while (!isGoalFound) 
		{
			System.out.println();
			dfs(startNode, depth);
			depth++;
		}
	}

	public void dfs(Node startNode, int depth) 
	{
		Stack<int[][]> stack = new Stack<int[][]>();
		currentState.setState(startNode.getCurrentState());
		currentState.setDepthLimit(0);
		stateStack.push(startNode);

		while (!stack.isEmpty()) 
		{
			Node actualNode = stateStack.pop();
			System.out.println(actualNode + "");

			if (actualNode.getCurrentState() == currentState.getGoalState()) 
			{
				// GOAL NODE HAS BEEN FOUND
				isGoalFound = true;

				return;
			}

			else if (actualNode.getCurrentState() != currentState.getGoalState()) 
			{
				currentState.setDepthLimit(currentState.getDepthLimit() + 1);
			}

		}
	}
}