package uk.ac.aston.cs1260;

import java.util.ArrayList;

public class Euclidean {

    public static int extendedAlgorithm(int a, int b) {
    	
    	Euclidean algo = new Euclidean();
    	
    	NumberTrace fullTrace = algo.forward(a, b);
    	System.out.println("> : " + fullTrace.getChild().getValue());
    	System.out.println(algo.backwards(fullTrace));
    	
    	System.out.println(fullTrace);
    	return 0;
    }

    private ArrayList<Integer> elementList;
    private boolean base;
    
    public Euclidean () {
    	this.elementList = new ArrayList<Integer>();
    	this.base = true;
    }
    
    public NumberTrace forward (int number, int element) {
    	
    	NumberTrace trace = new NumberTrace(number);
    	
    	// Record trace numbers
    	if (!this.elementList.contains(element)) {
    		this.elementList.add(element);
    	}
    	
    	trace.setTrace(new NumberTrace(element));
    	
    	int traceTotal = 0;
    	while (traceTotal + element <= trace.getValue()) {
    		
    		trace.increase();
    		traceTotal = trace.getTraceTotal();
    		
    	}
    	
    	int remainder = trace.getRemainder();
    	System.out.println(remainder);
    	
    	if (remainder == 0) {
    		return trace;
    	}
    	
    	// The remainder counts as a traceable number
    	if (this.elementList.contains(remainder)) {
    		trace.branch();
    	}
    	
    	NumberTrace newTrace = forward(element, remainder);
//    	if (newTrace == null) {
//    		return trace;
//    	}
    	
    	newTrace.setChild(trace);
    	
    	return newTrace;
    	
    }
    
    public int backwards (NumberTrace trace) {
    	
    	int base, forks;
    	
    	if (trace.getChild() == null) {
    		return 1;
    	}
    	
    	if (this.base) {
    		
    		trace = trace.getElement();	
    		
    	}
    	
    	this.base = false;
    	
    	base = trace.getValue();
    	System.out.println(base);
		forks = trace.getChild().getElements();
		
    	for (int i = 0; i < forks; i++) {
    		backwards(trace.getChild());
    	}
    	
    	return 0;
    }
    
}
