package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;




public class LayNext extends Lay {
	private static Image IMG_ACT = new ImageIcon("graphics/game/rect.jpg").getImage();
	private static int IMG_SIZE=16;
	private static int ACT_SIZE=32;
	private static int PADDING=25;
	private static final ArrayList<Point[]> RECT_TYPE =new ArrayList<Point[]>(7);
	
	public LayNext(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	static{
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(4,1),new Point(5,1)});
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(5,0),new Point(6,0)});
		RECT_TYPE.add( new Point[]{new Point(4,0),new Point(4,1),new Point(5,1),new Point(5,0)});
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(4,1),new Point(5,0)});
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(5,0),new Point(5,1)});
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(3,1),new Point(5,0)});
		RECT_TYPE.add( new Point[]{new Point(3,1),new Point(4,0),new Point(4,1),new Point(5,0)});
		}
	
	@Override
	public void paint(Graphics g) {
		//绘制窗口
		this.createWindow(g);
		//绘制下一个图形
		if(this.dto.getGameAct()!=null)
			drawNext(g);
		
		}
	//绘制下一个图形
	private void drawNext(Graphics g){
		int nxet_ActCode = this.dto.getNext();
		int j=0;
		Point[] points_C = new Point[4];
		points_C = RECT_TYPE.get(nxet_ActCode).clone();
		Point p = new Point(RECT_TYPE.get(nxet_ActCode)[0].x,RECT_TYPE.get(nxet_ActCode)[0].y);
		for(int i=0;i<points_C.length;i++){
		points_C[i].x -= p.x;
		points_C[i].y -= p.y;
		g.drawImage(IMG_ACT, this.x+PADDING+points_C[i].x*ACT_SIZE,
							 this.y+PADDING+points_C[i].y*ACT_SIZE,
							 this.x+PADDING+ACT_SIZE+points_C[i].x*ACT_SIZE,
							 this.y+PADDING+ACT_SIZE+points_C[i].y*ACT_SIZE,
							 (2+nxet_ActCode)*IMG_SIZE, 7*IMG_SIZE, (3+nxet_ActCode)*IMG_SIZE,8*IMG_SIZE, null);

	}
	}
}
	


