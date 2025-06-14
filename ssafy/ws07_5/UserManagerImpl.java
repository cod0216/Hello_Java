package ssafy.ws07_5;

public class UserManagerImpl implements IUserManager{

    private static final UserManagerImpl userManagerImpl = new UserManagerImpl();

    private final static int MAX_USER_SIZE =100;

    private User loginUser;
    User[] users = new User[MAX_USER_SIZE];
    private int userSize;

    private UserManagerImpl() {

    }


    @Override
    public void signup(User user) {
        for(int i = 0; i< userSize; i++) {
            if (users[i].getUserId().equals(user.getUserId())) {
                System.out.println("오류 : 아이디가 중복입니다.");
                return;
            }
        }
        users[userSize++] = user;
        System.out.println("회원 등록 성공");
    }
    public static UserManagerImpl getInstance() {
        return userManagerImpl;
    }

    @Override
    public User getLoginUser() {

        return loginUser;
    }
    @Override
    public User getUser(int userSeq) {
        for(int i = 0; i < userSize; i++){
            if(users[i].getUserSeq()==userSeq){
                return users[i];
            }
        }
        return null;
    }
    @Override
    public User getUser(String nickName) {
        for(int i = 0; i < userSize; i++){
            if(users[i].getNickName().equals(nickName) ){
                return users[i];
            }
        }
        return null;
    }
    @Override
    public User login(String id, String password) {
        for(int i = 0 ; i < userSize; i++){
            if(users[i].getUserId().equals(id)){
                if(users[i].getPassword().equals(password)){
                    loginUser = users[i];
                    return users[i];
                }else {
                    System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
                    return null;
                }
            }
        }
        System.out.println("등록된 회원이 없습니다.");
        return null;
    }
    @Override
    public void logout() {
        loginUser = null;
        System.out.println("로그아웃 되었습니다.");
    }

    public int getUserSize() {
        return userSize;
    }
}
