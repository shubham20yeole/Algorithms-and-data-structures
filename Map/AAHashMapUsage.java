//https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html
package Map;

import java.util.*;

// Methods to remember:
// containsKey, containsValue, get, getOrDefault, putAll, replace, remove, entrySet, lambda function, keySet

public class AAHashMapUsage {

	public static void main(String[] args) {
		
		Map<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(1, "Shubham");
		
		System.out.println(hm.containsKey(1)); // Prints true
		
		System.out.println(hm.containsValue(1)); // Prints false
		
		System.out.println(hm.containsValue("Shubham")); // Prints true
		
		System.out.println(hm.get(1)); // Prints Shubham
		
		System.out.println(hm.getOrDefault(332, "Default")); // Prints Default
		
		System.out.println(hm.keySet()); // Prints [1]
		
		System.out.println(hm.keySet().getClass().getName()); // Prints java.util.HashMap$KeySet
		
		hm.putIfAbsent(1, "Yeole");
		
		System.out.println(hm.get(1)); // Prints Shubham
		
		hm.putIfAbsent(2, "Yeole");
		
		System.out.println(hm.get(2)); // Prints Yeole
		
		Map<Integer, String> hm2 = new HashMap<Integer, String>();

		hm2.put(3, "Rasik");
		
		hm2.put(4, "kashvi");

		hm2.put(5, "Aaru");

		hm.putAll(hm2);
		
		System.out.println(hm); // Prints {1=Shubham, 2=Yeole, 3=Rasik}
		
		hm.replace(1, "ShubhamReplaced");

		System.out.println(hm); // Prints {1=ShubhamReplaced, 2=Yeole, 3=Rasik}
		
		hm.replace(1, "ShubhamReplaced", "Shubham");

		System.out.println(hm); // Prints {1=Shubham, 2=Yeole, 3=Rasik}
		
		hm.remove(3);
		
		System.out.println(hm); // Prints {1=Shubham, 2=Yeole}

		hm.remove(2, "Yeole");

		System.out.println(hm); // Prints {1=Shubham, 2=Yeole}
		
		
		//****************************** ITERATE MAP ******************************
		
		// USING ENTRYSET
		for (Map.Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());   
        }
		
		// USING LAMBDA FUNCTION
		hm.forEach((k, v) -> {
            System.out.println("Key : " + k + " Value : " + v);
		});
		
		// USING KEYSET
		for (Object key : hm.keySet()) {
            System.out.println("Key : " + key + " Value : " + hm.get(key));
        }

	}
	
}
