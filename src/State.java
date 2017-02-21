/**
 * State class defining current state of the board 
 * and heuristic information 
 * 
 * Created 2-15-2017
 * @author Brad Burch and Katherine Martin
 */
public class State {
	private int[][] state;
	private int[][] goalState = {{ 1, 2, 3 },
								 { 8, 0, 4 }, 
								 { 7, 6, 5 }};
	
	public State(){}
	
	public State(int[][] state) 
	{
		this.setState(state);
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
