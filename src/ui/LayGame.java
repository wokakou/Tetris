package ui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.IllegalFormatCodePointException;

import javax.swing.ImageIcon;
import javax.swing.ProgressMonitorInputStream;

import org.omg.CORBA.PUBLIC_MEMBER;

import entity.GameAct;

public class LayGame extends Lay {
	

	private static Image IMG_G = new ImageIcon("graphics/string/pause.png").getImage();
	private static Image IMG_ACT = new ImageIcon("graphics/game/rect.jpg").getImage();
	private static int IMG_SIZE=16;
	private static int ACT_SIZE=32;
	private static int PADDING=7;
	public LayGame(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		this.createWindow(g);
		//get 
		GameAct gAct = this.dto.getGameAct();
		boolean[][] map = this.dto.getgameMap();
		if(gAct!=null){
			int actCode = this.dto.isStart() ?this.dto.getGameAct().actCode : -1;
			Point[] points = gAct.getPoints();
				//绘制活动方块
				drawActRect(actCode,points, g);
				//绘制固定方块
				drawDownRect(map,g);
		//绘制Pause
		if (dto.isPause()) {
			g.drawImage(IMG_G, this.x+80, this.y+250, null);
			
		}
		}
		
		
	}
	//绘制活动方块
	public void drawActRect(int actCode,Point[] points,Graphics g){
		
		for(int i=0;i<points.length;i++){
			g.drawImage(IMG_ACT, this.x+PADDING+points[i].x*ACT_SIZE,
								 this.y+PADDING+points[i].y*ACT_SIZE,
								 this.x+PADDING+ACT_SIZE+points[i].x*ACT_SIZE,
								 this.y+PADDING+ACT_SIZE+points[i].y*ACT_SIZE,
								 (2+actCode)*IMG_SIZE, 7*IMG_SIZE, (3+actCode)*IMG_SIZE,8*IMG_SIZE, null);
			
			}
		
	}
	
	//绘制固定方块
	public void drawDownRect(boolean[][] map,Graphics g){
		int i = this.dto.isStart() ? 0 : 1;
		for(int x = 0;x<map.length;x++){
			for(int y = 0;y<map[x].length;y++){
				if(map[x][y]){
					g.drawImage(IMG_ACT,
							 this.x+PADDING+x*ACT_SIZE,
							 this.y+PADDING+y*ACT_SIZE,
							 this.x+PADDING+ACT_SIZE+x*ACT_SIZE,
							 this.y+PADDING+ACT_SIZE+y*ACT_SIZE, 
							 i*IMG_SIZE, 7*IMG_SIZE, (i+1)*IMG_SIZE,8*IMG_SIZE, null);
				}
			}
		}
		
	}
	

}
