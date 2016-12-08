package com.yggdrasil.Repository;

import com.yggdrasil.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yggdrasil on 16/12/8.
 */
public interface UserRepository extends JpaRepository<User,String>{
    public User findByIdAndPassword(String id, String password);
}
