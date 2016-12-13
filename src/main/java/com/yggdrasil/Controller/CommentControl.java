package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Comment;
import com.yggdrasil.Entity.User;
import com.yggdrasil.Repository.CommentRepository;
import com.yggdrasil.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 评论
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

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String inertComment(HttpServletRequest httpServletRequest,int post_id,String content){
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        Comment comment = new Comment();
        comment.setCreate_user_id(user.getId());
        comment.setContent(content);
        comment.setPost_id(post_id);
        System.out.println(content);


        commentRepository.save(comment);
        return "success";
    }
    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public String deleteComment(int id){
        commentRepository.delete(id);
        return "success";
    }
    @RequestMapping(value = "/getCommentUser",method = RequestMethod.GET)
    public User getCommentUser(String id){
        return userRepository.findById(id);
    }
}
