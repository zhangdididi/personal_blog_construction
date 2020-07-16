package dison.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Article {
    private Long id;

    private Long userId;

    private String coverImage;

    private Integer categoryId;

    private Byte status;

    private String title;

    private String content;

    private Long viewCount;

    private Date createdAt;

    private Date updatedAt;

    /**
     * 页面需要使用的属性，自行添加
     */

    /**
     * 文章作者
     */
    private User author;

    /**
     * 文章评论数
     */
    private Integer commentCount;

    /**
     * 文章列表
     */
    private List<Comment> commentList;
}