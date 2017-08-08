package service;




import java.awt.Point;
import java.security.PublicKey;
import java.util.List;
import java.util.Random;

import javax.activation.MailcapCommandMap;

import org.omg.PortableServer.THREAD_POLICY_ID;

import control.GameControl;
import dto.GameDto;
import dto.Player;
import entity.GameAct;

public class GameService {
	
	
	public GameDto dto;
	
	public GameService(GameDto dto) {
		this.dto = dto;
		
	}

	/**
	 * start main thredd ;game begin.
	 * */

	public void startGame() {
		//数据初始化
		this.dto.gameAct  = new GameAct(new Random().nextInt(6));
		this.dto.gameMap = new boolean[10][18];
		this.dto.setStart(true);
		dto.DTOinit();
		
	}
	/**
	 * 消行and计算消行
	 * */
	private int plusLine() {
		//initial remove line
		int rline = 0;
		//get gamemap
		boolean[][] map = this.dto.gameMap;
		//scan map
		for (int y =0;y<map[0].length;y++){
			//can remove this line?
			if(canRevome(y,map)){
			// remove line.
			removeLine(y,map);
			rline += 1;
			}
		}
		return rline;	
	}

	
	
	private void removeLine(int line ,boolean[][] map) {
		for (int x = 0; x < map.length; x++) {
			for (int y = line; y > 0; y--) {
				map[x][y] = map[x][y-1];
			}
			map[x][0] = false;
		}
		
	}

	private boolean canRevome(int y ,boolean[][] map) {
		for (int x = 0; x < map.length; x++) {
			if (!map[x][y]) {
				return false;
			}
		}
		return true;
	}

	public void moveLeft() {
		if (dto.isPause()) {
			return;
		}
		synchronized(dto){
			this.dto.gameAct.move(-1, 0,this.dto.getgameMap());
		}
	}
	public void moveRight() {
		if (dto.isPause()) {
			return;
		}
		synchronized(dto){
			this.dto.gameAct.move(1, 0,this.dto.getgameMap());
		}
	}
	
	public void moveQuickDown() {
		if (dto.isPause()) {
			return;
		}
		synchronized(dto){
			while(this.dto.gameAct.move(0, 1,this.dto.getgameMap()))
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			moveDown();
		}
		
	}
	
	public void moveDown() {
		if (dto.isPause()) {
			return;
		}
		synchronized (dto) {
			//固定下落方块
			if(this.dto.gameAct.move(0, 1,this.dto.getgameMap())){
				return;
			}
			
			
			Point[] points = this.dto.gameAct.getPoints();
			for(Point p : points){
				this.dto.setgameMap(p.x,p.y);	
			
			}
			//?消行》》?加分》》?升级》?新方块
			/**
			 * 消行并计算remove lines
			 * */
			int renoveLine= plusLine();
			/**
			 * level up!
			 * */
			levelUp(renoveLine);
			
			//get new rect
			if (this.dto.isStart()) {
				this.dto.gameAct.init(this.dto.getNext());
				this.dto.setNext(new Random().nextInt(6));
			}
			//?无法消行》游戏结束
			if(isLose()){
				//game over
				this.dto.setStart( false);
				//不再创建新对象
				this.dto.gameAct.init(this.dto.getNext());
				
			}
		}
	}

	private boolean isLose() {
		Point[] points = this.dto.getGameAct().actpoints;
		boolean[][] map =this.dto.getgameMap();
		for (int i = 0; i < points.length; i++) {
			if (map[points[i].x][points[i].y]) {
				return true;
			}
		}
		return false;
	}

	// level up 
	private void levelUp(int removeline) {
		int lv = this.dto.getLevel();
		int point = this.dto.getNowPoints();
		int rline = this.dto.getRemoveLine();
		int exp = 0 ;
		for (int i = 0; i < removeline; i++) {
			exp +=10 +i*5;
		}
		rline += removeline;
		point += exp;
		lv = point/100;
		this.dto.setLevel(lv);
		this.dto.setNowPoints(point);
		this.dto.setRemoveLine(rline);
	}


	
	//旋转！！！！！！！
	public void moveUp() {
		if (dto.isPause()) {
			return;
		}
		synchronized (dto) {
			if(this.dto.gameAct.actCode==2)
				return;
				this.dto.gameAct.round(this.dto.getgameMap());;

		}
				
	}
	
	private boolean canMove(int moveX,int moveY){
		Point[] p = this.dto.gameAct.getPoints();
		for(Point point :p){
			if(point.x+moveX<0||point.x+moveX>9||point.y+moveY<0||point.y+moveY>17)
				return false;
		}
		
		return true;
	}
	//数据库接口导入数据到DTO
	public void setDbRecord(List<Player> dbrecord){
		this.dto.setDbRecord(dbrecord);
	}
	
	public void setDiskRecord(List<Player> diskrecord){
		this.dto.setDiskRecord(diskrecord);
	}

	public void changePause() {
		if (dto.isStart()) {
			this.dto.changePause();
		}
	}

	

		
	}


