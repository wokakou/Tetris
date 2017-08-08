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
	 * 创建接口
	 * */
	private Data dataA;
	int i=0;
	/**
	 * 创建接口
	 * */
	private Data dataB;
	
	
	
	//构造方法
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
		//关闭开始按钮
		this.panelGame.buttonOnOff(false);
		//初始化数据，启动主线程
		gameService.startGame();
		//通过创建类 duixiang，构建一个线程
		MyThread rectDown = new  MyThread();
		//start rectDown
		rectDown.start();
		//刷新页面  
		this.panelGame.repaint();
	}
	//create a new thread
	private class MyThread extends Thread{
		@Override
		public void run(){
			//刷新页面
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
	
		
	
	


