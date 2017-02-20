/**
 * Node class 
 * 
 * Created 2-15-2017
 * @author Brad Burch and Katherine Martin
 */
public class Node {
	private int[][] currentState = new int[3][3];
	private Node parent;
	
	public Node(){}
	
	public Node(int[][] currentState)
	{
		this.parent = null;
		this.currentState = currentState;
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

	public void setParent(Node parent) {
		this.parent = parent;
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
	
	public int[][] moveRight(int[][] initialState)
	{
		
		for(int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (initialState[i][j] == 0)
				{
					initialState = swap(initialState, i, j, i, j+1);
				}
			}
		}
		return initialState;
	}
	
	public int[][] moveLeft(int[][] initialState)
	{
		
		for(int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (initialState[i][j] == 0)
				{
					initialState = swap(initialState, i, j, i, j-1);
				}
			}
		}
		return initialState;
	}
	
	public int[][] moveUp(int[][] initialState)
	{
		
		for(int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (initialState[i][j] == 0)
				{
					initialState = swap(initialState, i, j, i-1, j);
				}
			}
		}
		return initialState;
	}
	
	public int[][] moveDown(int[][] initialState)
	{
		
		for(int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (initialState[i][j] == 0)
				{
					initialState = swap(initialState, i, j, i+1, j);
				}
			}
		}
		return initialState;
	}
	
	public int[][] swap(int[][] state, int x1, int y1, int x2, int y2)
	{
		int temp = state[x1][y1];
		state[x1][y1] = state[x2][y2];
		state[x2][y2] = temp;
		return state;
	}
}
