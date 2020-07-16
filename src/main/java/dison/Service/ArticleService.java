package dison.Service;

import dison.mapper.ArticleMapper;
import dison.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    //mapper需要加上@Mapper注解，自动生成的是没有的，MyBatis才能将Mapper注册到容器中
    @Autowired
    private ArticleMapper articleMapper;

    //处理数据库Mapper操作，查询所有文章操作

    public List<Article> queryArticles() {
        return articleMapper.selectAll();
    }

    public Article queryArticle(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> queryArticlesByUserId(Long id) {
        return articleMapper.queryArticlesByUserId(id);
    }

    public int insert(Article article) {
        return articleMapper.insert(article);
    }

    public int updateByCondition(Article article) {
        return articleMapper.updateByCondition(article);
    }
}
