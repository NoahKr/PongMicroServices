package minor.infosupport.arena.entities;

public class Arena {

	private int leftBound = -7;
	private int rightBound = 7;

	private int topBound = 7;
	private int bottomBound = -7;

	public Arena() {
	}

	public Arena(int leftBound, int rightBound, int topBound, int bottomBound) {
		this.leftBound = leftBound;
		this.rightBound = rightBound;
		this.topBound = topBound;
		this.bottomBound = bottomBound;
	}

	public int getLeftBound() {
		return leftBound;
	}

	public void setLeftBound(int leftBound) {
		this.leftBound = leftBound;
	}

	public int getRightBound() {
		return rightBound;
	}

	public void setRightBound(int rightBound) {
		this.rightBound = rightBound;
	}

	public int getTopBound() {
		return topBound;
	}

	public void setTopBound(int topBound) {
		this.topBound = topBound;
	}

	public int getBottomBound() {
		return bottomBound;
	}

	public void setBottomBound(int bottomBound) {
		this.bottomBound = bottomBound;
	}
}
