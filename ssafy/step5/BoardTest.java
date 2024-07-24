package ssafy.step5;

import java.io.*;
import java.util.List;
import java.util.Scanner;
public class BoardTest {

    static IArticleManager am = ArticleManagerImpl.getInstance();
    static IUserManager um = UserManagerImpl.getInstance();

    public static void main(String[] args) throws IOException {

        am.addArticle(new Article(0, "공지사항", "게시글 내용", 0));
        am.addArticle(new Article(1, "코딩테스트란", "게시글 내용", 1));
        am.addArticle(new Article(2, "취뽀는 나에게", "게시글 내용", 2));
        am.addArticle(new Article(3, "Java 완전정복", "게시글 내용", 3));
        am.addArticle(new Article(4, "Python 완전정복", "게시글 내용", 3));
        am.addArticle(new ImageArticle(5, "Image 잘찍는법 완전정복", "게시글 내용", 3, "image.png", 100, 100));
        am.addArticle(new ImageArticle(6, "클린코드 작성법", "게시글 내용", 3, "cleancode.png", 200, 100));

        am.addComment(new Comment(0, 1, 5, "잘 보았습니다."));
        am.addComment(new Comment(1, 1, 4, "좋은 글 입니다~~"));

        um.signup(new User(0, "ssafy", "1234", "김싸피", "김싸피", "ssafy@ssafy.com"));
        um.signup(new User(1, "hong", "123", "홍싸피", "ssafy.hong", "hong@ssafy.com"));
        um.signup(new User(2, "samsic", "samsic", "김삼식", "삼식이", "kim@ssafy.com"));
        um.signup(new User(3, "happy", "happy", "이싸피", "해피바이러스", "lee@ssafy.com"));
        um.signup(new User(4, "thumb", "thumb", "박싸피", "따봉맨", "park@ssafy.com"));
        um.signup(new User(5, "song", "song", "송싸피", "프린스송", "song@ssafy.com"));

        Scanner sc = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            boardEnter();
            int cmd = sc.nextInt();
            switch (cmd) {
                case 0:
                    System.out.println("접속을 종료합니다.");
                    return;
                case 1:
                    System.out.println("ID 입력 : ");
                    String id = sc.next();
                    System.out.println("PASSWORD 입력 : ");
                    String pw = sc.next();

                    User loginUser = um.login(id, pw);
                    if (loginUser == null) {
                        System.out.println("-------------------------------------");
                        System.out.println("로그인 실패");
                        System.out.println("-------------------------------------");
                    } else {
                        outer: while (true) {
                            System.out.println("-------------------------------------");
                            System.out.println("로그인 성공");
                            System.out.println(um.getLoginUser().getNickName() + "님 환영합니공다.");
                            System.out.println("-------------------------------------");
                            System.out.println("게시글 목록");
                            for (Article a : am.getArticleList()) {
                                System.out.println(a.getArticleId() + " " + a.getTitle());
                            }
                            System.out.println("-------------------------------------");
                            System.out.println("1. 게시글 작성");
                            System.out.println("2. 게시글 선택");
                            System.out.println("3. 로그아웃");
                            System.out.println("0. 종료");
                            System.out.println("-------------------------------------");
                            int cmd2 = sc.nextInt();
                            switch (cmd2) {
                                case 0:
                                    System.out.println("종료합니다.");
                                    return;
                                case 1:
                                    System.out.println("-------------------------------------");
                                    System.out.println("게시글 작성");
                                    System.out.println("-------------------------------------");
                                    System.out.println("제목 입력 :");
                                    String articleTitle =  buffer.readLine();
                                    System.out.println("내용 입력 : ");
                                    String articleContent =  buffer.readLine();
                                    am.addArticle(new Article(am.getArticleList().size(), articleTitle, articleContent,
                                            um.getLoginUser().getUserSeq()));
                                    break;
                                case 2:
                                    System.out.println("게시글 선택 :");
                                    int articleNo = sc.nextInt();
                                    outerComment: while (true) {
                                        articleInfo(articleNo);
                                        System.out.println("-------------------------------------");
                                        System.out.println("1. 게시글 삭제");
                                        System.out.println("2. 댓글 작성");
                                        System.out.println("3. 댓글 삭제");
                                        System.out.println("4. 상위 메뉴");
                                        System.out.println("0. 종료");
                                        System.out.println("-------------------------------------");
                                        int cmd3 = sc.nextInt();
                                        switch (cmd3) {
                                            case 0:
                                                System.out.println("종료합니다.");
                                                return;
                                            case 1:
                                                System.out.println("게시글 삭제");
                                                am.removeArticle(articleNo);
                                                break outerComment;
                                            case 2:
                                                System.out.println("댓글 내용 작성 : ");
                                                String content = buffer.readLine();
                                                List<Comment> dummy= am.getCommentList(articleNo);
                                                am.addComment(new Comment(dummy.size(), articleNo, um.getLoginUser().getUserSeq(),
                                                        content));
                                                break;
                                            case 3:
                                                System.out.println("댓글 번호 입력 : ");
                                                int num2 = sc.nextInt();
                                                am.removeComment(articleNo, num2);
                                                break;
                                            case 4:
                                                break outerComment;
                                            default:
                                                System.out.println("그런 메뉴는 없습니다.");
                                                break;
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("로그아웃합니다.");
                                    um.logout();
                                    break outer;
                                default:
                                    System.out.println("그런 메뉴는 없습니다.");
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("-------------------------------------");
                    System.out.println("회원 가입");
                    System.out.println("-------------------------------------");
                    System.out.println("ID 입력 : ");
                    String userId = sc.next();
                    System.out.println("PW 입력 : ");
                    String userPw = sc.next();
                    System.out.println("이름 입력 : ");
                    String userName = sc.next();
                    System.out.println("별명 입력 : ");
                    String nickName = sc.next();
                    System.out.println("이메일 입력 : ");
                    String email = sc.next();
                    User user = new User(um.getUserSize(), userId, userPw, userName, nickName, email);
                    um.signup(user);
                    break;
                case 3:
                    System.out.println("-------------------------------------");
                    System.out.println("검색 옵션");
                    System.out.println("1. 제목검색");
                    System.out.println("2. 내용검색");
                    System.out.println("3. 작성자 검색");
                    int option = sc.nextInt();
                    System.out.println("내용 입력");
                    String keyword = buffer.readLine();

                    for(Article a : am.search(option, keyword)) {
                        if(a instanceof ImageArticle) {
                            System.out.println("이미지 게시글 : " + a.getTitle());
                        }else {
                            System.out.println("텍스트 게시글 : " + a.getTitle());
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("-------------------------------------");
                    System.out.println("일반 게시글 모아보기");
                    for(Article a : am.getTextArticleList())
                        System.out.println(a.getTitle());
                    break;
                case 5:
                    System.out.println("-------------------------------------");
                    System.out.println("이미지 게시글 모아보기");
                    for(ImageArticle a : am.getImageArticleList())
                        System.out.println(a.getTitle());
                    System.out.println();
                    System.out.println("전체 이미지의 평균 크기 : "+ am.getImageSizeAvg());
                    break;
                default:
                    System.out.println("그러한 메뉴는 없습니다.");
                    break;
            }
        }
    }

    static int randomNumber() {
        return (int) (Math.random() * 10000);
    }

    static void boardEnter() {
        System.out.println("-------------------------------------");
        System.out.println("게시판 접속");
        System.out.println("-------------------------------------");
        System.out.println("작업을 선택하세요.");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 검색");
        System.out.println("4. 일반 게시글 모아보기");
        System.out.println("5. 이미지 게시글 모아보기");
        System.out.println("0. 종료");
        System.out.println("-------------------------------------");
    }

    static void articleInfo(int articleNo) {
        System.out.println("-------------------------------------");
        Article article = am.getArticle(articleNo);
        System.out.println("제목 : " + article.getTitle());
        System.out.println("작성자 : " + um.getUser(article.getUserSeq()).getNickName());
        System.out.println("조회수 : " + article.getViewCnt());
        System.out.println("작성일 : " + article.getRegDate());
        System.out.println("내용 : " + article.getContent());
        System.out.println("-------------------------------------");
        List<Comment> comments = am.getCommentList(articleNo);
        if (comments != null) {
            System.out.println("총 댓글의 수 : " + comments.size());
            for (Comment c : comments) {
                System.out.println(c.getCommentId() + ". " + c.getContent() + " 작성자 : "
                        + um.getUser(c.getUserSeq()).getNickName());
            }
        } else {
            System.out.println("댓글이 없습니다.");
        }
    }
}

