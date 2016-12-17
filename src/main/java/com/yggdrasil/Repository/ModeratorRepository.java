package com.yggdrasil.Repository;

import com.yggdrasil.Entity.Moderator;
import com.yggdrasil.Entity.ModeratorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Yggdrasil on 16/12/14.
 */
public interface ModeratorRepository extends JpaRepository<Moderator,ModeratorPK> {
    @Query(value = "select * from moderator where user_id = :user_id and layout_id = :layout_id",nativeQuery = true)
    public List<Moderator> findByUser_idAndLayout_id(String user_id,int layout_id);
}
