package spring.vuejs.samples;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.vuejs.samples.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
