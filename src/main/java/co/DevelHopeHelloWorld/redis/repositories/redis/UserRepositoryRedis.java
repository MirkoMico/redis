package co.DevelHopeHelloWorld.redis.repositories.redis;

import co.DevelHopeHelloWorld.redis.entity.redis.UserRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryRedis extends CrudRepository<UserRedis, Long> {
}
