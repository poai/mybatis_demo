package cn.com.zjf.model;

public class Param {
	private Float min;
	private Float max;
	public Float getMin() {
		return min;
	}
	public void setMin(Float min) {
		this.min = min;
	}
	public Float getMax() {
		return max;
	}
	public void setMax(Float max) {
		this.max = max;
	}
	public Param(Float min, Float max) {
		super();
		this.min = min;
		this.max = max;
	}
	
}
