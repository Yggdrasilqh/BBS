package com.yggdrasil.Controller;

import com.yggdrasil.Entity.UserGroup;
import com.yggdrasil.Repository.UserGroupRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yggdrasil on 16/12/19.
 */
@RestController
public class GroupControl {
    @Resource
    UserGroupRepository userGroupRepository;


    @RequestMapping("/getAllUserGroup")
    public List<UserGroup> getAllUserGroup(){
        return userGroupRepository.findAll();
    }
}
