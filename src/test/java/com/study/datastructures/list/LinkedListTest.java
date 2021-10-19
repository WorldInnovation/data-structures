package com.study.datastructures.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;


public class LinkedListTest
{

	@Test
	public void add()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		Assert.assertEquals(testAdd.get(1), 2);
	}

	@Test
	public void addWithIndex()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(3);
		testAdd.add(2, 1);
		Assert.assertEquals(testAdd.get(1), 2);
	}

	@Test
	public void removeMiddle()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(3);
		testAdd.add(2, 1);
		testAdd.remove(1);
		Assert.assertEquals(testAdd.get(1), 3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeHead()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.remove(1);
		Assert.assertEquals(testAdd.get(1), 3);
	}

	@Test
	public void removeTail()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.remove(0);
		Assert.assertEquals(testAdd.get(0), 2);
	}

	@Test
	public void get()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		Assert.assertEquals(testAdd.get(0), 1);
	}

	@Test
	public void set()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.set(2, 0);
		Assert.assertEquals(testAdd.get(0), 2);
	}

	@Test
	public void clear()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.clear();
		Assert.assertEquals(testAdd.size(), 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void clearWithGet()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.clear();
		Assert.assertEquals(testAdd.get(0), 0);
	}

	@Test
	public void size()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		Assert.assertEquals(testAdd.size(), 2);
	}

	@Test
	public void isEmpty()
	{
		List testAdd = new LinkedList();
		Assert.assertEquals(testAdd.isEmpty(), true);
	}

	@Test
	public void isEmptyFalse()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		Assert.assertEquals(testAdd.isEmpty(), false);
	}

	@Test
	public void contains()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		Assert.assertEquals(testAdd.contains(1), true);
	}

	@Test
	public void containsFalse()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		Assert.assertEquals(testAdd.contains(7), false);
	}

	@Test
	public void indexOf()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.add(1);
		Assert.assertEquals(testAdd.indexOf(1), 0);
	}

	@Test
	public void indexOfNotContains()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		Assert.assertEquals(testAdd.indexOf(3), -1);
	}

	@Test
	public void lastIndexOf()
	{
		List testAdd = new LinkedList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.add(2);
		Assert.assertEquals(testAdd.lastIndexOf(2), 2);
	}

	@Test
	public void iteratorTest()
	{
		List printString = new LinkedList();
		printString.add("J");
		printString.add("a");
		printString.add("v");
		printString.add("a");

		Iterator iterator = ((LinkedList) printString).getIterator();
		int i = 0;
		while (iterator.hasNext())
		{
			iterator.next();
			i++;
		}

		Assert.assertEquals(i, 3);

	}

	@Test(expected = IllegalStateException.class)
	public void iteratorRemoveException()
	{
		List printString = new LinkedList();
		printString.add(1);


		Iterator iterator = ((LinkedList) printString).getIterator();
		iterator.remove();
	}

	@Test
	public void iteratorTestRemove()
	{
		List printString = new LinkedList();
		printString.add("J");
		printString.add("a");

		Iterator iterator = ((LinkedList) printString).getIterator();
		int i = 0;
		while (iterator.hasNext())
		{
			iterator.next();
			iterator.remove();
			i++;
		}

		Assert.assertEquals(i, 1);

	}


}
