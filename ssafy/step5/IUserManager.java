package ssafy.step5;

public interface IUserManager {

    public User getLoginUser();
    public void signup(User user);
    public User login(String id, String password);
    public void logout();
    public User getUser(int userSeq);
    public User getUser(String nickName);
    int getUserSize();
}
