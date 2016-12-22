package com.yggdrasil.Repository;

import com.yggdrasil.Entity.Layout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Yggdrasil on 2016/12/8.
 */

@Repository
public interface LayoutRepository extends JpaRepository<Layout,Integer>{
}
