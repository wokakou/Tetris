package dao;

import java.util.List;

import dto.Player;



public interface Data {
	
	public  List<Player> loadPlayerList();
	
	public  void savePlayerList(List<Player> players) ;

	
}