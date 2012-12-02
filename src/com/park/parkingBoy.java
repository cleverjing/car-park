package com.park;

import com.park.carPark;

import java.util.List;

public class parkingBoy {
	private carPark[] parklist;
	private int parklots;
	private int totals;
	
	public parkingBoy(int parklots, int count){
		this.parklist = new carPark[parklots];
		for(int i=0; i<parklots; i++){
			this.parklist[i] = new carPark(count);
		}
		this.parklots = parklots;
		this.totals = parklots * count;
	}
	
	public boolean pushACar(String IDcard, String carNumber){
		carPark park = this.getAnEmptySpace();
		if(park == null){
			return false;
		}
		park.pushACar(IDcard, carNumber);
		this.totals--;
		return true;
	}
	
	public carPark getAnEmptySpace(){
		for(int i=0;i<this.parklots; i++){
			if(this.parklist[i].getEmptySpaces() > 0){
				return this.parklist[i];
			}
		}
		return null;
	}
	
	public Object popAcar(String IDcard){
		for(int i=0; i< this.parklots;i++){
			Object obj = this.parklist[i].popACar(IDcard);
			if(obj != null){
				this.totals++;
				return obj;
			}
		}
		return null;
	}
	public int getEmptySpace(){
		return this.totals;
	}
}
