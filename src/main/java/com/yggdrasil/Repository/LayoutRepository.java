package com.yggdrasil.Repository;


import com.yggdrasil.Entity.Layout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Zelzhao on 2016/12/8.
 */

@Repository
public interface LayoutRepository extends JpaRepository<Layout,Integer>{


}
