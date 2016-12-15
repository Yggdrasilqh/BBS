package com.yggdrasil.Repository;

import com.yggdrasil.Entity.Moderator;
import com.yggdrasil.Entity.ModeratorPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yggdrasil on 16/12/14.
 */
public interface ModeratorRepository extends JpaRepository<Moderator,ModeratorPK> {
}
