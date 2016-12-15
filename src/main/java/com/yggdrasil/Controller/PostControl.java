package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Post;
import com.yggdrasil.Repository.PostRepository;
import com.yggdrasil.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 帖子
 */
@RestController
@RequestMapping("/login/post")
public class PostControl {

    @Resource
    private PostRepository postRepository;


    @RequestMapping(value = "/getByLayoutId",method = RequestMethod.GET)
    public List<Post> getAllContentByPostId(int layout_id){
        return postRepository.findBylayout_id(layout_id);
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public List<Post> getById(int id){
        return postRepository.findByid(id);
    }

    @RequestMapping(value = "/modify/deleteById",method = RequestMethod.GET)
    public String deleteById(int id){
       // postRepository.delete(id);
        System.out.println("删除成功");
        return "success";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String inertComment(Post post){
        postRepository.save(post);
        return "success";
    }

    @RequestMapping(value = "/updateById",method = RequestMethod.POST)
    public String updatePostById(Post post){
        postRepository.save(post);
        return "success";
    }

}
