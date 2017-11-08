package minor.infosupport.player.entities;

public class Player {

	private long id;
	private Position position;

	private long size;

	public long getId() {
		return id;
	}

	public Player setId(long id) {
		this.id = id;

		return this;
	}

	public Position getPosition() {
		return position;
	}

	public Player setPosition(Position position) {
		this.position = position;

		return this;
	}

	public long getSize() {
		return size;
	}

	public Player setSize(long size) {
		this.size = size;

		return this;
	}

}
