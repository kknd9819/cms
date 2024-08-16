package com.zz.cms.controller;

import com.zz.cms.service.ArticleService;
import com.zz.cms.vo.ArticleNoContentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    @ResponseBody
    public List<ArticleNoContentVO> list() {
        return articleService.getAllNoContent();
    }

    @ResponseBody
    @GetMapping("/increment-read-count")
    public Integer incrementReadCount(@RequestParam("id") Integer id) {
        return articleService.incrementReadCount(id);
    }
}
