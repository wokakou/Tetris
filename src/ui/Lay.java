package ui;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.IllegalFormatCodePointException;

import javax.swing.ImageIcon;

import dto.GameDto;

public abstract class Lay {
	//左上x
	protected int x;
	//左上y
	protected int y;
	//窗口宽度
	protected int w;
	//窗口高度
	protected int h;
	//添加对象的内边距
	protected int p =14;
	//引入DTO
	protected GameDto dto = null;
	//值槽 中间图片宽度
	protected static final int IMG_W = 246;
	private static final int SW = 16;
	private static final int SI = 16;
	private static Image IMG = new ImageIcon("graphics/window/window02.jpg").getImage();
	private static Image IMG2 = new ImageIcon("graphics/window/window.png").getImage();
	private static final int SIZE = IMG.getWidth(null);
	private static Image IMG_NUM = new ImageIcon("graphics/string/num.png").getImage();
	private static Image IMG_EXP1 = new ImageIcon("graphics/game/exp1.png").getImage();
	private static Image IMG_EXP2 = new ImageIcon("graphics/game/exp2.png").getImage();	
	
	
	public Lay(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = x+w;
		this.h = y+h;
	}
	
	protected void createWindow(Graphics g){
		//background
        g.drawImage(IMG2,x, y,   w,  h     , 0  , 0     ,230,230, null);
        //LU
		g.drawImage(IMG,x, y, x+SW,y+SW    , SIZE/2,0,SIZE/2+SI,SI, null);
		//MU
		g.drawImage(IMG,x+SW, y, w-SW,y+SW , SIZE/2+SI,0,SIZE-SI,SW, null);
		//RU
		g.drawImage(IMG,w-SW, y, w, y+SW   , SIZE-SI,0,SIZE,SW ,null);
		//LM
		g.drawImage(IMG,x, y+SW, x+SW,h-SW , SIZE/2,SI,SIZE/2+SW,SIZE/2-SI, null);
		//LD
		g.drawImage(IMG,x, h-SW, x+SW,h    , SIZE/2,SIZE/2-SI,SIZE/2+SI,SIZE/2, null);
		//MD
		g.drawImage(IMG,x+SW,h-SW, w-SW,h  , SIZE/2+SI,SIZE/2-SW,SIZE-SI,SIZE/2, null);
		//RD
		g.drawImage(IMG,w-SW,h-SW, w, h    , SIZE-SI, SIZE/2-SI, SIZE,SIZE/2, null);
		//RM
		g.drawImage(IMG,w-SW, y+SW, w,h-SW , SIZE-SW,SI, SIZE, SIZE/2-SI, null);
	}


	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	abstract public void paint(Graphics g);
	
	//绘制游戏中的数字
	protected  void drawNum(int x ,int y,int num,int maxBit,Graphics g) {
		String strNum = Integer.toString(num);
		for (int i = 0;i<strNum.length();i++){
			int bit = strNum.charAt(i)-'1';
			int leftbit = maxBit - strNum.length();
			if (leftbit<0)
				return;
			if (strNum.charAt(i)=='0'){
				g.drawImage(IMG_NUM, this.x+x+(i+leftbit)*p, this.y+y, this.x+x+((i+leftbit)+1)*p,this.y+y+2*p, 253, 0, 280, 40, null);
			}
				g.drawImage(IMG_NUM, this.x+x+(i+leftbit)*p, this.y+y, this.x+x+((i+leftbit)+1)*p,this.y+y+2*p, bit*28, 0, (bit+1)*28-3, 40, null);
		}
	}
	
	//绘制值槽
	protected void drawExp(int x,int y,int padding_y,int value,Graphics g) {
		g.drawImage(IMG_EXP1, x+p, y+p+padding_y,250, 30, null);
		g.drawImage(IMG_EXP2, x+p+2, y+p+padding_y+2,x+p+2+value, y+p+padding_y+28, value,0,value+1,21,null);
		
	}
	protected void drawString(int x,int y,int padding_y,int x_left,String str,Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("TimeRoman",Font.CENTER_BASELINE,14));
		g.drawString(str, x+p+5+x_left, y+p+padding_y+19);
		
	}
	
}

