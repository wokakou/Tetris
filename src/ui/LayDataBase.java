package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import dto.Player;

public class LayDataBase extends Lay {

	private static Image IMG_DB = new ImageIcon("graphics/string/db.png").getImage();
	
	public LayDataBase(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		
	}

	@Override
	public void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_DB, this.x+p, this.y+p,null);
		//绘制数据库值槽
		List<Player> dbPlayers = this.dto.getDbRecord();
		for(int i = 0;i<5;i++){
			Player Player = dbPlayers.get(i);
			int point = Player.getPoint();
			String point_str = Integer.toString(point);
			String name = this.dto.getDbRecord().get(i).getName();
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
