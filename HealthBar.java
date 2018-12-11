public class HealthBar extends Bar {
	
	private boolean dead;

	public HealthBar(String name, int currentPoint, int maxPoint) {
		super(name, currentPoint, maxPoint);
		this.dead = false;
	}

	public void addCurrentPoint(int point) {
		if (dead)
			return;
		currentPoint += point;
		if (currentPoint > maxPoint)
			currentPoint = maxPoint;
	}

	public void removeCurrentPoint(int point) {
		if (dead)
			return;
		currentPoint -= point;
		if (currentPoint < 0){
			currentPoint = 0;
			dead = true;
		}
	}

	public void addMaxPoint(int point) {
		if (dead)
			return;
		maxPoint += point;

	}

	public void removeMaxPoint(int point) {
		if (dead)
			return;
		maxPoint -= point;
	}

}
