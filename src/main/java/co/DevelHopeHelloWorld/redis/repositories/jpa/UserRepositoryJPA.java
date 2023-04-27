package co.DevelHopeHelloWorld.redis.repositories.jpa;

import co.DevelHopeHelloWorld.redis.entity.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<UserJPA,Long> {
    @Override
    UserJPA getById(Long aLong);
}
