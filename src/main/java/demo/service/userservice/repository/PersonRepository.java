package demo.service.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.service.userservice.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{

}
