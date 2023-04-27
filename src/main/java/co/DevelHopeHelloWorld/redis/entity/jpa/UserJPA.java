package co.DevelHopeHelloWorld.redis.entity.jpa;

import co.DevelHopeHelloWorld.redis.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJPA extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;



}
