package com.gra.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;


public class SynchronizedMap_ {

	public static void main(String[] args) {
		 Vector<?> vector = new Vector<Object>();
//		 vector.get(index)
		// // vector.add("");
		// ArrayList arrayList= new ArrayList<>();
		// arrayList.add(e);
//	  Hashtable<Object, Object> hashtable = new Hashtable<>();
//	 hashtable.put("safa", value)
//	 hashtable.get(key)
		HashMap hashMap = new HashMap<>();
		//HashMap.put("", "");
		//将不安全的map集合转成安全集合
		Collections.synchronizedMap(hashMap);
//		Collections.sort(list, c);

	}

}
