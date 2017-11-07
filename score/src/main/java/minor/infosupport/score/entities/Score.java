package minor.infosupport.score.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Score {

	@Id
	private long id;

	private long points;

	public long getId() {
		return id;
	}

	public Score setId(long id) {
		this.id = id;

		return this;
	}

	public long getPoints() {
		return points;
	}

	public Score setPoints(long points) {
		this.points = points;

		return this;
	}
}
