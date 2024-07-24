package ssafy.step5;

import java.util.*;
public interface IArticleManager {
    //게시글 관련메소드
    public List<Article> getArticleList();
    public Article getArticle(int articleId);
    public void addArticle(Article article);
    public void removeArticle(int articleId);
    public void updateArticle(Article article);
    public List<Article> getTextArticleList();
    public List<ImageArticle> getImageArticleList();
    public double getImageSizeAvg();
    public List<Article> search(int option, String keyword);

    //댓글 관련 메소드
    public void addComment(Comment comment);
    public List<Comment> getCommentList(int articleId);
    void removeComment(int articleId, int commentId);

}
