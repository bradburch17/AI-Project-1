/**
 * State class doing stuff 
 * 
 * Created 2-15-2017
 * @author Brad Burch and Katherine Martin
 */
public class State {
	private int[][] state;
	private int depthLimit;
	private int[][] goalState = {{ 1, 2, 3 },
								 { 8, 0, 4 }, 
								 { 7, 6, 5 }};
	
	public State(){}
	
	public State(int[][] state, int depthLimit) 
	{
		this.setState(state);
		this.setDepthLimit(depthLimit);
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

	public int getDepthLimit() {
		return depthLimit;
	}

	public void setDepthLimit(int depthLimit) {
		this.depthLimit = depthLimit;
	}

	public int[][] getState() {
		return state;
	}

	public void setState(int[][] state) {
		this.state = state;
	}

	public int[][] getGoalState() {
		return goalState;
	}

	public void setGoalState(int[][] goalState) {
		this.goalState = goalState;
	}

}
