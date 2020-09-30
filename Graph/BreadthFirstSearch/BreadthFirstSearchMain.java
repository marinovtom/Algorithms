import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Node
{
	private String nodeName;
	private ArrayList<Node> childNodes;

	public Node(String nodeName, ArrayList<Node> childNodes)
	{
		this.nodeName = nodeName;
		this.childNodes = new ArrayList<Node>(childNodes);
	}

	public String getNodeName()
	{
		return nodeName;
	}

	public ArrayList<Node> getChildNodes()
	{
		return childNodes;
	}
}

class BreadthFirstSearch
{
	private Node startNode;
	private Node endNode;

	public BreadthFirstSearch(Node startNode, Node endNode)
	{
		this.startNode = startNode;
		this.endNode = endNode;
	}

	public boolean execute()
	{
		if(startNode.equals(endNode))
		{
			System.out.println("End node found!");
			System.out.println(startNode.getNodeName());
		}

		Queue<Node> nodeQueue = new LinkedList<>();
		ArrayList<Node> explored = new ArrayList<>();

		nodeQueue.add(startNode);

		while(!nodeQueue.isEmpty())
		{
			Node current = nodeQueue.remove();
			if(explored.contains(current))
			{
				continue;
			}
			
			if(current.equals(endNode))
			{
				System.out.println("End node found!");
				System.out.println(current.getNodeName());

				return true;
			}

			ArrayList<Node> currentChildNodes = current.getChildNodes();
			if(currentChildNodes.isEmpty())
			{
				return false;
			}

			nodeQueue.addAll(currentChildNodes);
			explored.add(current);

		}

		return false;
	}
}

class BreadthFirstSearchMain
{
	public static void main(String[] args)
	{
		ArrayList<Node> childNodes = new ArrayList<>();

		Node endNode = new Node("end node", childNodes);

		childNodes.add(endNode);
		Node child0 = new Node("child 0", childNodes);
		
		childNodes.add(child0);
		Node child1 = new Node("child 1", childNodes);

		childNodes.add(child1);
		Node child2 = new Node("child 2", childNodes);

		childNodes.clear();

		childNodes.add(child2);
		Node startNode = new Node("start node", childNodes);

		BreadthFirstSearch bfs = new BreadthFirstSearch(startNode, endNode);

		bfs.execute();
	}
}