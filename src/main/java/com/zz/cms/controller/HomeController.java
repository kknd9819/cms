package com.zz.cms.controller;

import com.zz.cms.service.ArticleService;
import com.zz.cms.util.CmsConstant;
import com.zz.cms.vo.ArticleNoContentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ArticleService articleService;

    @ResponseBody
    @GetMapping(value = "/sitemap.xml", produces = "application/xml")
    public String siteMap() {
        List<ArticleNoContentVO> list = articleService.getAllNoContent();
        StringBuilder xml = new StringBuilder("""
                <?xml version="1.0" encoding="UTF-8"?>
                <urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
                <url>
                    <loc>https://czjava.com/</loc>
                    <lastmod>2024-05-25</lastmod>
                    <changefreq>always</changefreq>
                    <priority>1.0</priority>
                </url>
                <url>
                    <loc>https://czjava.com/contact</loc>
                    <lastmod>2024-05-25</lastmod>
                    <changefreq>never</changefreq>
                    <priority>0.9</priority>
                </url>
                """);
        for (ArticleNoContentVO article : list) {
            String url =
                    """
                    <url>
                        <loc>https://czjava.com/artcile/%s</loc>
                        <lastmod>%s</lastmod>
                        <changefreq>always</changefreq>
                        <priority>0.5</priority>
                    </url>
                    """;
            xml.append(String.format(url, article.getId(), article.getCreateTime().format(CmsConstant.yyyyMMdd)));
        }
        xml.append("</urlset>");
        return xml.toString();
    }
}
