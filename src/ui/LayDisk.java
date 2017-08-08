package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import dto.Player;

public class LayDisk extends Lay {
	
	private static Image IMG_LD = new ImageIcon("graphics/string/world.png").getImage();
	
	public LayDisk(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_LD, this.x+p, this.y+p, null);
		//绘制数据库值槽
		List<Player> diskPlayers = this.dto.getDiskRecord();
		for(int i = 0;i<5;i++){
			Player Player = diskPlayers.get(i);
			int point = Player.getPoint();
			String point_str = Integer.toString(point);
			String name = this.dto.getDiskRecord().get(i).getName();
			double nowPoint = this.dto.getNowPoints();
			double percent =nowPoint/(double)point;
			percent = percent>=1 ? 1 : percent;
			int exp = (int)(percent*IMG_W)-1;
			drawExp(this.x, this.y, 40+40*i, exp, g);
			drawString(this.x, this.y, 40+40*i, 0,name, g);
			int length = point_str.length();
			int x_left = (6 - length)*6;
			point_str= point == 0 ? "":point_str;
				drawString(this.x+180, this.y, 40+40*i,x_left,point_str, g);
			}

	}
}
