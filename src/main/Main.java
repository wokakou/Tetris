package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {
	public static void main(String [] args){
		GameDto dto                  = new GameDto();
		GameService gameService      = new GameService(dto);
		JPanelGame panelGame          = new JPanelGame(dto);
		GameControl gameControl      = new GameControl(panelGame,gameService);
		PlayerControl playerControl  = new PlayerControl(gameControl);
		panelGame.setPlayerControl(playerControl);
		panelGame.setGameControl(gameControl);
		JFrameGame frameGame          = new JFrameGame(panelGame);
	}
}
