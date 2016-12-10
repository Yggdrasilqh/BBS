package com.yggdrasil.Repository;

import com.yggdrasil.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenq on 2016/12/8,008.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    @Query(value = "select * from post where layout_id = :layout_id",nativeQuery = true )
    public List<Post> findBylayout_id(@Param("layout_id") int layout_id);

    @Query(value = "select * from Post where id = :id",nativeQuery = true)
    public List<Post> findByid(@Param("id") int id);



}
