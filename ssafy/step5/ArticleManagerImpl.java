package ssafy.step5;

import java.util.*;
public class ArticleManagerImpl implements IArticleManager {

    private static final ArticleManagerImpl articleManagerImpl = new ArticleManagerImpl();
    private List<Article> articles = new ArrayList<>();
    private Map<Integer,List<Comment>> comments = new HashMap<>();

    private ArticleManagerImpl() {

    }
    public static ArticleManagerImpl getInstance() {

        return articleManagerImpl;
    }

    @Override
    public void addArticle(Article article) {
        List<Comment> dummy = new ArrayList<>();

        articles.add(article);
        comments.put(article.getArticleId(), dummy);

        System.out.println("기사가 등록되되었습니다.");
    }

    @Override
    public void addComment(Comment comment) {
        if(Objects.isNull(comment)) {
            System.out.println("값 틀림 제대로 하자");
            return;
        }

        List<Comment> list = comments.get(comment.getArticleID());
        list.add(comment);

        comments.put(comment.getArticleID(), list);
    }



    @Override
    public Article getArticle(int articleId) {
        for(int i = 0 ; i < articles.size(); i++){
            if(articles.get(i).getArticleId() == articleId){
                articles.get(i).setViewCnt(articles.get(i).getViewCnt()+1);
                return articles.get(i);
            }
        }
        return new Article();
    }
    @Override
    public List<Article> getArticleList() {
        return articles;
    }

    @Override
    public List<Comment> getCommentList(int articleId) {
        for (Article article : articles) {
            if(article.getArticleId() == articleId){
                return comments.get(articleId);
            }
        }
        return null;
    }

    @Override
    public List<ImageArticle> getImageArticleList() {
        List<ImageArticle> result = new ArrayList<>();
        for(int i = 0 ; i < articles.size();i++){
            if(articles.get(i) instanceof ImageArticle){
                result.add((ImageArticle)articles.get(i));
            }
        }
        return result;
    }
    @Override
    public double getImageSizeAvg() {
        List<ImageArticle> list = getImageArticleList();
        double sum = 0;
        for(int i = 0; i < list.size(); i++){
            double height = list.get(i).getHeight();
            double width = list.get(i).getWidth();
            double value = height*width;
            sum+= value;
        }
        return sum;
    }

    @Override
    public List<Article> getTextArticleList() {
        List<Article> result = new ArrayList<>();
        for(int i = 0 ; i < articles.size();i++){
            if(articles.get(i) instanceof ImageArticle){

            }else if(articles.get(i) instanceof Article){
                result.add(articles.get(i));
            }
        }
        return result;
    }
    @Override
    public void removeArticle(int articleId) {
        int index= 0;
        boolean check = false;
        for(int i = 0 ; i< articles.size(); i++){
            if(articles.get(i).getArticleId() == articleId) {
                index = i;
                check=true;
                break;
            }
        }
        if(check){
            articles.remove(index);
            System.out.println(articleId +"번 게시글이 삭제되었습니다.");
        }
        System.out.println("해당 게시글이 없습니다.");

    }
    @Override
    public void removeComment(int articleId, int commentId) {
        for (Article article : articles) {
            if (article.getArticleId() == articleId) {
                List<Comment> dummy = comments.get(articleId);
                if (Objects.nonNull(dummy)) {
                    for (int i = 0; i < dummy.size(); i++) {
                        if (dummy.get(i).getCommentId() == commentId) {
                            dummy.remove(i);
                            comments.put(articleId, dummy);
                            return;
                        }
                    }
                }
            }
        }
    }
    @Override
    public List<Article> search(int option, String keyword) {

        if(option == 1){
            List<Article> dummy = new ArrayList<>();
            ;

            for(int i = 0; i< articles.size(); i++) {
                if (articles.get(i).getTitle().contains(keyword)){
                    dummy.add(articles.get(i));
                }
            }
            if(dummy.size() == 0 ) System.out.println("[없음]");
            return dummy;
        }
        else if(option == 2){
            List<Article> dummy = new ArrayList<>();

            for (Article article : articles) {
                if(article.getContent().contains(keyword)){
                    dummy.add(article);
                }
            }
            return dummy;

        } else if(option == 3) {
            UserManagerImpl userManager = UserManagerImpl.getInstance();
            User user = userManager.getUser(keyword);
            if(user == null){
                System.out.println("[없음]");
                user = new User();
            }
            List<Article> dummy = new ArrayList<>();
            int index = 0;
            for (int i = 0; i < articles.size(); i++) {
                if (user.getUserSeq() == articles.get(i).getUserSeq()) {
                    dummy.add(articles.get(i));
                }
            }
            List<Article> result = new ArrayList<>();
            for (int i = 0; i < dummy.size(); i++) {
                result.add(dummy.get(i));
            }
            return result;
        }

        return null;
    }


    @Override
    public void updateArticle(Article article) {
        for(int i = 0; i <articles.size(); i++) {
            if(articles.get(i).getArticleId() == article.getArticleId()) {
                articles.add(article);
                return;
            }
        }
        System.out.println("오류 : 없데이트가 안됐습니다.");
    }

}

