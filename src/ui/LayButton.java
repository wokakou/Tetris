package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LayButton extends Lay {
	private static Image IMG_BT1 = new ImageIcon("graphics/string/start.icon").getImage();
	private static Image IMG_BT2 = new ImageIcon("graphics/string/exit.png").getImage();
	
	
	
	public LayButton(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_BT1, this.x+2*p, this.y+p+20, null);
		g.drawImage(IMG_BT2, this.x+2*p+130, this.y+p+20, null);
	}

	
}
