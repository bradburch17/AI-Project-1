import java.util.ArrayList;
import java.util.List;

public class BestFirstSearch {

	List<Node> open = new ArrayList<Node>();
	List<Node> closed = new ArrayList<Node>();
	List<Node> path	= new ArrayList<Node>();
	int expandedNodes = 0;
	
	
	public BestFirstSearch()
	{
		
	}
	
	public void findPath(Node start)
	{
		for(int i=path.size()-1; i > -1; i--)
		{
			path.get(i).printNode();
		}
	}
	
	/*POTENTIALLY REMOVE*/
	public void addOpen(Node node)
	{
		open.add(node);
	}
	
	public void addClosed(Node node)
	{
		closed.add(node);
	}
	
	public boolean isOpenEmpty()
	{
		return true;
	}
	
	public boolean isInClosed(Node node)
	{
		return true;
	}
	
	public int getPath()
	{
		return path.size();
	}
	
	public int getExpanded()
	{
		return expandedNodes;
	}
	
	public void calculateChildren(Node node)
	{
		List<Node> children = node.calculateChildren();
		while(children.size() !=0)
		{
			Node addChild = children.get(0);
			open.add(addChild);
			children.remove(0);
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
	
	public void bestfs(Node startNode)
	{
		open.add(startNode);
		Node currentNode = open.get(0);
		int[][] goal = currentNode.getGoalState();
		
		
		while(goal != currentNode.getCurrentState() && open.size() != 0)
		{
			calculateChildren(currentNode);
			expandedNodes++;
			
			if (!isInClosed(currentNode))
			{
				addClosed(currentNode);
			}
			
			open.remove(currentNode);
			
//			int smallest = open.get(1).calculateHeuristic();
		}
	}
}
