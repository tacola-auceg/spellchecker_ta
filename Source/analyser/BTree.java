package analyser;

import java.util.*;
import java.io.BufferedReader;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;

/**
 * Balanced Tree Implementation class which extends AbstractSet
 * and implements Set.
 */
public class BTree extends AbstractSet implements Set
{
	public BTreeNode root;
	private Comparator comparator = null;
	private int order;
	private int size;

	public BTree()
	{
		this(50);
	}

	public BTree(int order)
	{
		this(order, null);
	}

	public BTree(int order, Comparator comparator)
	{
		this.order = order;
		this.comparator = comparator;
		root = new BTreeNode(null);
	}

	public boolean add(Object Obj)
	{
		if(Obj == null)
			return false;
		else
			return root.insert(Obj, -1);
	}

	public boolean contains(Object Obj)
	{
		return root.includes(Obj);
	}

	public int size()
	{
		return size;
	}

	public int order()
	{
		return order;
	}

	public void makeEmpty()
	{
		root = new BTreeNode(null);
		size = 0;
	}

	public void printTree()
	{
		Iterator iterator = new Iterator();
		for(int i = 0; i < size; i++)
		{
			//print iterator.next();
		}
	}

	/** construct the tree from the database contents*/
	public void updateDictTree(String fileName)
	{
		BufferedReader dic = null;
		try
		{

			dic = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));

		}
		catch(Exception i)
		{
			System.err.println("Search Ex: " + i);
			//Utils.showErrorDialog(false,null,i);
			return;
		}
		try
		{
			StreamTokenizer input = new StreamTokenizer(dic);
			int tokentype = 0;
			while((tokentype = input.nextToken()) != StreamTokenizer.TT_EOF)
			{
				if(tokentype == StreamTokenizer.TT_WORD)
					add(new String(input.sval));
			}
			dic.close();
		}
		catch(Exception i)
		{
			System.err.println("Search Ex: " + i);
			//Utils.showErrorDialog(false,null,i);
			return;
		}
	}

	private int compare(Object x, Object y)
	{
		return (comparator == null ? ((Comparable)x).compareTo(y) : comparator.compare(x, y));
	}

	public java.util.Iterator iterator()
	{
		return new Iterator();
	}

	private class Iterator implements java.util.Iterator
	{
		private int index = 0;
		private Object prev = null;
		private Object next;
		private BTreeNode currentNode;
		private Stack parentIndex = new Stack();

		Iterator()
		{
			currentNode = firstNode();
			next = nextElement();
		}

		public boolean hasNext()
		{
			return next != null;
		}

		public Object next()
		{
			if (next == null)
				return null;

			prev = next;
			next = nextElement();
			return prev;
		}

		public void remove()
		{
		}

		private BTreeNode firstNode()
		{
			BTreeNode tempNode = BTree.this.root;
			while (tempNode.entries[0].child != null)
			{
				tempNode = tempNode.entries[0].child;
				parentIndex.push(new Integer(0));
			}
			return tempNode;
		}

		private Object nextElement()
		{
			if (currentNode.isLeaf())//if leaf
			{
				if (index < currentNode.nrElements)
					return currentNode.entries[index++].element;
				else if (!parentIndex.empty())
				{
					currentNode = currentNode.parent;
					index = ((Integer)parentIndex.pop()).intValue();
					while (index == currentNode.nrElements)
					{
						if (parentIndex.empty())
							break;

						currentNode = currentNode.parent;
						index = ((Integer)parentIndex.pop()).intValue();
					}

					if (index == currentNode.nrElements)//reached root and no more children
						return null;

					return currentNode.entries[index++].element;
				}
				else//root and leaf are same
				{
					if (index == currentNode.nrElements)
						return null;

					return currentNode.entries[index].element;
				}
			}
			else//non-leaf
			{
				currentNode = currentNode.entries[index].child;
				parentIndex.push(new Integer(index));

				while (currentNode.entries[0].child != null)
				{
					currentNode = currentNode.entries[0].child;
					parentIndex.push(new Integer(0));
				}
				index = 1;
				return currentNode.entries[0].element;
			}
		}
	}

	/** inner class to hold the node elements. */
	private static class Entry
	{
		public Object element;
		public BTreeNode child;
    }

	/** inner class to represent the node. */
	private class BTreeNode
	{
		public Entry[] entries;
		public BTreeNode parent;
		private int nrElements = 0;
		private int max = 0;
		private int ndCount = 1;
		private final int MIN = (BTree.this.order - 1) / 2;

		BTreeNode(BTreeNode parent)
		{
			this.parent = parent;
			entries = new Entry[BTree.this.order];
			entries[0] = new Entry();
		}

		private boolean isFull()
		{
			return nrElements == (BTree.this.order - 1);
		}

		private boolean isEmpty()
		{
			return nrElements == 0;
		}

		private boolean isLeaf()
		{
			return entries[0].child == null;
		}

		private boolean isRoot()
		{
			return parent == null;
		}

		/** adds the Object into a BTree. */
		boolean insert(Object Obj, int parentIndex)
		{
		if (isFull())
			{
				// If full, split and promote splitNode before inserting
				Object splitObj = entries[nrElements / 2].element;
				BTreeNode rightSibling = split();
				Object Obj1 = new Object();
				Object Obj2 = new Object();
				Obj1 = Obj;

				if (isRoot())
				{
					splitRoot(splitObj, this, rightSibling);
					Obj2 = BTree.this.root.entries[0].element;

					if (BTree.this.compare(Obj1, Obj2) < 0)
						insert(Obj, 0);
					else
						rightSibling.insert(Obj, 1);
				}
				else
				{
					parent.splitNode(splitObj, this, rightSibling, parentIndex);
					Obj2 = parent.entries[parentIndex].element;

					if (BTree.this.compare(Obj1, Obj2) < 0)
						return insert(Obj, parentIndex);
					else
						return rightSibling.insert(Obj, parentIndex + 1);
				}
			}
			else if (isLeaf())
			{
				// If leaf, simply insert the non-duplicate element
				int insertAt = childToInsertAt(Obj, true);
				if (insertAt == -1)
					return false;
				else
				{
					addNewElement(Obj, insertAt);
					BTree.this.size++;
					return true;
				}
			}
			else
			{
				// If not full and not leaf recursively find correct node to insert at
				int insertAt = childToInsertAt(Obj, true);
				if (insertAt == -1)
					return false;
				else
					return entries[insertAt].child.insert(Obj, insertAt);
			}
			return false;
		}

		boolean includes(Object Obj)
		{
			int index = childToInsertAt(Obj, true);
			if (index == -1)
				return true;

			if (entries[index] == null || entries[index].child == null)
				return false;

			return entries[index].child.includes(Obj);
		}

		/** split the node to get the right siblings.*/
		private BTreeNode split()
		{
			BTreeNode rightSibling = new BTreeNode(parent);
			int index = nrElements / 2;
			entries[index++].element = null;

			for (int i = 0, nr = nrElements; index <= nr; i++, index++)
			{
				rightSibling.entries[i] = entries[index];
				if (rightSibling.entries[i] != null && rightSibling.entries[i].child != null)
				{
					rightSibling.entries[i].child.parent = rightSibling;
				}
				entries[index] = null;
				nrElements--;
				rightSibling.nrElements++;
			}
			rightSibling.nrElements--; // for copying the last Entry which has a null element and a child
			rightSibling.ndCount = ndCount + 1;
			return rightSibling;
		}

		/** split the root into root with left and right childs, if the root is full */
		private void splitRoot(Object splitObj, BTreeNode left, BTreeNode right)
		{
			BTreeNode newRoot = new BTreeNode(null);
			newRoot.entries[0].element = splitObj;
			newRoot.entries[0].child = left;
			newRoot.entries[1] = new Entry();
			newRoot.entries[1].child = right;
			newRoot.nrElements = 1;
			left.parent = newRoot;
			left.parent.ndCount = ndCount;
			right.parent = newRoot;
			right.parent.ndCount = ndCount + 1;
			BTree.this.root = newRoot;
		}

		/** split the node into left and right childs, if the node is full */
		private void splitNode(Object splitObj, BTreeNode left, BTreeNode right, int insertAt)
		{
			for (int i = nrElements; i >= insertAt; i--)
				entries[i + 1] = entries[i];

			entries[insertAt] = new Entry();
			entries[insertAt].element = splitObj;
			entries[insertAt].child = left;
			entries[insertAt + 1].child = right;
			nrElements++;
		}

		private int childToInsertAt(Object Obj, boolean position)
		{
			int index = nrElements / 2;
			Object Obj1 = new Object();
			Object Obj2 = new Object();

			if (entries[index] == null || entries[index].element == null)
				return index;

			int min = 0;
			max = nrElements - 1;
			Obj1 = Obj;

			while (min <= max)
			{
				Obj2 = entries[index].element;
				if (BTree.this.compare(Obj1, Obj2) > 0)
					min = index + 1;
				else
					max = index - 1;
				index = (min + max) / 2;
			}
			max++;

			if (entries[max] == null || entries[max].element == null)
				return max;

			Obj2 = entries[max].element;
			return (!position ? max : BTree.this.compare(Obj1, Obj2) == 0 ? -1 : max);
		}

		private void addNewElement(Object Obj, int insertAt)
		{
			for(int i = nrElements; i > insertAt; i --)
				entries[i] = entries[i - 1];

			entries[insertAt] = new Entry();
			entries[insertAt].element = Obj;
			nrElements++;
		}

	}

	public byte[] endsWith(byte[] input, boolean equals)
	{
		Iterator iterator = new Iterator();
		if(equals)
		{
			for(int i = 0; i < size; i++)
			{
				String s = (String)iterator.next();
				byte[] b = TabConverter.convert(s);
				if(ByteMeth.isEqual(input,b))
				{
					return b;
				}
			}
		}
		else
		{
			for(int i = 0; i < size; i++)
			{
				String s = (String)iterator.next();
				byte[] b = TabConverter.convert(s);
				if(ByteMeth.endsWith(input,b))
				{
					return b;
				}
			}
		}
		return null;
	}

}
