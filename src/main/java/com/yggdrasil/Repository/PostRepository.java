package com.yggdrasil.Repository;

import com.yggdrasil.Entity.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenq on 2016/12/8,008.
 */
@Repository
public interface PostRepository extends JpaRepository<post,Integer> {
    @Query(value = "select * from post where layout_id = :layout_id",nativeQuery = true )
    public List<post> findBylayout_id(@Param("layout_id") int layout_id);

//    @Query(value = "select * from post where id = :id",nativeQuery = true)
//    public List<Comment> findByid(@Param("id") int id);


}
