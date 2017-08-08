package dto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import entity.GameAct;

public class GameDto {
	public GameAct gameAct;
	
	public  int level = 0;
	
	public  boolean[][] gameMap;
	
	public int next = new Random().nextInt(6) ;
	
	public int nowPoints = 0;
	
	public int removeLine = 0;
	
	public List<Player> dbRecord;
	public boolean pause;
	
	public void DTOinit(){
		this.level = 0;
		this.nowPoints = 0;
		this.removeLine = 0;
		this.pause = false;
	}

	public boolean isPause() {
		return pause;
	}
	public void changePause() {
			this.pause = !this.pause;
	}

	public List<Player> diskRecord;

	private boolean Start = false;
   
	
	//为数据db、diskdata添加comparable属性以进行排序
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public boolean[][] getgameMap() {
		return gameMap;
	}

	public void setgameMap(int x ,int y) {
		gameMap[x][y] = true;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}
	public int getNext() {
		return next;
		
	}
	public void setNext(int next) {
		this.next = next;
		
	}
	
	public int getNowPoints() {
		return nowPoints;
	}
	public void setNowPoints(int nowPoints) {
		this.nowPoints = nowPoints;
	}
	public int getRemoveLine() {
		return removeLine;
	}
	public void setRemoveLine(int removeLine) {
		this.removeLine = removeLine;
	}
	public List<Player> getDbRecord() {
		return dbRecord;
	}

	public void setDbRecord(List<Player> dbRecord) {
		if(dbRecord ==null){
			dbRecord =new ArrayList<Player>();
			}
			while(dbRecord.size()<5){
				dbRecord.add(new Player("NO DATA", 0));
			}
				
		Collections.sort(dbRecord);
		this.dbRecord = dbRecord;
	}

	public List<Player> getDiskRecord() {
		return diskRecord;
	}

	public void setDiskRecord(List<Player> diskRecord) {
		if(diskRecord ==null){
		diskRecord =new ArrayList<Player>();
		}
		while(diskRecord.size()<5){
			diskRecord.add(new Player("NO DATA", 0));
		}
			
			
		Collections.sort(diskRecord);
		this.diskRecord = diskRecord;
	}

	public boolean isStart() {
		return Start;
	}

	public void setStart(boolean start) {
		Start = start;
	}

}
