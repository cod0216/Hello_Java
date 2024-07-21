package ssafy.ws07_5;

public class ArticleManagerImpl implements IArticleManager{

    private static final ArticleManagerImpl articleManagerImpl = new ArticleManagerImpl();
    static final int MAX_ARTICLE_SIZE = 100;
    static final int MAX_COMMENT_SIZE = 100;
    private Article[] articles = new Article[MAX_ARTICLE_SIZE];
    private Comment[] comments = new Comment[MAX_COMMENT_SIZE];
    private int articleSize;
    private int commentSize;


    private ArticleManagerImpl() {

    }
    public static ArticleManagerImpl getInstance() {

        return articleManagerImpl;
    }

    @Override
    public void addArticle(Article article) {
        articles[articleSize++] = article;
        System.out.println("기사가 등록되되었습니다.");
    }

    @Override
    public void addComment(Comment comment) {
        comments[commentSize++]= comment;
        System.out.println("코맨트가 등록되되었습니다.");
    }
    @Override
    public Article getArticle(int articleId) {
        for(int i = 0 ; i < articleSize; i++){
            if(articles[i].getArticleId() == articleId){
                return articles[i];
            }
        }
        return new Article();
    }
    @Override
    public Article[] getArticleList() {
        Article[] dummy = new Article[articleSize];
        int index = 0;

        for(int i = 0; i< articleSize; i++){
                dummy[index++] = articles[i];
        }
        Article[] result = new Article[index];
        for(int i=0; i< index; i++){
            result[i] = dummy[i];
        }
        return result;
    }
    @Override
    public Comment[] getCommentList(int articleId) {
        Comment[] dummy = new Comment[commentSize];
        int index = 0;
        for(int i = 0 ; i < commentSize; i++) {
            if(comments[i] != null && comments[i].getArticleID() == articleId) {
                dummy[index++] = comments[i];
            }
        }
        Comment[] result = new Comment[index];
        for(int i = 0 ; i < index; i++) {
            result[i] = dummy[i];
        }

        return result;
    }

    public int getArticleSize() {
        return articleSize;
    }
    public int getCommentSize(){
        return commentSize;
    }
    @Override
    public ImageArticle[] getImageArticleList() {
        ImageArticle[] dummy = new ImageArticle[articleSize];
        int index = 0;
        for(int i = 0; i < articleSize; i++){
            if(articles[i] instanceof ImageArticle){
                dummy[index++] = (ImageArticle) articles[i];
            }
        }
        if(index == 0) return new ImageArticle[1];
        ImageArticle[] result = new ImageArticle[index];

        for(int i = 0; i < index; i++){
            result[i] = dummy[i];
        }

        return result;
    }
    @Override
    public double getImageSizeAvg() {
        ImageArticle[] dummy= getImageArticleList();
        double sum = 0;

        for(int i = 0; i < dummy.length; i++){
            double height = dummy[i].getHeight();
            double width = dummy[i].getWidth();
            double value = height*width;
            sum+= value;
        }
        return sum;
    }
    @Override
    public Article[] getTextArticleList() {
        Article[] dummy = new Article[articleSize];
        int index = 0;
        for(int i = 0; i < articleSize; i++){
            if(articles[i] instanceof ImageArticle){

            }else if( articles[i] instanceof Article){
                dummy[index++] = articles[i];
            }
        }
        if(index == 0) return new Article[1];
        Article[] result = new Article[index];

        for(int i = 0; i < index; i++){
            result[i] = dummy[i];
        }

        return result;
    }
    @Override
    public void removeArticle(int articleId) {
        int index= 0;
        boolean check = false;
        for(int i = 0; i < articleSize; i++) {
            if(articleId == articles[i].getArticleId()) {
                articles[i] = null;
                check =true;
                index = i;
            }
        }
        if(check){
            for(int i = index; i <articleSize-1; i++){
                articles[i]= articles[i+1];
            }
            articleSize--;
        }
    }
    @Override
    public void removeComment(int commentId) {
        int index= 0;
        boolean check = false;
        for(int i = 0; i < commentSize; i++) {
            if(comments[i] != null && comments[i].getCommentId() == commentId) {
                comments[i] = null;
                check = true;
                index = i;
            }
        }
        if(check){
            for(int i = index; i <commentSize-1; i++){
                comments[i] = comments[i+1];
            }
            commentSize--;
        }

    }
    @Override
    public Article[] search(int option, String keyword) {

        if(option == 1){
            Article[] dummy = new Article[articleSize];
            int index = 0;

            for(int i = 0; i< articleSize; i++) {
                dummy[i] = new Article();
                if (articles[i].getTitle().contains(keyword)) dummy[index++] = articles[i];
            }
            if(index == 0 ) System.out.println("[없음]");
            Article[] result = new Article[index];
            for(int i=0; i< index; i++){
                result[i] = dummy[i];
            }
            if(result == null) return new Article[1];
            return result;
            }
        else if(option == 2){
            Comment[] dummy = new Comment[commentSize];
            int index = 0;

            for(int i = 0; i< commentSize; i++) {
                dummy[i] = new Comment();
                if (comments[i].getContent().contains(keyword))
                    dummy[index++] = comments[i];
            }
            if(index == 0 ) System.out.println("[없음]");

            Article[] value = new Article[index+1];
            int n = 0;
            for(int i=0; i< articleSize; i++){
                if(dummy[n].getArticleID() == articles[i].getArticleId()) {
                    value[n] = articles[i];
                    n++;
                }
            }
            Article[] result = new Article[n];
            for(int i = 0; i< n; i++){
                result[i] = value[i];
            }

            return result;
        }else if(option == 3) {
            UserManagerImpl userManager = UserManagerImpl.getInstance();
            User user = userManager.getUser(keyword);
            if(user == null){
                System.out.println("[없음]");
                user = new User();
            }
            Article[] dummy = new Article[articleSize];
            int index = 0;
            for (int i = 0; i < articleSize; i++) {
                if (user.getUserSeq() == articles[i].getUserSeq()) {
                    dummy[index++] = articles[i];
                }

            }
            Article[] result = new Article[index];
            for (int i = 0; i < index; i++) {
                result[i] = dummy[i];
            }
            return result;
        }
        return new Article[1];
    }


    @Override
    public void updateArticle(Article article) {
        for(int i = 0; i <articleSize; i++) {
            if(articles[i].getArticleId() == article.getArticleId()) {
                articles[i] =  article;
                return;
            }
        }
        System.out.println("오류 : 없데이트가 안됐습니다.");
    }

    public int getLastArticleIndex(){
        return articles[articleSize-1].getArticleId();
    }

}

