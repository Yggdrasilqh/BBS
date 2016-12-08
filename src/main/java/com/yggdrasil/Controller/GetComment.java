package com.yggdrasil.Controller;

import com.yggdrasil.Entity.post;
import com.yggdrasil.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chenq on 2016/12/8,008.
 */
@RestController
@RequestMapping("/getContent")
public class GetComment {

    private PostRepository postRepository;

    @Autowired
    public GetComment(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/getAllContentByLayoutId",method = RequestMethod.GET)
    public List<post> getAllContentByPostId(int LayoutId){
        return postRepository.findBylayout_id(LayoutId);
    }

}
