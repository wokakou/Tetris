package ui;

import java.awt.Graphics;
import java.awt.Image;


import javax.swing.ImageIcon;

public class Laybackground extends Lay {
	
	private static Image IMG_BG = new ImageIcon("graphics/background/bg01.jpg").getImage();
	
	public Laybackground(int x, int y, int w, int h){
		
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(IMG_BG, 0, 0, null);

	}

	}
	
