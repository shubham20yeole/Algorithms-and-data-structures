//
package Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// SAMPLE INPUT
//			[
//			 "A" : [
//			   "B" : "b"
//			   "C" : "c"
//			 		]
//			 
//			 "E" : [
//			    	"F" : "f"
//						"D": [
//										B: B
//										B: C
//								]
//						“F”: ”g”   
//						]
//			
//			 "D" : "d"
//			 "D" : "d"
//			 “D”: “d”
//			]
//
// SAMPLE OUTPUT
//			A_B -> B
//			A_C -> C
//			E_F -> F
//			E_D_B -> B
//			E_D_B2 -> C
//			E_F2 -> G
//			D -> D
//			D2 -> D
//			D3 -> D
public class FlattenMap {
	static Map<String, String> result = new LinkedHashMap<String, String>();
	Map<String, Integer> storage = new HashMap<String, Integer>();

	public void flattenList(List<CustomObject> input) {
		Map<String, Integer> storage = new HashMap<String, Integer>();
		input.forEach(item -> {
			flattenListUtil(item.key, item.value, item, storage);
		});
	}

	public void storeHash(String hash, Object value) {
		if (!storage.containsKey(hash)) {
			result.put(hash, (String) value);
			storage.put(hash, 1);
			return;
		}
		result.put(hash + (storage.get(hash) + 1), (String) value);
		storage.put(hash, storage.containsKey(hash) ? storage.get(hash) + 1 : 1);
	}

	@SuppressWarnings("unchecked")
	public void flattenListUtil(String key, Object input, CustomObject customObject, Map<String, Integer> storage) {
		if (input instanceof String) {
			storeHash(key, input);
			return;
		}

		customObject.list.forEach(item -> {
			if (item.isList) {
				flattenListUtil(key.concat("_").concat(item.key), item.value, item, storage);
				return;
			}
			storeHash(key.concat("_").concat(item.key), item.value);
		});
	}

	public static void main(String[] args) {
		FlattenMap cn = new FlattenMap();

		List<CustomObject> input = new LinkedList<CustomObject>();
		input.add(new CustomObject(true, "A", null, new LinkedList<CustomObject>(
				Arrays.asList(new CustomObject(false, "B", "B", null), new CustomObject(false, "C", "C", null)))));
		input
				.add(new CustomObject(true, "E", null,
						new LinkedList<CustomObject>(Arrays.asList(new CustomObject(false, "F", "F", null),
								new CustomObject(true, "D", null, new LinkedList<CustomObject>(
										Arrays.asList(new CustomObject(false, "B", "B", null), new CustomObject(false, "B", "C", null)))),
								new CustomObject(false, "F", "G", null)))));
		input.add(new CustomObject(false, "D", "D", null));
		input.add(new CustomObject(false, "D", "D", null));
		input.add(new CustomObject(false, "D", "D", null));
		// cn.printComplexMap(input);
		cn.flattenList(input);

		result.forEach((hash, value) -> {
			System.out.println(hash + " -> " + value);
		});
	}

}

class CustomObject {
	boolean isList;
	String key;
	List<CustomObject> list;
	Object value;

	@SuppressWarnings("unchecked")
	CustomObject(boolean isList, String key, Object value, List<CustomObject> list) {
		this.isList = isList;
		this.key = key;
		this.value = value;
		this.list = list;
	}

}
