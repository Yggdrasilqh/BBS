package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Comment;
import com.yggdrasil.Entity.User;
import com.yggdrasil.Repository.CommentRepository;
import com.yggdrasil.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenq on 2016/12/8,008.
 */
@RestController
@RequestMapping("/login/comment")
public class CommentControl {
    @Resource
    private CommentRepository commentRepository;
    @Resource
    private UserRepository userRepository;
    @RequestMapping(value = "/getAllByPostId",method = RequestMethod.GET)
    public List<Comment> getAllByPostId(int post_id){
        return commentRepository.findByPostId(post_id);
    }

    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    public String inertComment(Comment comment){
        commentRepository.save(comment);
        return "success";
    }
    @RequestMapping(value = "/deleteComment",method = RequestMethod.POST)
    public String deleteComment(int id){
        commentRepository.delete(id);
        return "success";
    }
    @RequestMapping(value = "getCommentUser",method = RequestMethod.GET)
    public User getCommentUser(String id){
        return userRepository.findById(id);
    }

}
