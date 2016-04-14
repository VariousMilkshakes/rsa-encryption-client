package uk.ac.aston.cs1260;

import java.util.ArrayList;

public class NumberTrace {
    	
	private int value;
	private int remainder;
	private int traceTotal;
	private ArrayList<Integer> trace;
	
	public NumberTrace (int val){
		this.value = val;
		this.trace = new ArrayList<Integer>();
	}
	
	private void appendElements (int newElement){
		this.trace.add(newElement);
	}
	
	private void updateTotals (){
		int total = this.value;
		this.traceTotal = 0;
		
		for (int e : this.trace) {
			total -= e;
			this.traceTotal += e;
		}
		
		this.remainder = total;
	}
	
	public void newElement (int e) {
		appendElements(e);
		updateTotals();
	}
	
	public int getRemainder () {
		return this.remainder;
	}
	
	public int getTraceTotal () {
		return this.traceTotal;
	}
    	
}
