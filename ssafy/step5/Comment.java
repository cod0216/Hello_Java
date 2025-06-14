package ssafy.step5;

import java.sql.Date;

public class Comment {
    private int commentId;
    private int articleID;
    private int userSeq;
    private String content;
    private Date regDate;


    public Comment() {}

    public Comment(int commentId, int articleID, int userSeq, String content) {
        this.commentId = commentId;
        this.articleID = articleID;
        this.userSeq = userSeq;
        this.content = content;
    }
    public int getCommentId() {
        return commentId;
    }
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
    public int getArticleID() {
        return articleID;
    }
    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }
    public int getUserSeq() {
        return userSeq;
    }
    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }


    @Override
    public String toString() {
        return "Comment [commentId=" + commentId + ", articleID=" + articleID + ", userSeq=" + userSeq + ", content="
                + content + ", regDate=" + regDate + "]";
    }




}
