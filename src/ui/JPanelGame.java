package ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;




public class JPanelGame extends JPanel{
	private Lay[] lays = null;
	protected GameDto dto = null;
	private JButton btnStart;
	private GameControl gameControl;
	private JButton btnPause;
	public JPanelGame(GameDto dto){ 
		this.dto = dto;
		initComponent1();
		initComponent2();
		
		//Ӳ����ǳ�����
		//�������ַ��������ֶ���Ϊ���� ��д�������ļ�
		lays = new Lay[]{
			new Laybackground(0,0,1216,684),	
			new LayDataBase(70,40,280,264),
			new LayDisk(70,350,280,264),
			new LayGame(432,40,333,589),
			new LayButton(860,40,280,104),
			new LayNext(860,165,159,124),
			new LayLevel(1018,165,121,124),
			new LayPoint(860,310,280,160),
			new LayAbout(860,480,280,160),	
		};
		
	}
		
	//�������飬������ӡ�����ӱ�����

//���⣡��������������
		//!!!!!!!this.addKeyListener(new PlayerControl(gameControl..));���췽������ѭ������ ���鷳
		//����Ҫplayercontrol��ʵ�ʶ��󡣶���������
		//��main�����е��ñ��������¼�������
	public void setPlayerControl(PlayerControl playerControl){
		
		this.addKeyListener(playerControl);
		
		}
	public void paintComponent(Graphics g){
		for(int i=0;i<lays.length;i++){
		lays[i].setDto(dto);
		lays[i].paint(g);
		
		}
		
		//����¼��������㼴��������
		this.requestFocus();
		
	}
	public void setGameControl(GameControl gameControl){
		this.gameControl = gameControl;
	}
	//���ð�ť ��Ӽ�����
	private void initComponent1() {
		this.btnStart = new JButton(new ImageIcon("graphics/string/start.icon"));
		setLayout(null);
		this.btnStart.setBounds(860+20, 66, 100, 50);
		this.btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameControl.startGame();
			}
		});
		this.add(btnStart);
	}
	private void initComponent2() {
		this.btnPause = new JButton(new ImageIcon("graphics/string/pause02.png"));
		btnPause.setLayout(null);
		this.btnPause.setBounds(860+140, 66, 100, 50);
		this.btnPause.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						gameControl.changePause();
					}
				});
		this.add(btnPause);
	}
	//���ð�ť����״̬
	public void buttonOnOff(boolean onOff) {
		this.btnStart.setEnabled(onOff);
		this.btnStart.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						gameControl.changePause();
					}
				});
		this.add(btnStart);
	}
}

