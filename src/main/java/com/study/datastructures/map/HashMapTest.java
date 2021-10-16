package com.study.datastructures.map;

public class HashMapTest
{
	public static void main(String[] args)
	{
		Map map = new HashMap();
		map.put("user", "Volodymyr");
		map.put("password", "Java");
		map.put("user", "Jon");

		System.out.println((map.size())); //2

		System.out.println(map.get("user"));// Jon

		System.out.println(map.get("password")); // Java

		System.out.println((map.containsKey("user"))); // true

	}
}
