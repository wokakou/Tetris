package control;

import dao.Data;
import dao.DataTest;
import dao.DiskData;
import service.GameService;
import ui.JPanelGame;

public class GameControl {
	private JPanelGame panelGame;
	private GameService gameService;
	/**
	 * �����ӿ�
	 * */
	private Data dataA;
	int i=0;
	/**
	 * �����ӿ�
	 * */
	private Data dataB;
	
	
	
	//���췽��
	public GameControl(JPanelGame panelGame,GameService gameService) {
		this.gameService = gameService;
		this.panelGame = panelGame;
		dataA = new DataTest();
		dataB = new DiskData();
		this.gameService.setDbRecord(dataA.loadPlayerList());
		this.gameService.setDiskRecord(dataB.loadPlayerList());
		
	}
	
	public void moveUp() {
		this.gameService.moveUp();
		this.panelGame.repaint();
	}
	
	public void moveDown() {
		this.gameService.moveDown();
		this.panelGame.repaint();
	}
		
	
	public void moveLeft() {
		this.gameService.moveLeft();
		this.panelGame.repaint();
	}
		
	
	public void moveRight() {
		this.gameService.moveRight();
		this.panelGame.repaint();
	}
	public void moveQuickDown() {
		this.gameService.moveQuickDown();
		this.panelGame.repaint();
		
	}

	public void startGame() {
		//�رտ�ʼ��ť
		this.panelGame.buttonOnOff(false);
		//��ʼ�����ݣ��������߳�
		gameService.startGame();
		//ͨ�������� duixiang������һ���߳�
		MyThread rectDown = new  MyThread();
		//start rectDown
		rectDown.start();
		//ˢ��ҳ��  
		this.panelGame.repaint();
	}
	//create a new thread
	private class MyThread extends Thread{
		@Override
		public void run(){
			//ˢ��ҳ��
			panelGame.repaint();
			while (true) {
				if (!gameService.dto.isStart()) {
					reStart();
					break;
				}
				try {
					//sleep 0.5
					Thread.sleep(500);
					//judge isPause? loop : next
					if (gameService.dto.isPause()) {
						continue;
					}
					//down
					gameService.moveDown();
					System.out.println(1);
					//repaint
					panelGame.repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	
	};
	public void changePause() {
		gameService.changePause();
		panelGame.repaint();
	}

	public  void reStart() {
		this.panelGame.buttonOnOff(true);
	}
}
	
		
	
	


