package com.study.datastructures.map;

public interface Map
{
	Object put(Object key, Object value);

	Object get(Object key);

	Object size();

	boolean containsKey(Object key);

	Object remove(Object key);

}
