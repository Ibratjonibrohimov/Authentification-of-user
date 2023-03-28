package uz.practice7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.practice7.entity.Clients;


public interface UserRepository extends JpaRepository<Clients,Integer> {
    boolean existsByUsername(String username);
    boolean existsByUsernameAndPassword(String username, String password);
    boolean existsByPassword(String password);
    boolean existsByPhoneNumber(String phoneNumber);

}
