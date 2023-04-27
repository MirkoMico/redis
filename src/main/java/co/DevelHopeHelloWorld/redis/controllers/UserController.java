package co.DevelHopeHelloWorld.redis.controllers;

import co.DevelHopeHelloWorld.redis.entity.User;
import co.DevelHopeHelloWorld.redis.entity.jpa.UserJPA;
import co.DevelHopeHelloWorld.redis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
     @Autowired
     private UserService userService;

    @PostMapping
    public UserJPA create(@RequestBody UserJPA user){
        return userService.create(user);

    }
    @GetMapping
    public List<? extends User> readAll(){
      return userService.readAll();

    }
    @GetMapping("/{id}")
    public void readOne(@PathVariable Long id){
        userService.readOne(id);

    }
    //@GetMapping("/fast/{id}")
    //public void readOneFast(@PathVariable String id,@RequestBody UserJPA user){
      //  userService.readOneFast(id);

    //}
    @PutMapping
    public UserJPA update(@PathVariable Long id,@RequestBody UserJPA user){
        return (UserJPA) userService.update(id, user);

    }
    @DeleteMapping
    public void delete(@PathVariable Long id){
        userService.delete(id);


    }
}
