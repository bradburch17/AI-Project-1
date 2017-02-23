import java.util.ArrayList;
import java.util.List;

/**
 * Best First Search class 
 * 
 * Created 2-15-2017
 * @author Brad Burch and Katherine Martin
 */
public class BestFirstSearch {

	private int nodesExpanded = 0;
	private int steps = 0;
	private List<Node> open = new ArrayList<Node>();
	private List<Node> closed = new ArrayList<Node>();
	private List<Node> path	= new ArrayList<Node>();
	private int[][] goalState = {{ 1, 2, 3 },
			 					 { 8, 0, 4 }, 
			 					 { 7, 6, 5 }};	
	
	public BestFirstSearch(){}
	
	//Essentially the main method for Best First Search 
	public void runBestFS(Node startNode)
	{
		bestfs(startNode);
		calculatePath(startNode);
		System.out.println("Path: ");
		for(int i = path.size()-1; i >= 0; i--)
		{
			steps++;
			path.get(i).printNode();
		}
		System.out.println("Steps (from initial state): " + (steps-1));
		System.out.println("Nodes Expanded:             " + nodesExpanded);
	}
	
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
	
	//Checks if a node is in the closed list 
	public boolean isInClosed(Node node)
	{
		for(int i = 0; i< closed.size(); i++)
		{			
			if(areSame(node.getCurrentState(), closed.get(i).getCurrentState()))
			{
				return true;
			}
		}
		return false;
	}
	
	//Calculates the heuristic used for Best First Search 
	public int calculateHeuristic(int[][] currentState)
	{
		State state = new State();
		int[][] goal = state.getGoalState();
		int count = 0;
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if (goal[i][j] != currentState[i][j] && goal[i][j] != 0)
				{
					count++;
				}
			}
		}
		return count;
	}
	

	//Checks if node is the goal state or not
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
	
	//Checks if two 2D arrays are the same
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
	
	//Best First Search Function 
	public void bestfs(Node startNode)
	{
		open.add(startNode);
		Node actualNode = open.get(0);
		
		while(!isGoalState(actualNode.getCurrentState()) && open.size() != 0)
		{
			open.addAll(actualNode.calculateChildren());
			nodesExpanded++;
			
			if (!isInClosed(actualNode))
			{
				closed.add(actualNode);
			}
			
			open.remove(actualNode);
			
			int smallest = open.get(1).getHeuristic();
			Node nextNode = open.get(1);
			
			for(int i = 1; i < open.size(); i++)
			{
				int heuristic = open.get(i).getHeuristic();
				if(heuristic < smallest)
				{
					smallest = heuristic; 
					nextNode = open.get(i);
				}
			}
			
			actualNode = nextNode;
		}
		closed.add(actualNode);
	}
}
