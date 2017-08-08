package entity;



import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


public class GameAct {
	private static final int MIN_X =0;
	private static final int MAX_X =9;
	private static final int MIN_Y =0;
	private static final int MAX_Y =17;
	
	public int actCode = new Random().nextInt(6);
	public 	Point[] actpoints = null;
	private  static final ArrayList<Point[]> RECT_TYPE =new ArrayList<Point[]>(7);
	
	static{
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(4,1),new Point(5,1)});
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(5,0),new Point(6,0)});
		RECT_TYPE.add( new Point[]{new Point(4,0),new Point(4,1),new Point(5,1),new Point(5,0)});
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(4,1),new Point(5,0)});
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(5,0),new Point(5,1)});
		RECT_TYPE.add( new Point[]{new Point(3,0),new Point(4,0),new Point(3,1),new Point(5,0)});
		RECT_TYPE.add( new Point[]{new Point(3,1),new Point(4,0),new Point(4,1),new Point(5,0)});
		}
	
	//���캯��
	public GameAct (int actCode) {
		
		init(actCode);
			
		}
	//��ʼ��
	public void init(int actCode){
	//Java���˻������͵Ķ��󣬶������ô��ݡ�ֻ�ı����ƣ���ַ���䡣�޸�actpoints��ı�RECT_TYPE��ֵ
	//������Ŀ�����newһ���µĶ��󣬷����µ��ڴ��ַ��	
		actpoints =new Point[4];
		for(int i = 0;i<actpoints.length;i++){
			actpoints[i] = new Point(RECT_TYPE.get(actCode)[i].x, RECT_TYPE.get(actCode)[i].y);
		
		}
		this.actCode=actCode;
	}
	
	
	public Point[] getPoints() {
		return actpoints;
	}
	
	public boolean isOverZone(int x,int y,boolean[][] gameMap){
			
			return x<MIN_X||x>MAX_X||y<MIN_Y||y>MAX_Y||gameMap[x][y];
			
		}
	
	public boolean move(int moveX,int moveY,boolean[][] gameMap){
		for(int i= 0;i<actpoints.length;i++){
			int newX = actpoints[i].x+moveX;
			int newY = actpoints[i].y+moveY;
			if (isOverZone(newX, newY,gameMap)) {
				return false;
			}
		}
		for(int i= 0;i<actpoints.length;i++){
			actpoints[i].x += moveX;
			actpoints[i].y += moveY;
			

		}
		return true;
	}
	
	/**
	 * �ѿ�����ת��ʽ��˳ʱ�룩
	 * A.x=0.y+0.x-B.y
	 * A.y=0.x-0.y+B.x
	 * 
	 * @param moveX
	 * @param moveY
	 */
	public void round(boolean[][] gameMap){  
		for(int i= 0;i<actpoints.length;i++){
			int newX = actpoints[1].y+actpoints[1].x-actpoints[i].y;
			int newY = actpoints[1].y-actpoints[1].x+actpoints[i].x;
			if (isOverZone(newX, newY,gameMap)) {
				return;
			}
		}
		for(int i= 0;i<actpoints.length;i++){
			int newX = actpoints[1].y+actpoints[1].x-actpoints[i].y;
			int newY = actpoints[1].y-actpoints[1].x+actpoints[i].x;
			actpoints[i].x = newX;
			actpoints[i].y = newY;

		}
	}
	
}
	



