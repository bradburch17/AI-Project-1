import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * IDS class 
 * 
 * Created 2-15-2017
 * @author Brad Burch and Katherine Martin
 */
public class IDS_Search 
{
	private int nodesExpanded = 0;
	private int steps = 0;
	private boolean isGoalFound;
	private ArrayList<Node> childrenList = new ArrayList<Node>();
	private ArrayList<Node> closed = new ArrayList<Node>();
	private ArrayList<Node> path = new ArrayList<Node>();
	private int[][] goalState = {{ 1, 2, 3 },
								 { 8, 0, 4 }, 
								 { 7, 6, 5 }};
	
	public IDS_Search(){}

	//Essentially the main method for IDS
	public void runIDS(Node startNode) 
	{
		int depth = 0;

		while (!isGoalFound) 
		{
			dfs(startNode, depth);
			depth++;
		}
		calculatePath(startNode);
		System.out.println("DONE");
		System.out.println("Path: ");
		for(int i = path.size()-1; i >= 0; i--)
		{
			steps++;
			path.get(i).printNode();
		}
		System.out.println("Steps:          " + (steps-1));
		System.out.println("Nodes Expanded: " + nodesExpanded);
	}
	
	//Checks if a node is  the goal state
	public boolean isGoalState(int[][] checkState)
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if (checkState[i][j] != goalState[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	//Checks if two nodes are the same 
	public boolean areSame(int[][] firstState, int[][] secondState)
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if (firstState[i][j] != secondState[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	//Checks if the node is in the closed list
	public boolean isInClosed(Node node)
	{
		for(int i = 0; i< closed.size(); i++){			
			if(areSame(node.getCurrentState(), closed.get(i).getCurrentState()))
			{
				return true;
			}
		}
		return false;
	}
	
	//Calculates the path taken to reach the goal node 
	public void calculatePath( Node startNode )
	{
		Node currentNode = closed.get(closed.size()-1);
		path.add(currentNode);
		
		while(!areSame(startNode.getCurrentState(), currentNode.getCurrentState()))
		{
			Node parent = currentNode.getParent();
			path.add(parent);
			currentNode = parent;
		}
	}
	
	//DFS function for IDS
	public void dfs(Node startNode, int depth) 
	{
		Stack<Node> nodeStack = new Stack<>();
		startNode.setDepthLevel(0);
		State currentState = new State();
		
		currentState.setState(startNode.getCurrentState());
		nodeStack.push(startNode);
		childrenList.add(startNode);

		while (!nodeStack.isEmpty()) 
		{
			Node actualNode = nodeStack.pop();
			childrenList.addAll(actualNode.calculateChildren());
			nodesExpanded++;
			
			if (!isInClosed(actualNode))
			{
				closed.add(actualNode);
			}
			childrenList.remove(actualNode);
			
			if (isGoalState(actualNode.getCurrentState())) 
			{
				isGoalFound = true;

				return;
			}
			
			if (actualNode.getDepthLevel() >= depth)
			{
				continue;
			}
			
			for(Node node : childrenList)
			{
				node.setDepthLevel(actualNode.getDepthLevel() + 1);
				nodeStack.push(node);
			}
			childrenList.clear();
		}
	}
}