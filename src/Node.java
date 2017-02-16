
public class Node {
	private int[][] currentState = new int[3][3];
	private Node parent;
	
	public Node()
	{
		this.setParent(null);
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
	
}
