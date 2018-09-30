//https://leetcode.com/problems/exclusive-time-of-functions/
package Array;
import java.util.*;
import Utils.*;

public class ExclusiveTimeofFunctions636 {

	static Utils utils = new Utils();

	Utils util = new Utils();

	public static void main(String[] args) {

		ExclusiveTimeofFunctions636 cn = new ExclusiveTimeofFunctions636();
		
		System.out.println(Arrays.toString(cn.exclusiveTime2(3, new ArrayList<String>(Arrays.asList(new String[] {"0:start:0","1:start:2","2:start:5", "2:end:10", "1:end:15","0:end:26"})))));
//		System.out.println(Arrays.toString(cn.exclusiveTime(1, new ArrayList<String>(Arrays.asList(new String[] {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"})))));
	}
	
	public int[] exclusiveTime(int n, List<String> logs) {
    int[] res = new int[n];
    
    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    
    int ptime = 0;
    int prevId = 0;
    String paction = "";
    
    hm.put(0, 0);
    
    for (int i = 1; i < logs.size(); i++) {
			String log = logs.get(i);
			String[] split = log.split(":");
			int id = Integer.parseInt(split[0]);
			String action = split[1];
			int time = Integer.parseInt(split[2]);
			
			if (action.equals("start")) {
				if (hm.get(prevId) == 0) {
					hm.put(prevId, time);
				}
				else {
					hm.put(prevId, hm.get(prevId) + time - ptime);
				}
				hm.put(id, hm.containsKey(id) ? hm.get(id) + 1 : 1);
			}
			
			if (action.equals("end"))
					hm.put(id, hm.get(id) + time - ptime);
			
			System.out.println(hm);
			
			ptime = time;
			prevId = id;
			paction = action;
			
		}
    
    hm.forEach((key, item) -> {
    	res[key] = item;
    });
    
    return res;
  }
	
	public int[] exclusiveTime2(int n, List<String> logs) {
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();
    int prevTime = 0;
    for (String log : logs) {
        String[] parts = log.split(":");
        if (!stack.isEmpty()) res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime; 
        prevTime = Integer.parseInt(parts[2]);
        if (parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
        else {
            res[stack.pop()]++;
            prevTime++;
        }
    }
    return res;
}
}

