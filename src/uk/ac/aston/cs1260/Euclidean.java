package uk.ac.aston.cs1260;

import java.util.ArrayList;

public class Euclidean {

    public static int extendedAlgorithm(int a, int b) {
    	ArrayList<NumberTrace> nums = forward(a, b);
    	System.out.println(nums);
    	return 0;
    }
    
    public static ArrayList<NumberTrace> forward (int a, int b) {
    	ArrayList<NumberTrace> nums = new ArrayList<NumberTrace>();
    	NumberTrace currentChunk = new NumberTrace(a);
    	
    	int total = currentChunk.getTraceTotal();
    	while (total + b < a) {
    		currentChunk.newElement(b);
    		total = currentChunk.getTraceTotal();
    	}
    	
    	nums.add(currentChunk);
    	
    	int r = currentChunk.getRemainder();
    	if (r == 0) {
    		nums.add(new NumberTrace(b));
    	}
    	
    	nums.addAll(forward(b, r));
    	return nums;
    }
    
    public static int backwards ()
    
}
