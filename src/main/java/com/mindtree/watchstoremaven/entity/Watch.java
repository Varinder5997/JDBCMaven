package com.mindtree.watchstoremaven.entity;

public class Watch implements Comparable<Watch>{
	private int watchid;
	private String modelNumber;
	private float price;
	private int typeId;
	public int getWatchid() {
		return watchid;
	}
	public void setWatchid(int watchid) {
		this.watchid = watchid;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "Watch [watchid=" + watchid + ", modelNumber=" + modelNumber + ", price=" + price + ", typeId=" + typeId
				+ "]";
	}
	public int compareTo(Watch w) {
		if(this.price -w.price>0) {
			return 1;
		}
		else if(this.price -w.price<0){
			return -1;
		}
		else {
		return 0;
	}
	}
	
}
