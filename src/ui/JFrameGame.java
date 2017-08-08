package ui;

import javax.swing.JFrame;

public class JFrameGame extends JFrame {
	

	public JFrameGame(JPanelGame panelGame){
		this.setTitle("JAVA俄罗斯方块");
		this.setSize(1216,684);
		this.setResizable(false);
		//设置默认关闭（退出程序）
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//增加panel
		this.setContentPane(panelGame);
		this.setVisible(true);
	}
}
