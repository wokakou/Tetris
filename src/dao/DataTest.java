package dao;



import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data {
	public  List<Player> loadPlayerList(){
		List<Player> players = new ArrayList<>();
			players.add(new Player("haha",222));
			players.add(new Player("haha",1000));
		
	
			players.add(new Player("haha",10000));
		return players;
	}
	public void savePlayerList( List<Player> players) {
		
	}
}
