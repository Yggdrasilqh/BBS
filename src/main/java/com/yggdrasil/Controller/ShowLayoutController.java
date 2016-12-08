package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Layout;
import com.yggdrasil.Repository.LayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Zelzhao on 2016/12/8.
 */
@RestController
@RequestMapping("/showLayoutController")
public class ShowLayoutController {

    private LayoutRepository layoutRepository;
    @Autowired
    public ShowLayoutController(LayoutRepository layoutRepository) {
        this.layoutRepository = layoutRepository;
    }

    @RequestMapping(value = "/showLayout",method = RequestMethod.GET)
   public List<Layout> showLayout(){
        return layoutRepository.findAll();
    }


}
