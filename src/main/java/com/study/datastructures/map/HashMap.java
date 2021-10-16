package com.study.datastructures.map;



public class HashMap implements Map
{
	private final static int ARRAY_SIZE = 5;
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

		//currentEntry.next = entry;
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
		return null;
	}

	private int countHash(Object key)
	{
		int hashCode = key.hashCode();
		return hashCode % (ARRAY_SIZE - 1);//
	}

	private Entry getEntry(int bucketKey, Object key)
	{
		if (buckets[bucketKey] != null)
		{
			return buckets[bucketKey];
		}
		while (buckets[bucketKey].next != null)
		{
			if (buckets[bucketKey].key.equals(key))
			{
				return buckets[bucketKey];
			}

			buckets[bucketKey] = buckets[bucketKey].next;
		}
		if (buckets[bucketKey].key.equals(key))
		{
			return buckets[bucketKey];
		}
		return null;
	}




}
