package demo.service.userservice.repository;

import demo.service.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findUsersByFirstName(String username);
    // select * from User where firstName = ' ';

    @Query("from User where firstName = :username")
    User myquery(String username);



}
