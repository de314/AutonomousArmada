package autonomousarmada.bot;

import java.util.LinkedList;
import java.util.List;

import battlechallenge.Coordinate;
import battlechallenge.ShipAction;
import battlechallenge.ShipIdentifier;
import battlechallenge.bot.ClientPlayer;
import battlechallenge.client.ClientGame;
import battlechallenge.ship.Ship;
import battlechallenge.ship.Ship.Direction;

/**
 * The Class ClientPlayer.
 */
public class StarterBot extends ClientPlayer {
	
	/**
	 * Instantiates a new starter bot.
	 *
	 * @param playerName the player name
	 * @param mapWidth the map width
	 * @param mapHeight the map height
	 * @param networkID the network id
	 */
	public StarterBot(final String playerName, final int mapWidth, final int mapHeight, final int networkID) {
		super (playerName,mapWidth, mapHeight, networkID);
	}
	
	/**
	 * This class will be filled in by the player. All logic regarding in game decisions to be
	 * made by your bot should be put in here. This class will be called every turn until the
	 * end of the game
	 *
	 * @return a List of coordinates corresponding to where you wish to fire
	 */
	
	int count = 0;
	public List<ShipAction> doTurn() {
		List<ShipAction> actions = new LinkedList<ShipAction>();
		List<Coordinate> shotCoord = new LinkedList<Coordinate>();
		List<Direction> moveCoord = new LinkedList<Direction>();
//		shotCoord.add(null);
		shotCoord.add(new Coordinate(10,10));
		moveCoord.add(Direction.NORTH);
		ShipIdentifier shipID = null;
		int i = 0;
		for (Ship s: ClientGame.getMyShips()) {
			if (i == 0) {
				shipID = s.getIdentifier();
			}
			if (i > 0) {
				moveCoord.clear();
				moveCoord.add(Direction.SOUTH);
				shotCoord.add(new Coordinate(10,9));
			}
			actions.add(new ShipAction(shipID, shotCoord, moveCoord)); 
			i++;
		}
		count+= 200;
		if (count > 1000) {
			count = 0;
		}
		try {
			Thread.sleep(count); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actions;
	}
}

