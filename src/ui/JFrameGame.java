package ui;

import javax.swing.JFrame;

public class JFrameGame extends JFrame {
	

	public JFrameGame(JPanelGame panelGame){
		this.setTitle("JAVA����˹����");
		this.setSize(1216,684);
		this.setResizable(false);
		//����Ĭ�Ϲرգ��˳�����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//����panel
		this.setContentPane(panelGame);
		this.setVisible(true);
	}
}
