package destinychild.repository;

import destinychild.domain.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordinateRepository extends JpaRepository<SolarSystem, Long> {
    List<SolarSystem> findByuserId(Long userId);
}