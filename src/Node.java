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
	
//	public Node(){}
	
	public Node(int[][] currentState)
	{
		this.parent = null;
		this.currentState = currentState;
	}
	
	public Node(Node parent, int[][] currentState)
	{
		this.parent = parent;
		this.adjacenciesList = null;
		this.currentState = currentState;
	}
	
	public void addNeighbor(Node node)
	{
		this.adjacenciesList.add(node);
	}
	
	public void addChildren(Node node)
	{
		this.children.add(node);
	}
	
	public Node(int[][] currentState, Node parent)
	{
		this.setCurrentState(currentState);
		this.setParent(parent);
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
	
	public int getY(int num)
	{
		int yPosition = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (currentState[x][y] == num) {
                    yPosition = y;
                    break;
                }
            }
        }
        return yPosition;
	}
	
	public int getX(int num)
	{
		int xPosition = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (currentState[x][y] == num) {
                    xPosition = y;
                    break;
                }
            }
        }
        return xPosition;
	}
	
	public Node moveRight(Node initialState)
	{
		boolean canBreak = false;
		int[][] newState = new int[3][3];
		for(int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (currentState[i][j] == 0)
				{
					if(j <= 1)
					{
						System.out.println("IN RIGHT");
						newState = swap(currentState, i, j, i, j+1);
						canBreak = true;
						break;
					}
				}
			}
				if (canBreak)
				{
					break;
				}
		}
		Node newNode = new Node(this, newState);
		
		if (newNode != null)
			newNode.printNode();
		return newNode;
	}
	
	public Node moveLeft(Node initialState)
	{
		boolean canBreak = false;
		int[][] newState = new int[3][3];
		for(int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (initialState.getCurrentState()[i][j] == 0)
				{
					if(j < 0)
					{
						System.out.println("IN LEFT");
						newState = swap(initialState.getCurrentState(), i, j, i, j-1);
						canBreak = true;
						break;
					}
				}
			}
			if(canBreak)
			{
				break;
			}
		}
		Node newNode = new Node(this, newState);
		if (newNode != null)
			newNode.printNode();
		return newNode;
	}
	
	public Node moveUp(Node initialState)
	{
		int[][] newState = new int[3][3];
		boolean canBreak = false;
		
		for(int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (initialState.getCurrentState()[i][j] == 0)
				{
					if(i > 0)
					{
						System.out.println("IN UP");
						newState = swap(initialState.getCurrentState(), i, j, i-1, j);
						canBreak = true;
						break;
					}
				}
			}
			if(canBreak)
			{
				break;
			}
		}
		Node newNode = new Node(this, newState);
		if (newNode != null)
			newNode.printNode();
		
		return newNode;
	}
	
	public Node moveDown(Node initialState)
	{
		boolean canBreak = false;
		int[][] newState = new int[3][3];
		for(int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (initialState.getCurrentState()[i][j] == 0)
				{
					if(i <= 1)
					{
						System.out.println("IN DOWN");
						newState = swap(initialState.getCurrentState(), i, j, i+1, j);
						canBreak = true;
						break;
					}
				}
			}
			if (canBreak)
			{
				break;
			}
		}
		Node newNode = new Node(this, newState);
		if (newNode != null)
			newNode.printNode();
		return newNode;
	}
	
	public int[][] swap(int[][] state, int x1, int y1, int x2, int y2)
	{
		int temp = state[x1][y1];
		state[x1][y1] = state[x2][y2];
		state[x2][y2] = temp;
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
	}
}
