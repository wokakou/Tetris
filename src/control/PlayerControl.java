package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter {
	
	private GameControl gameControl;
		
	//���췽��
	public PlayerControl(GameControl gameControl){
		this.gameControl = gameControl;
	}
	
	//��Ӽ�����
	//ö�ٷ���̫ҵ�࣡����  
	//switch case ��������������ӳ��!!
	public void keyPressed(KeyEvent e){
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.gameControl.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			this.gameControl.moveDown();
			break;
		case KeyEvent.VK_LEFT:
			this.gameControl.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.gameControl.moveRight();
			break;
		case KeyEvent.VK_SPACE:
			this.gameControl.moveQuickDown();
			break;
		default:
			break;
		}
	}

}
