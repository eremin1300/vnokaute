package training.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.demo.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User FindByUsername(String username);
}
