package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayAbout extends Lay {
private static Image IMG_SET= new ImageIcon("graphics/game/settings.png").getImage();
	
	public LayAbout(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	@Override
	public void paint(Graphics g) {
		
		this.createWindow(g);
		g.drawImage(IMG_SET, this.x+7, this.y+7, 280-14, 160-14, null);
		
	}
}
