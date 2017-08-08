package ui;


import java.awt.Graphics;
import java.awt.Image;


import javax.swing.ImageIcon;

public class LayPoint extends Lay {

	private static Image IMG_P = new ImageIcon("graphics/string/point.png").getImage();
	private static Image IMG_P2 = new ImageIcon("graphics/string/point2.png").getImage();
	
	private static final int LEVEL_UP = 100;
	public LayPoint(int x, int y, int w, int h){
		
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_P, this.x+p, this.y+p, null);
		g.drawImage(IMG_P2, this.x+p, this.y+p+50, null);
		
		drawNum(100, 20, this.dto.getNowPoints(), 6, g);
		
		drawNum(100, 70, this.dto.getRemoveLine(), 6, g);
		
		
		double exp_left = (double)(this.dto.getNowPoints()%LEVEL_UP)/(double)LEVEL_UP;
		int exp =(int)(exp_left*IMG_W) ;
		drawExp(this.x,	this.y ,100,exp,g);
		drawString(this.x,	this.y ,100,0,"NEXT LEVEL" ,g);
		
		
		
		
	}
}
