package com.study.datastructures.map;

public class Entry
{
	final Object key;
	Object value;
	Entry next;

	Entry(Object key, Object value, Entry next)
	{
		this.key = key;
		this.value = value;
		this.next = next;
	}
}
