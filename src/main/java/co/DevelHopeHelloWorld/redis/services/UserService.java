package co.DevelHopeHelloWorld.redis.services;

import co.DevelHopeHelloWorld.redis.entity.User;
import co.DevelHopeHelloWorld.redis.entity.jpa.UserJPA;
import co.DevelHopeHelloWorld.redis.entity.redis.UserRedis;
import co.DevelHopeHelloWorld.redis.repositories.jpa.UserRepositoryJPA;
import co.DevelHopeHelloWorld.redis.repositories.redis.UserRepositoryRedis;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepositoryJPA userRepositoryJPA;
    @Autowired
    public UserRepositoryRedis userRepositoryRedis;

    public UserRedis convertData(UserJPA user) {
        UserRedis userRedis = new UserRedis();
        BeanUtils.copyProperties(user ,userRedis);
        return userRedis;
    }
    public UserJPA convertData(UserRedis user){
        UserJPA userRedis = new UserJPA();
        BeanUtils.copyProperties(user, userRedis);
        return userRedis;
    }

    public UserJPA create(UserJPA user) {
        if (user == null) return null;
        user.setId(null);
        return userRepositoryJPA.save(user);

    }

    public List<? extends User> readAll() {
        return userRepositoryJPA.findAll();

    }

    public User readOne(Long id) {
        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
        if (userRedis.isPresent()) {
            return userRedis.get();
        } else {
            UserJPA userFromDb= userRepositoryJPA.getById(id);
            if (userFromDb == null) return null;
            userRepositoryRedis.save(convertData(userFromDb));

            return userFromDb;

        }
    }
    public User update(Long id,UserJPA user) {
        if (user == null) return null;
        user.setId(id);
        UserJPA newuser=userRepositoryJPA.save(user);

        Optional<UserRedis> userRedis = userRepositoryRedis.findById(id);
        if (userRedis.isPresent()) {
            //userRepositoryRedis.deleteById(id);    //metodo lento
            userRepositoryRedis.save(convertData(newuser)); //metodo fast
        }
        return user;
    }
    public void delete(Long id){
        userRepositoryJPA.deleteById(id);
        userRepositoryRedis.deleteById(id);
    }
    public void readOneFast(Long id) {
    }

}





