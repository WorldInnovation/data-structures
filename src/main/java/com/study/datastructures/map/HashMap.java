package com.study.datastructures.map;



import com.study.datastructures.list.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class HashMap implements Map
{
	private final static int ARRAY_SIZE = 5;
	private static final String MESSAGE_NO_SUCH_ELEMENTS_IN_ITERATOR = "No any elements in next for iterator";
	private static final String MESSAGE_METHOD_NEXT_HAS_NOT_BEEN_COLLEN = "Method next has not been collen";
	private Entry[] buckets;
	private int size;

	public HashMap()
	{
		buckets = new Entry[ARRAY_SIZE];
	}

	public Object put(Object key, Object value)
	{
		Entry entry = new Entry(key, value, null);
		int bucketKey = countHash(key);
		Entry currentEntry = buckets[bucketKey];
		if (currentEntry == null)
		{
			buckets[bucketKey] = entry;
			size++;
			return entry;
		}
		if (currentEntry.next != null)
		{
			while (buckets[bucketKey].next != null)
			{
				if (buckets[bucketKey].key.equals(key))
				{
					return buckets[bucketKey].value = entry.value;
				}

				buckets[bucketKey] = buckets[bucketKey].next;
			}
		}

		if (buckets[bucketKey].key.equals(key)) //tail element
		{
			buckets[bucketKey] = entry; //update
			return buckets[bucketKey];
		}

		buckets[bucketKey].next = entry;
		size++;
		return entry;
	}

	public Object get(Object key)
	{
		int bucketKey = countHash(key);
		if (getEntry(bucketKey, key) == null)
		{
			return null;
		}
		return getEntry(bucketKey, key).value;
	}

	@Override
	public Object size()
	{
		return size;
	}

	@Override
	public boolean containsKey(Object key)
	{
		int bucketKey = countHash(key);
		if (getEntry(bucketKey, key) == null)
		{
			return false;
		}
		return true;
	}

	@Override
	public Object remove(Object key)
	{
		int bucketKey = countHash(key);
		if (!containsKey(key))
		{
			return null;
		}

		Entry currentEntry = null;

		if (buckets[bucketKey].next != null)
		{
			if (buckets[bucketKey].key.equals(key)) //tail element
			{
				return deleteEntry(currentEntry, bucketKey);
			}
			while (buckets[bucketKey].next != null)
			{
				if (buckets[bucketKey].key.equals(key))
				{
					return deleteEntry(currentEntry, bucketKey);
				}
				if (currentEntry == null)
				{
					currentEntry = new Entry(buckets[bucketKey].key, buckets[bucketKey].value, null);
				}
				else
				{
					currentEntry.next = buckets[bucketKey];
					currentEntry = currentEntry.next;
				}

				buckets[bucketKey] = buckets[bucketKey].next;
			}
			if (buckets[bucketKey].key.equals(key)) //tail element
			{
				return deleteEntry(currentEntry, bucketKey);
			}
		}
		else   //contains one element
		{
			decrementSize();
			buckets[bucketKey] = null;
		}

		return currentEntry;
	}

	private Entry deleteEntry(Entry currentEntry, int bucketKey)
	{
		Entry deleteEntry = buckets[bucketKey];
		if (currentEntry == null)                  // erase tail elem and the new one is next one
		{
			buckets[bucketKey] = buckets[bucketKey].next;
		}
		else                                       // erase if deleted >= tail.next
		{
			if (buckets[bucketKey].next != null)   //has elem after deleted?
			{
				currentEntry.next = buckets[bucketKey].next;
			}
			else
			{
				currentEntry.next = null;
			}
			buckets[bucketKey] = currentEntry;
		}
		decrementSize();
		return deleteEntry;
	}

	private void decrementSize()
	{
		if (size > 0)
		{
			size--;
		}
	}

	private int countHash(Object key)
	{
		int hashCode = key.hashCode();
		return Math.abs(hashCode % (ARRAY_SIZE - 1));//
	}

	private Entry getEntry(int bucketKey, Object key)
	{
		if (buckets[bucketKey] == null)
		{
			return null;
		}

		Entry currentEntry = buckets[bucketKey];      //iterate on this entry
		if (buckets[bucketKey].next != null) //has next of chain elements
		{

			while (currentEntry.next != null)
			{
				if (currentEntry.key.equals(key))
				{
					return currentEntry;
				}

				currentEntry = currentEntry.next;
			}
		}
		return (currentEntry.key.equals(key)) ? currentEntry : null;

	}

		private class Entry
		{
			Object key;
			Object value;
			Entry next;

			public Entry(Object key, Object value, Entry next)
			{
				this.key = key;
				this.value = value;
				this.next = next;
			}
		}




	}
