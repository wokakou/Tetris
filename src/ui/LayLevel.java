package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import org.omg.CORBA.PUBLIC_MEMBER;

public class LayLevel extends Lay {

	private static Image IMG_LL= new ImageIcon("graphics/string/level.png").getImage();
	
	
	public LayLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_LL, this.x+p, this.y+p, null);
		
		this.drawNum(20, 70, this.dto.getLevel(), 5, g);
	}
	
	
	
}
		


