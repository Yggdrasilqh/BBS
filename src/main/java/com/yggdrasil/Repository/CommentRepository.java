package com.yggdrasil.Repository;

import com.yggdrasil.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenq on 2016/12/8,008.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{
    @Query(value = "select * FROM comment WHERE post_id = :post_id",nativeQuery = true)
    public List<Comment> findByPostId(@Param("post_id") int post_id);


}
