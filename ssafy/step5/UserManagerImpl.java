package ssafy.step5;

import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements IUserManager {

    private static final UserManagerImpl userManagerImpl = new UserManagerImpl();
    private User loginUser;
    List<User> users = new ArrayList<>();
    private UserManagerImpl() {

    }


    @Override
    public void signup(User user) {
        for(int i = 0; i< users.size(); i++) {
            if (users.get(i).getUserId().equals(user.getUserId())) {
                System.out.println("오류 : 아이디가 중복입니다.");
                return;
            }
        }
        users.add(user);
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
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserSeq()==userSeq){
                return users.get(i);
            }
        }
        return null; //질문
    }
    @Override
    public User getUser(String nickName) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getNickName().equals(nickName) ){
                return users.get(i);
            }
        }
        return null;
    }
    @Override
    public User login(String id, String password) {
        for(int i = 0 ; i <users.size(); i++){
            if(users.get(i).getUserId().equals(id)){
                if(users.get(i).getPassword().equals(password)){
                    loginUser = users.get(i);
                    return users.get(i);
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


    @Override
    public int getUserSize() {
        return users.size();
    }
}
