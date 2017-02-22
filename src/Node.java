import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Node class 
 * 
 * Created 2-15-2017
 * @author Brad Burch and Katherine Martin
 */
public class Node {
	private int[][] currentState = new int[3][3];
	private Node parent;
	private List<Node> adjacenciesList;
	private List<Node> children;
	private int depthLevel;	
	private int heuristic;
	private int[][] goalState = {{ 1, 2, 3 },
				{ 8, 0, 4 }, 
				{ 7, 6, 5 }};
	
	//Constructors
	public Node(int[][] currentState)
	{
		this.parent = null;
		this.currentState = new int[3][3];
		this.heuristic = 0;
		
		for(int i=0; i < 3; i++)
		{
			for(int j=0; j < 3; j++)
			{
				this.currentState[i][j] = currentState[i][j];
			}
		}
	}
	
	public Node(Node parent, int[][] currentState)
	{
		this.parent = parent;
		this.adjacenciesList = null;
		this.currentState = new int[3][3];
		this.heuristic = 0;
		
		for(int i=0; i < 3; i++)
		{
			for(int j=0; j < 3; j++)
			{
				this.currentState[i][j] = currentState[i][j];
			}
		}
	}
	
	public Node(Node parent, int[][] currentState, int heuristic)
	{
		this.parent = parent;
		this.adjacenciesList = null;
		this.currentState = new int[3][3];
		this.heuristic = heuristic;
		
		for(int i=0; i < 3; i++)
		{
			for(int j=0; j < 3; j++)
			{
				this.currentState[i][j] = currentState[i][j];
			}
		}
	}
	
	//Getters and Setters for GoalState, CurrentState, Parent, AdjacenciesList, Children, DepthLevel
	public int[][] getGoalState() {
		return goalState;
	}

	public void setGoalState(int[][] goalState) {
		this.goalState = goalState;
	}
	
	public int[][] getCurrentState() 
	{
		return currentState;
	}

	public void setCurrentState(int[][] currentState) 
	{
		this.currentState = currentState;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) 
	{
		this.parent = parent;
	}
	
	public List<Node> getAdjacenciesList() 
	{
		return adjacenciesList;
	}
	
	public List<Node> getChildrenList() 
	{
		return children;
	}
	
	public int getDepthLevel() {
		return depthLevel;
	}

	public void setDepthLevel(int depthLimit) {
		this.depthLevel = depthLimit;
	}
	
	public void setChildren(List<Node> nodes)
	{
		this.children = nodes;
	}
	
	//Add nodes to lists
	public void addNeighbor(Node node)
	{
		this.adjacenciesList.add(node);
	}
	
	public void addChildren(List<Node> node)
	{
		this.children.addAll(node);
	}

	//Gets the X and Y positions for where 0 is
	public int getY()
	{
		int yPosition = 0;

        for (int y = 0; y < 3; y++) 
        {
            for (int x = 0; x < 3; x++) 
            {
                if (currentState[y][x] == 0) 
                {
                    yPosition = y;
                    break;
                }
            }
        }
        return yPosition;
	}
	
	public int getX()
	{
		int xPosition = 0;

        for (int y = 0; y < 3; y++) 
        {
            for (int x = 0; x < 3; x++) 
            {
                if (currentState[y][x] == 0) 
                {
                    xPosition = x;
                    break;
                }
            }
        }
        return xPosition;
	}
	
	//Move methods 
	public Node moveRight(int x, int y)
	{
		if(x < 2)
		{
			int[][] newState = new int[3][3];
			for(int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					newState[i][j] = currentState[i][j];
				}
			}
//			System.out.println("IN RIGHT");
			newState = swap(newState, x, y, x+1, y);
			Node newNode = new Node(this, newState, calculateHeuristic(newState));
//			newNode.printNode();
			
			return newNode;
		}
		return null;
	}
	
	public Node moveLeft(int x, int y)
	{
		if(x > 0)
		{
			int[][] newState = new int[3][3];
			for(int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					newState[i][j] = currentState[i][j];
				}
			}
//			System.out.println("IN LEFT");
			newState = swap(newState, x, y, x-1, y);
			
			Node newNode = new Node(this, newState, calculateHeuristic(newState));
//			newNode.printNode();
				
			return newNode;
		}
		return null;
	}
	
	public Node moveUp(int x, int y)
	{
		if(y > 0)
		{
			int[][] newState = new int[3][3];
			for(int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					newState[i][j] = currentState[i][j];
				}
			}
//			System.out.println("IN UP");
			newState = swap(newState, x, y, x, y-1);
			
			Node newNode = new Node(this, newState, calculateHeuristic(newState));
//			newNode.printNode();
				
			return newNode;
		}
		return null;
	}
	
	public Node moveDown(int x, int y)
	{
		if(y < 2)
		{
			int[][] newState = new int[3][3];
			for(int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					newState[i][j] = currentState[i][j];
				}
			}
//			System.out.println("IN DOWN");
			newState = swap(newState, x, y, x, y + 1);
			
			Node newNode = new Node(this, newState, calculateHeuristic(newState));
//			newNode.printNode();
			
			return newNode;
		}
		return null;
	}
	
	//Calculates the children for each node. 
	public List<Node> calculateChildren()
	{
		List<Node> children = new ArrayList<Node>();
		int x = getX();
		int y = getY();
		
		Node right = moveRight(x, y);
		Node left = moveLeft(x, y);
		Node up = moveUp(x, y);
		Node down = moveDown(x, y);

		if (right != null)
			children.add(right);
		if(left != null)
			children.add(left);
		if (up != null)
			children.add(up);
		if (down != null)
			children.add(down);
		
		return children;
	}
	
	public int[][] swap(int[][] state, int x1, int y1, int x2, int y2)
	{
		int temp = state[y1][x1];
		state[y1][x1] = state[y2][x2];
		state[y2][x2] = temp;
		return state;
	}
	
	public void printNode()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print (currentState[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printChildren()
	{
		for(int i = 0; i < children.size(); i++)
		{
			System.out.println("New Child");
			children.get(i).printNode();
		}
	}
	
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
	
	public int getHeuristic()
	{
		return heuristic;
	}
}
