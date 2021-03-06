package destinychild.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import destinychild.domain.MsUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MsUser, Long> {
    Optional<MsUser> findByUserName(String userName);
}