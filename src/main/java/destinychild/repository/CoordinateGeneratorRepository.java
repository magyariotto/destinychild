package destinychild.repository;

import destinychild.domain.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CoordinateGeneratorRepository extends JpaRepository<SolarSystem, String> {
    Optional<SolarSystem> findByCoordinateFull(String coordinateFull);
}
