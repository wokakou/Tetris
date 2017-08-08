package dto;

import java.io.Serializable;

public class Player implements Serializable ,Comparable<Player>{
	public String name;
	
	public int point;
	
	public Player(String name,int point) {
		this.name = name;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public int compareTo(Player p) {
		
		return p.point-this.point;
	}

	
}
