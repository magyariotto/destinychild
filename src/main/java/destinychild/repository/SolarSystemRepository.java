package destinychild.repository;

import destinychild.domain.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SolarSystemRepository extends JpaRepository<SolarSystem, Integer> {
    List<SolarSystem> findByCoordinateUniverseAndCoordinateSystem(Integer universenumber , Integer systemnumber);
}