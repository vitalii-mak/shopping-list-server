package com.github.vitaliimak.shoppinglist.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.github.vitaliimak.shoppinglist.model.User;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void shouldFindAllUsers() {
        User user1 = User.builder()
            .email("user1@localhost.com")
            .firstName("Jhon")
            .lastName("Dou")
            .password("qwerty123")
            .build();
        user1.setCreatedBy(1L);
        user1.setLastModifiedBy(1L);
        user1.setCreatedDate(Instant.now());
        user1.setLastModifiedDate(Instant.now());

        User user2 = User.builder()
            .email("user2@localhost.com")
            .firstName("Jhon")
            .lastName("Dou")
            .password("qwerty123")
            .build();
        user2.setCreatedBy(1L);
        user2.setLastModifiedBy(1L);
        user2.setCreatedDate(Instant.now());
        user2.setLastModifiedDate(Instant.now());

        userRepository.save(user1);
        userRepository.save(user2);

        List<User> userList = userRepository.findAll();
        assertEquals(2, userList.size());
    }

    @Test
    void shouldFindUserById() {
        User user = User.builder()
            .email("user1@localhost.com")
            .firstName("Jhon")
            .lastName("Dou")
            .password("qwerty123")
            .build();
        user.setCreatedBy(1L);
        user.setLastModifiedBy(1L);
        user.setCreatedDate(Instant.now());
        user.setLastModifiedDate(Instant.now());

        userRepository.save(user);

        User userFromRepository = userRepository.getOne(user.getId());
        assertSame(user, userFromRepository);
    }
}
