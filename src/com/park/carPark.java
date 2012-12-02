package com.park;

import java.util.HashMap;
import java.util.Map;

import com.park.car;

public class carPark {

	private Map idcard2carnum;
	private int count;
	private int totalPark;
	
	public carPark(int COUNT){
		this.count = 0;
		this.totalPark = COUNT;
		this.idcard2carnum = new HashMap();
	}

	public boolean pushACar(String IDcard, String carNumber){
		if(this.count == this.totalPark){
			return false;
		}
		this.idcard2carnum.put(IDcard,carNumber);
		this.count++;
		return true;
	}
	public Object popACar(String IDcard){
		if(this.count == 0){
			return null;
		}
		if(! this.idcard2carnum.containsKey(IDcard)){
			return null;
		}
		Object carNumber = this.idcard2carnum.get(IDcard);
		this.count--;
		return carNumber;
	}
	public void showStatus(){
		
	}
	public int getEmptySpaces(){
		return this.totalPark - this.count;
	}
}

