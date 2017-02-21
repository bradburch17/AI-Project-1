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
	private Node startNode;
	private Node currentNode;
	private Node goalNode;
	private boolean isGoalFound;
	private ArrayList<Node> closed = new ArrayList<Node>();
	
	public IDS_Search(){}

	public void runIDS(Node startNode) 
	{
		int depth = 0;

		while (!isGoalFound) 
		{
			System.out.println("HERE");
			dfs(startNode, depth);
			depth++;
		}
		System.out.println("AFTER WHILE LOOP");
	}

	public void dfs(Node startNode, int depth) 
	{
		Stack<Node> nodeStack = new Stack<>();
		startNode.setDepthLevel(0);
		State currentState = new State();
		
		currentState.setState(startNode.getCurrentState());
		nodeStack.push(startNode);

		while (!nodeStack.isEmpty()) 
		{
			Node actualNode = nodeStack.pop();
			actualNode.printNode();

			if (actualNode.getCurrentState() == currentState.getGoalState()) 
			{
				// GOAL NODE HAS BEEN FOUND
				isGoalFound = true;

				return;
			}

			
			if (actualNode.getDepthLevel() >= depth)
			{
				continue;
			}

			Node temp1 = new Node(actualNode, null);
			Node temp2 = new Node(actualNode, null);
			Node temp3 = new Node(actualNode, null);
			Node temp4 = new Node(actualNode, null);
			
			temp2.moveDown(actualNode);
			temp1.moveRight(actualNode);
			temp3.moveLeft(actualNode);
			temp4.moveUp(actualNode);
			
			actualNode.addChildren(temp1);
			actualNode.addChildren(temp2);
			actualNode.addChildren(temp3);
			actualNode.addChildren(temp4);
			
			for(Node node:actualNode.getChildrenList())
			{
				node.setDepthLevel(actualNode.getDepthLevel());
				nodeStack.push(node);
			}
		}
	}
}