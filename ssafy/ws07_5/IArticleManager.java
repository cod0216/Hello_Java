package ssafy.ws07_5;

public interface IArticleManager {
    //게시글 관련메소드
    public Article[] getArticleList();
    public Article getArticle(int articleId);
    public void addArticle(Article article);
    public void removeArticle(int articleId);
    public void updateArticle(Article article);
    public Article[] getTextArticleList();
    public ImageArticle[] getImageArticleList();
    public double getImageSizeAvg();
    public Article[] search(int option, String keyword);

    //댓글 관련 메소드
    public void addComment(Comment comment);
    public void removeComment(int commentId);
    public Comment[] getCommentList(int articleId);

    int getArticleSize();
    int getCommentSize();

    int getLastArticleIndex();
}
