import java.util.*;


public class Player implements Tangible {
	private String name;
	private int point;
	private HealthBar healthBar;
	private Stats stats;
	private List<Item> bag;
	private Hat hat;
	private Dress dress;
	private Boots boots;
	private char symbol;
	private Position position;
	
 
	public Player(String name, int point, Stats stats, HealthBar healthBar, List<Item> listItem, char symbol, Position position) {
		this.name = name;
		this.point = point;
		this.stats = stats;
		this.healthBar = healthBar;
		this.bag = listItem;
		this.symbol = symbol;
		this.position = position;
		
	}
	
	

	public char getSymbol() {
		return symbol;
	}
	
	public Position getPosition() {
		return this.position;
	}
	public char showAs() {
		return this.symbol;
	}
	
	public void gameMove(World world){
		
		boolean on = true;
		
		world.print(); //affichage du map avant
		
		while(on){
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir la première lettre d'une direction en majuscule :");
			String str = sc.nextLine();
			
			if (str.equals("N")) {
				movePlayer(world, Direction.NORTH);
				world.print();
			}
			else if (str.equals("E")) {
				movePlayer(world, Direction.EAST);
				world.print();
			}
			else if (str.equals("W")) {
				movePlayer(world, Direction.WEST);
				world.print();
			}
			else if (str.equals("S")) {
				movePlayer(world, Direction.SOUTH);
				world.print();
			}
			else {
				System.out.println("Player didn't move!");
				on = false;
			}
			
		}
		
	}
	
	
	public boolean movePlayer(World world, Direction direction){
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		Cell[][] exemple;
		exemple = world.getAreas().get(0).getArea();
		String name = this.position.getCurrentMap();
		
		if ((direction == Direction.NORTH) && (exemple[0].length >= y) && (y>0) && (exemple.length >= x)) {
			System.out.println( "Player moved!");
			this.position = new Position(x, y-1, name);
			exemple[x][y].removeTangible(this);
			exemple[x][y-1].addTangible(this);
			
			if ((world.getAreaByName(this.position.getCurrentMap()).getArea()[this.position.getX()][this.position.getY()].isEmptyReaction()) == false) {
				for (Reaction reaction : world.getAreaByName(this.position.getCurrentMap()).getArea()[this.position.getX()][this.position.getY()].getListReactions()) {
					reaction.action(this);
				}
			}
			
			return true;
		}
		
		else if ((direction == Direction.SOUTH) && (y>=0) && (y+1 < exemple[0].length) && (x>=0)) {
			System.out.println( "Player moved!");
			this.position = new Position(x, y+1, name);
			exemple[x][y].removeTangible(this);
			exemple[x][y+1].addTangible(this);
			
			if ((world.getAreaByName(this.position.getCurrentMap()).getArea()[this.position.getX()][this.position.getY()].isEmptyReaction()) == false) {
				for (Reaction reaction : world.getAreaByName(this.position.getCurrentMap()).getArea()[this.position.getX()][this.position.getY()].getListReactions()) {
					reaction.action(this);
				}
			}
			return true;
		}
		else if ((direction == Direction.EAST) && (x>=0) && (y>= 0) && (x + 1 < exemple.length)) {
			System.out.println( "Player moved!");
			position = new Position(x+1, y, this.position.getCurrentMap());
			exemple[x][y].removeTangible(this);
			exemple[x+1][y].addTangible(this);
			
			if ((world.getAreaByName(this.position.getCurrentMap()).getArea()[this.position.getX()][this.position.getY()].isEmptyReaction()) == false) {
				for (Reaction reaction : world.getAreaByName(this.position.getCurrentMap()).getArea()[this.position.getX()][this.position.getY()].getListReactions()) {
					reaction.action(this);
				}
			}
			return true;	
		} 
			
		else if ((direction == Direction.WEST) && (exemple[0].length > y) && (x>0) && (exemple.length > x)) {
			System.out.println( "Player moved!");
			this.position = new Position(x-1, y, name);
			exemple[x][y].removeTangible(this);
			exemple[x-1][y].addTangible(this);
			if ((world.getAreaByName(this.position.getCurrentMap()).getArea()[this.position.getX()][this.position.getY()].isEmptyReaction()) == false) {
				for (Reaction reaction : world.getAreaByName(this.position.getCurrentMap()).getArea()[this.position.getX()][this.position.getY()].getListReactions()) {
					reaction.action(this);
				}
			}
			return true;
		}
		
		else {
			System.out.println("Player didn't move!");
			return false;
		}
	}
	
	public void removeHat() {
		this.hat.remove(this);
		bag.add(this.hat);
		this.hat = null;
	}
	
	public void putHat(Hat hat) {
		if (this.hat != null) {
			removeHat();
		}
		this.hat = hat;
		this.hat.put(this);
	}
	

	public void removeDress() {
		this.dress.remove(this);
		bag.add(this.dress);
		this.dress = null;
	}
	
	public void putDress(Dress dress) {
		if (this.dress != null) {
			removeDress();
		}
		this.dress = dress;
		this.dress.put(this);
	}
	

	public void removeBoots() {
		this.boots.remove(this);
		bag.add(this.boots);
		this.boots = null;
	}
	
	public void putBoots(Boots boots) {
		if (this.boots != null) {
			removeBoots();
		}
		this.boots = boots;
		this.boots.put(this);
	}

	public void attack(Player player){
		if (this.stats.getAttack() > player.getStats().getDefence()){
			int i = stats.getAttack() - player.getStats().getDefence();
			if (i < 0){
				i = 0;
			}
			player.getHealthBar().removeCurrentPoint(i);
		}
	}

	public HealthBar getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(HealthBar healthBar) {
		this.healthBar = healthBar;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}

	public void resetScore() {
		this.point = 0;
	}

	public void addScore(int point) {
		this.point += point;
	}

	public void removeScore(int point) {
		this.point -= point;
	}

	public String toString() {
		return "Name : " + name + ", Point : " + point;
	}

	public Stats getStats() {
		return stats;
	}
	
	public void printBag() {
		int n = 1;
		if (bag.isEmpty()) {
			System.out.println( "Bag Empty" );
		}
		
		for (Item items : bag) {
			if (items.getName() != null) {
				System.out.println(n+" -> " + items.getName());
				n++;
			}
		}
		
		
	}



	public void action(Player player) {
		// TODO Auto-generated method stub
		
	}


	public void takeDamage(int damagePoint) {
		this.healthBar.removeCurrentPoint(damagePoint);
		if (healthBar.currentPoint < 0) {
			healthBar.currentPoint = 0;
		}
	}


	public void heal(int healPoint) {
		this.healthBar.addCurrentPoint(healPoint);
		if (healthBar.currentPoint > healthBar.maxPoint ) {
			healthBar.maxPoint = healthBar.currentPoint;
		}
	
	}
	
}
