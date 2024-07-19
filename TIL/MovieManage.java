package TIL;
/**  </pre>
 *	영화 관리를 위한 서비스 클래스
 * 	</pre>
 *  @author 최은창
 *  @version ver.1.0
 *  @since jdk17
 *  @see java.lang.Object#toString()
 */

public class MovieManage {
    static final int MAX_SIZE = 100;
    private Movie[] movieList = new Movie[MAX_SIZE];
    private int size;

    /**
     * 영화 등록수 조회
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     *  영화 등록 기능
     * @param movie 등록 영화 객체
     */
    public void add(Movie movie) {
        int value =movie.getId();
        boolean check = false;
        for(int i = 0; i < size; i++) {
            if(value ==movieList[i].getId()) {
                check = true;
                break;
            }
        }
        if(check) System.out.println("ID가 중복입니다");
        else movieList[size++] = movie;
        //size++;
    }

    /**
     * 전체 등록 영화 목록 조회
     * @return
     */

    public int isExist(int id){
//        int index =
        for(int i = 0; i < size; i++){
            if(movieList[i].getId() == id)
                return i;
        }
        return -1;
    }
    public void read(int id){
        int index = isExist(id);
        if(index >=0) {
            System.out.println(movieList[index]);
            return;
        }
        System.out.println("[오류] 영화 정보 존재하지 않습니다.");

    }
    public void remove(int id) {
        int index = isExist(id);
        if(index >=0) {
            movieList[index] = movieList[--size];
            return;
        }
        System.out.println("[오류] 영화 정보 존재하지 않습니다.");
    }

    public void update(int id, String title, String genre, String director, int runningTime) {
        int index = isExist(id);
        if(index >= 0){
            movieList[index].setTitle(title);
            movieList[index].setGenre(genre);
            movieList[index].setDirector(director);
            movieList[index].setRunningTime(runningTime);
            System.out.println("영화 정보가 업데이트 되었습니다.");
        }
        System.out.println("[오류] 영화 정보 존재하지 않습니다.");
    }
    public void create(int id, String title, String genre, String director, int runningTime){
        movieList[size].setId(id);
        movieList[size].setTitle(title);
        movieList[size].setGenre(genre);
        movieList[size].setDirector(director);
        movieList[size++].setRunningTime(runningTime);
        System.out.println("영화 정보가 생성 되었습니다.");
    }


    public Movie[] getList() {
        Movie[] result = new Movie[size];
        for(int i = 0; i <size; i++){
            result[i] = movieList[i];
        }

        return result;
    }
    /**
     * 영화 제목 검색
     * @param title 영화 제목
     * @return 존재하면 해당 영화 객체, 미존재시 null
     */

    public Movie searchTitle(String title) {
        for(int i =0; i < size; i++) {
            String name= movieList[i].getTitle();
            if(name.equals(title)) {
                return movieList[i];
            }
        }
        return null;
    }

    /**
     * 영화 제목 부분 매칭 검색
     * @param title
     * @return 존재하면 해당 영화객체들, 미존재시 null
     */
    public Movie[] searchTitleLike(String title) {
        Movie[] findMovies = new Movie[size];
        int index=0;
        for(int i = 0; i< size; i++){
            if(movieList[i].getTitle().contains(title)){
                findMovies[index++] = movieList[i];
            }
        }
        Movie[] result = new Movie[index];
        for(int i =0; i<index; i++){
            result[i] = findMovies[i];
        }
        return result;
    }
}