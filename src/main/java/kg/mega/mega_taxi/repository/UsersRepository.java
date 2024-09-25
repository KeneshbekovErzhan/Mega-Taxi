package kg.mega.mega_taxi.repository;

import kg.mega.mega_taxi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
