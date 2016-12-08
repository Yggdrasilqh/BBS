package com.yggdrasil.Repository;

import com.yggdrasil.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chenq on 2016/12/8,008.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{
}
