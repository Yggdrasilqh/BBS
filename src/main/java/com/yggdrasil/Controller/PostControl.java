package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Post;
import com.yggdrasil.Repository.PostRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenq on 2016/12/8,008.
 */
@RestController
@RequestMapping("/login/post")
public class PostControl {

    @Resource
    private PostRepository postRepository;


    @RequestMapping(value = "/getAllByLayoutId",method = RequestMethod.GET)
    public List<Post> getAllContentByPostId(int LayoutId){
        return postRepository.findBylayout_id(LayoutId);
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public List<Post> getById(int id){
        return postRepository.findByid(id);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    public String deleteById(int id){
        postRepository.delete(id);
        return "success";
    }

    @RequestMapping(value = "/insertPost",method = RequestMethod.POST)
    public String inertComment(Post post){
        postRepository.save(post);
        return "success";
    }

    @RequestMapping(value = "/updatePostById",method = RequestMethod.POST)
    public String updatePostById(Post post){
        postRepository.delete(post.getId());
        postRepository.save(post);
        return "success";
    }

}
