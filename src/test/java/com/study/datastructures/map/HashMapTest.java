package com.study.datastructures.map;

import org.junit.Assert;
import org.junit.Test;


public class HashMapTest
{

	@Test
	public void put()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("user", "Volodymyr");
		Assert.assertEquals(hashMap.get("user"), "Volodymyr");
	}

	@Test
	public void putDuplicateKey()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("user", "Volodymyr");
		hashMap.put("user", "Jon");
		Assert.assertEquals(hashMap.get("user"), "Jon");
	}

	@Test
	public void get()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("language", "Java");
		Assert.assertEquals(hashMap.get("language"), "Java");
	}

	@Test
	public void getEmpty()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("language", "Java");
		Assert.assertEquals(hashMap.get("language1"), null);
	}

	@Test
	public void getRandom()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("user", "Volodymyr");
		hashMap.put("password", "pass");
		Assert.assertEquals(hashMap.get("password"), "pass");
		Assert.assertEquals(hashMap.get("user"), "Volodymyr");
	}

	@Test
	public void size()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("language", "Java");
		hashMap.put("user", "Volodymyr");
		hashMap.put("password", "pass");
		Assert.assertEquals(hashMap.size(), 3);
	}

	@Test
	public void containsKey()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("language", "Java");
		hashMap.put("user", "Volodymyr");
		Assert.assertEquals(hashMap.containsKey("language"), true);
	}

	@Test
	public void containsKeyFalse()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("language", "Java");
		hashMap.put("user", "Volodymyr");
		Assert.assertFalse(hashMap.containsKey("empty"));
	}

	@Test
	public void remove()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("user", "Volodymyr");
		hashMap.remove("user");
		Assert.assertNull(hashMap.get("user"));
	}

	@Test
	public void removeInChain()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("language", "Java");
		hashMap.put("user", "Volodymyr");
		hashMap.put("password", "pass");
		hashMap.remove("user");
		Assert.assertNull(hashMap.get("user"));
		Assert.assertEquals(hashMap.size(), 2);
	}

	@Test
	public void removeHeadInChain()
	{
		HashMap hashMap = new HashMap();
		hashMap.put("user", "Volodymyr");
		hashMap.put("password", "pass");
		hashMap.put("language", "Java");
		hashMap.remove("password");
		Assert.assertEquals(hashMap.get("user"), "Volodymyr");
		Assert.assertNull(hashMap.get("password"));
	}

}
