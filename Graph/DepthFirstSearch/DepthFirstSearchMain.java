import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

class Node
{
	private int nodeValue;
	private ArrayList<Node> childNodes;
	private boolean isVisited;

	public Node(int nodeValue)
	{
		this.nodeValue = nodeValue;
		this.childNodes = new ArrayList<Node>();
	}

	public Node(int nodeValue, ArrayList<Node> childNodes)
	{
		this.nodeValue = nodeValue;
		this.childNodes = new ArrayList<Node>(childNodes);
		this.isVisited = false;
	}

	public int getNodeValue()
	{
		return nodeValue;
	}

	public ArrayList<Node> getChildNodes()
	{
		return childNodes;
	}

	public void addChildNode(Node child)
	{
		childNodes.add(child);
	}

	public boolean getIsVisited()
	{
		return isVisited;
	}

	public void setIsVisited(boolean value)
	{
		this.isVisited = value;
	}
}

class DepthFirstSearch
{
	public boolean findNode(Node startNode, Node endNode)
	{
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.add(startNode);

		while(!nodeStack.isEmpty())
		{
			Node currentNode = nodeStack.pop();
			if(currentNode.getIsVisited())
			{
				continue;
			}

			if(currentNode.getNodeValue() == endNode.getNodeValue())
			{
				System.out.println("End node found!");
				System.out.println(endNode.getNodeValue());

				return true;
			}

			ArrayList<Node> currentChildNodes = currentNode.getChildNodes();
			if(currentChildNodes.isEmpty())
			{
				continue;
			}

			nodeStack.addAll(currentChildNodes);
			currentNode.setIsVisited(true);
		}

		System.out.println("End node NOT found!");

		return false;
	}

	public void traverse(Node startNode)
	{
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.add(startNode);

		while(!nodeStack.isEmpty())
		{
			Node currentNode = nodeStack.pop();
			if(currentNode.getIsVisited())
			{
				continue;
			}

			System.out.println(currentNode.getNodeValue() + " ");

			ArrayList<Node> currentChildNodes = currentNode.getChildNodes();
			if(currentChildNodes.isEmpty())
			{
				continue;
			}

			nodeStack.addAll(currentChildNodes);
			currentNode.setIsVisited(true);
		}

	}
}

class DepthFirstSearchMain
{
	public static void main(String[] args)
	{
		Node node0 = new Node(0);
		Node node1 = new Node(14);
		Node node2 = new Node(18);
		Node node3 = new Node(19);
		Node node4 = new Node(20);
		Node node5 = new Node(23);
		Node node6 = new Node(25);
		Node node7 = new Node(31);

		node0.addChildNode(node1);
		node1.addChildNode(node2);
		node2.addChildNode(node3);
		node1.addChildNode(node6);
		node2.addChildNode(node7);
		node7.addChildNode(node5);
		node6.addChildNode(node4);
		node5.addChildNode(node4);
		node5.addChildNode(node6);

		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		System.out.println("DepthFirstSearch traversal of above graph: ");
		//depthFirstSearch.traverse(node0);
		depthFirstSearch.findNode(node0, node7);
	}
}