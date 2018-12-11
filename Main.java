import java.util.*;

public class Main {
	public static void main(String[] args) {		
		Cell[][] cells = new Cell[16][16];

		int chestPos = 5;
		int hollywater = 7;
		int acide = 12;
		int game1 = 160;
		int game2 = 200;


		int counter = 0;
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if (counter == chestPos) {
					cells[i][j] = new Cell(new Chest());
				} else if (counter == hollywater) {
					cells[i][j] = new Cell(new HolyWater());
				} else if (counter == acide) {
					cells[i][j] = new Cell(new Acid());
				}else if(counter == game1){
					cells[i][j] = new Cell(new Game1());
				}else if(counter == game2){
					cells[i][j] = new Cell(new Game2());
				} else {
					cells[i][j] = new Cell(new Ground());
				}
				
				counter++;
			}
		}

		Area areaTwo = new Area(cells, "Area");
		
		List<Area> areas = new ArrayList<Area>();

		areas.add(areaTwo);

		World world = new World(areas);
		
		
		Stats stats = new Stats(100, 100);
		HealthBar healthBar = new HealthBar("HealthBar", 100, 200);
		List<Item> bag = new ArrayList<Item>();
		
		Player player = new Player("PlayerOne", 100, stats, healthBar, bag, 'J', new Position(0, 0, "Area"));

		// Adding the reaction
		world.getAreaByName("Area").getArea()[0][12].addReaction(new ActionDamage(10));
		world.getAreaByName("Area").getArea()[0][7].addReaction(new ActionDamage(10));
		world.getAreaByName("Area").getArea()[0][5].addReaction(new ActionDamage(10));
		
		
		// move player
		player.gameMove(world);
		
		// After walking on Reaction cell
		System.out.println(player.getHealthBar().getCurrentPoint());
		
	}

}
