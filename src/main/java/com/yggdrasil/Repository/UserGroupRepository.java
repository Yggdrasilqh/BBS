package com.yggdrasil.Repository;

import com.yggdrasil.Entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yggdrasil on 16/12/14.
 */
public interface UserGroupRepository extends JpaRepository<UserGroup,Integer> {

}
