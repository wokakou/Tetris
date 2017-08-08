package dao;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Player;


public class DiskData implements Data {
	
	private static  final String FILE_ADDRESS = "save/record.dat";
	
	//¹¹ÔìÆ÷
	public static void main (String[]args) {
		DiskData dd = new DiskData();
		List<Player> players =new ArrayList<Player>();
		players.add(new Player("haha",2234));
		players.add(new Player("haha",1000));
		players.add(new Player("haha",6500));
		
		players.add(new Player("haha",10000));
		dd.savePlayerList(players);
		List<Player> ddFromDisk =(List<Player>)dd.loadPlayerList();
		
		
	}
	
	
	@Override
	public  void savePlayerList(List<Player> players) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_ADDRESS));
			oos.writeObject(players);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public List<Player> loadPlayerList()  {
		ObjectInputStream ois =null;
		List<Player> players =null;
		try {
			ois = new ObjectInputStream(new FileInputStream(FILE_ADDRESS));
			players= (List<Player>)ois.readObject();
		}  catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return players;
	
	}

	

}
