package com.study.datastructures.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;


public class ArrayListTest
{
	private List listOfZeroElements = new ArrayList();
	private List listOfSevenElements = new ArrayList(7);

	@Before
	public void before()
	{
		for (int i = 0; i < 7; i++)
		{
			listOfSevenElements.add(i);
		}
	}

	@Test
	public void sizeTest()
	{
		Assert.assertEquals(listOfZeroElements.size(), 0);
		Assert.assertEquals(listOfSevenElements.size(), 7);
	}

	@Test
	public void add()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		Assert.assertEquals(testAdd.get(0), 1);
	}

	@Test
	public void addExpand()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.add(3);
		testAdd.add(4);
		Assert.assertEquals(testAdd.get(3), 4);
	}

	@Test
	public void addInsideExpand()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.add(3, 1);
		testAdd.add(4);
		Assert.assertEquals(testAdd.get(2), 2);
	}

	@Test
	public void addInside()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.add(3);
		testAdd.add(5, 1);
		Assert.assertEquals(testAdd.get(1), 5);
	}

	@Test
	public void addInsideSize()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.add(5, 2);
		Assert.assertEquals(testAdd.get(2), 5);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void addInsideException()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);

		testAdd.add(5, 3);
	}

	@Test
	public void remove()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.remove(1);

		Assert.assertEquals(testAdd.size(), 1);
	}

	@Test
	public void get()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);

		Assert.assertEquals(testAdd.get(0), 1);
	}

	@Test
	public void set()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.set(2, 0);

		Assert.assertEquals(testAdd.get(0), 2);
	}

	@Test
	public void clear()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);
		testAdd.clear();

		Assert.assertEquals(testAdd.size(), 0);
	}

	@Test
	public void size()
	{
		List testSize = new ArrayList();
		testSize.add(1);
		Assert.assertEquals(testSize.size(), 1);
	}

	@Test
	public void isEmpty()
	{
		List testAdd = new ArrayList();
		Assert.assertEquals(testAdd.isEmpty(), true);
		testAdd.add(1);
		Assert.assertEquals(testAdd.isEmpty(), false);
	}

	@Test
	public void contains()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);

		Assert.assertEquals(testAdd.contains(1), true);
	}

	@Test
	public void containsFalse()
	{
		List testAdd = new ArrayList();
		testAdd.add(1);
		testAdd.add(2);

		Assert.assertEquals(testAdd.contains(3), false);
	}

	@Test
	public void indexOf()
	{
		List testAdd = new ArrayList();
		testAdd.add("A");

		Assert.assertEquals(testAdd.indexOf("A"), 0);
	}

	@Test
	public void lastIndexOf()
	{
		List testAdd = new ArrayList();
		testAdd.add("A");
		testAdd.add("C");
		testAdd.add("A");

		Assert.assertEquals(testAdd.lastIndexOf("A"), 2);
	}

	@Test
	public void printString()
	{
		List printString = new ArrayList();
		printString.add("J");
		printString.add("a");
		printString.add("v");
		printString.add("a");

		Assert.assertEquals(printString.toString(), "[J, a, v, a]");
	}

	@Test
	public void printStringNamber()
	{
		List printString = new ArrayList();
		printString.add("J");
		printString.add(7);
		printString.add(3);
		printString.add("a");

		Assert.assertEquals(printString.toString(), "[J, 7, 3, a]");
	}

	@Test
	public void iteratorTest()
	{
		List printString = new ArrayList();
		printString.add("J");
		printString.add("a");
		printString.add("v");
		printString.add("a");

		Iterator iterator = ((ArrayList) printString).getIterator();
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
		List printString = new ArrayList();
		printString.add(1);


		Iterator iterator = ((ArrayList) printString).getIterator();
		iterator.remove();
	}

	@Test
	public void iteratorTestRemove()
	{
		List printString = new ArrayList();
		printString.add("J");
		printString.add("a");

		Iterator iterator = ((ArrayList) printString).getIterator();
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
