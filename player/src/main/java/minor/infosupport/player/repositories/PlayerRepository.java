package minor.infosupport.player.repositories;

import minor.infosupport.player.entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
