package com.study.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;


public class ArrayList implements List
{
	private static final int ARRAY_SIZE = 4;
	private static final String MESSAGE_ARRAY_INDEX_NOT_IN_FIT = "The index should be smaller then size or not negative";
	private static final String MESSAGE_NO_SUCH_ELEMENTS_IN_ITERATOR = "No any elements in next for iterator";
	private static final String MESSAGE_METHOD_NEXT_HAS_NOT_BEEN_COLLEN = "Method next has not been collen";
	private Node head;
	private Node tail;
	private Object[] array;
	private int size;
	private int currentCapacity;

	public ArrayList()
	{
		this(ARRAY_SIZE);
	}

	public ArrayList(int size)
	{
		this.array = new Object[size];
		currentCapacity = size;
	}

	@Override
	public void add(Object value)
	{
		if (size >= currentCapacity - 1)
		{
			expandArray();
		}
		array[size] = value;
		size++;
	}

	@Override
	public void add(Object value, int index)
	{
		if (index > size || index < 0)
		{
			throw new IndexOutOfBoundsException(MESSAGE_ARRAY_INDEX_NOT_IN_FIT);
		}

		if (index < size)
		{
			Object[] afterIndexArray = new Object[currentCapacity];
			System.arraycopy(array, index, afterIndexArray, 0, size - index);
			System.arraycopy(afterIndexArray, 0, array, index + 1, size - index);
		}
		array[index] = value;
		size++;
		if (size >= currentCapacity - 1)
		{
			expandArray();
		}

	}

	@Override
	public Object remove(int index)
	{
		checkIndexValid(index);
		if (size - 1 >= index)
		{
			System.arraycopy(array, index + 1, array, index, size - 1 - index);
		}
		array[size - 1] = null;
		size--;
		return array;
	}

	@Override
	public Object get(int index)
	{
		checkIndexValid(index);
		return array[index];
	}

	@Override
	public Object set(Object value, int index)
	{
		checkIndexValid(index);
		Object oldValue = array[index];
		array[index] = value;
		return oldValue;
	}

	@Override
	public void clear()
	{
		if (size > 0)
		{
			for (int index = size; index > 0; index--)
			{
				array[index] = null;
			}
			size = 0;
		}

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
		for (int index = 0; index <= size - 1; index++)
		{
			if (array[index].equals(value))
			{
				return index;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object value)
	{
		for (int index = size - 1; index >= 0; index--)
		{
			if (array[index].equals(value))
			{
				return index;
			}
		}
		return -1;
	}

	@Override
	public String toString()
	{
		StringJoiner stringJoiner = new StringJoiner(", ");
		if (array.length > 0)
		{
			for (int i = 0; i < size; i++)
			{
				stringJoiner.add(array[i].toString());
			}
		}

		return "[" + stringJoiner + "]";
	}

	public Iterator getIterator()
	{
		return new MyIterator();
	}


	private class MyIterator implements Iterator
	{

		private int index;
		private boolean hasNextCall;

		@Override
		public boolean hasNext()
		{
			return index < size - 1 ? true : false;
		}

		@Override
		public Object next()
		{
			Object value;
			if (hasNext())
			{
				value = array[index++];
				hasNextCall = true;
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
			if (hasNextCall)
			{
				array[index] = null;
				if (index > 0)
				{
					index--;
				}
				if (size > 0)
				{
					size--;
				}

				hasNextCall = false;
			}
			else
			{
				throw new IllegalStateException(MESSAGE_METHOD_NEXT_HAS_NOT_BEEN_COLLEN);
			}

		}
	}

	private void checkIndexValid(int index)
	{
		if (index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException(MESSAGE_ARRAY_INDEX_NOT_IN_FIT);
		}
	}

	private void expandArray()
	{
		currentCapacity = currentCapacity * 2;
		Object[] expandArray = new Object[currentCapacity];
		System.arraycopy(array, 0, expandArray, 0, size);
		array = expandArray;
	}


}
