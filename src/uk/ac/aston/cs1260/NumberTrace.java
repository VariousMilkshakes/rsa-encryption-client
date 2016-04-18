package uk.ac.aston.cs1260;

public class NumberTrace {
    	
	private int value = 0;
	private int remainder = 0;
	private int elementCount = 0;
	
	private NumberTrace element = null;
	private NumberTrace branch = null;
	private NumberTrace child = null;
	
	private boolean floor = false;
	
	public NumberTrace (int val){
		this.value = val;
	}
	
	public void setTrace (NumberTrace ele) {
		this.element = ele;
	}
	
	public void setChild (NumberTrace nt) {
		if (this.child != null) {
			this.child.setChild(nt);
		} else {
			this.child = nt;
		}
	}
	
	public void increase () {
		this.elementCount++;
		this.remainder = this.value - getTraceTotal();
	}
	
	public void branch () {
		this.branch = new NumberTrace(remainder);
	}
	
	public int getRemainder () {
		return this.remainder;
	}
	
	public int getElements () {
		return this.elementCount;
	}
	
	public int getTraceTotal () {
		return this.element.getValue() * this.elementCount;
	}
	
	public NumberTrace getElement () {
		return this.element;
	}
	
	public int getValue () {
		return this.value;
	}
	
	public boolean isFloor () {
		return this.floor;
	}
	
	public NumberTrace getChild () {
		return this.child;
	}
	
}
