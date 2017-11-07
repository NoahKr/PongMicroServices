package minor.infosupport.score.repositories;

import minor.infosupport.score.entities.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {

}
