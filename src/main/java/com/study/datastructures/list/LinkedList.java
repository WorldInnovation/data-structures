package com.study.datastructures.list;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class LinkedList implements List
{
	private static final String MESSAGE_ARRAY_SIZE_NOT_IN_FIT = "The index should be smaller then size and not negative";
	private static final String MESSAGE_NO_SUCH_ELEMENTS_IN_ITERATOR = "No any elements in next for iterator";
	private static final String MESSAGE_METHOD_NEXT_HAS_NOT_BEEN_COLLEN = "Method next has not been collen";
	private Node head;
	private Node tail;
	private int size;

	public LinkedList()
	{
	}

	public LinkedList(Object object)
	{
		this();
		add(object);
	}

	@Override
	public void add(Object value)
	{
		Node newNode = new Node(value);
		if (size == 0)
		{
			tail = head = newNode;
		}
		else
		{
			Node current = head;
			while (current.next != null)
			{
				current = current.next;
			}
			addNewNodeOnHead(current, newNode);
		}
		size++;
	}

	@Override
	public void add(Object value, int index)
	{
		if (index > size)
		{
			throw new IndexOutOfBoundsException(MESSAGE_ARRAY_SIZE_NOT_IN_FIT);
		}
		checkIndexValid(index);
		Node newNode = new Node(value);
		Node current = head;
		if (index == size)
		{
			addNewNodeOnHead(current, newNode);
		}
		else
		{
			current = findNodeByIndex(current, index);
			newNode.prev = current;
			newNode.next = current.next;
			current.next = newNode;
		}
		size++;
	}

	@Override
	public Object remove(int index)
	{
		checkIndexValid(index);
		Node current = tail;
		Node delNode = current;
		if (index == 0)         //from tail
		{
			current = current.next;
			current.prev = null;
			tail = current;
			size--;
			return delNode;
		}
		if (index == size - 1)   //from head
		{
			delNode = head;
			current = delNode.prev;
			current.next = null;
			head = current;
			size--;
			return current;
		}                        //from intermediate
		current = head;
		delNode = findNodeByIndex(current, index);
		current = delNode.prev;
		current.next = delNode.next;
		size--;
		return delNode;
	}

	@Override
	public Object get(int index)
	{
		checkIndexValid(index);
		Node current = head;
		current = findNodeByIndex(current, index);
		return current.value;
	}

	@Override
	public Object set(Object value, int index)
	{
		checkIndexValid(index);
		Node current = head;
		Node updateNode = findNodeByIndex(current, index);
		current = updateNode;
		current.value = value;
		return updateNode;
	}

	@Override
	public void clear()
	{
		tail = head = null;
		size = 0;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override
	public boolean contains(Object value)
	{
		return indexOf(value) != -1;
	}

	@Override
	public int indexOf(Object value)
	{
		Node current = tail;
		return findNodeByValueFromTail(current, value);
	}

	@Override
	public int lastIndexOf(Object value)
	{
		Node current = head;
		return findNodeByValueFromHead(current, value);
	}

	public Iterator getIterator()
	{
		return new MyIterator();
	}

	private class MyIterator implements Iterator
	{

		private Node current = tail;
		private boolean hasNextCalled;

		@Override
		public boolean hasNext()
		{
			return current.next != null ? true : false;
		}

		@Override
		public Object next()
		{
			Object value;
			if (hasNext())
			{
				current = current.next;
				value = current.value;
				hasNextCalled = true;
			}
			else
			{
				throw new NoSuchElementException(MESSAGE_NO_SUCH_ELEMENTS_IN_ITERATOR);
			}

			return value;
		}

		@Override
		public void remove()
		{
			if (hasNextCalled)
			{


				if (current == head)
				{
					current = current.prev;
					current.next = null;
					head = current;
				}
				else
				{
					Node temp = current;
					current = current.prev;
					current.next = temp.next;
					temp = current.next;
					current.prev = temp.prev;
				}
				hasNextCalled = false;
			}
			else
			{
				throw new IllegalStateException(MESSAGE_METHOD_NEXT_HAS_NOT_BEEN_COLLEN);
			}

		}
	}

	private class Node
	{
		private Object value;
		private Node next;
		private Node prev;

		public Node(Object value)
		{
			this.value = value;
		}
	}

	private void addNewNodeOnHead(Node current, Node newNode)
	{
		newNode.prev = current;
		head = newNode;
		current.next = newNode;
	}

	private void checkIndexValid(int index)
	{
		if (index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException(MESSAGE_ARRAY_SIZE_NOT_IN_FIT);
		}
	}

	private Node findNodeByIndex(Node current, int index)
	{
		for (int i = 0; current.next != null; i++)
		{
			if (i == index)
			{
				return current;
			}
			current = current.next;
		}
		return current;
	}

	private int findNodeByValueFromTail(Node current, Object value)
	{
		for (int i = 0; current.next != null; i++)
		{
			if (Objects.equals(current.value, value))
			{
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	private int findNodeByValueFromHead(Node current, Object value)
	{
		for (int i = size - 1; current.prev != null; i--)
		{
			if (Objects.equals(current.value, value))
			{
				return i;
			}
			current = current.prev;
		}
		return -1;
	}


}
