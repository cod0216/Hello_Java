package ssafy.step4;

import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

    private List<Movie> list = new ArrayList<>();
    //final을 사용 사용해 인스턴스 값을 변경할 수 없게 하고 static을 이용해 다른 클래스에서 사용 가능하게 한다.
    static final IMovieManager instance = new MovieManagerImpl();

//    private로 생성자를 외부 에서 호출 하는것을 막는다.
    private MovieManagerImpl() {
    }

    //static public을 이용해 외부에서 클래스명.메서드 명 을 이용해서 생성된 인스턴스를 호출시킨다.
    static public IMovieManager getInstance(){

        return instance;
    }

    /*
    입력된 영화 인스턴스를 영화 리스트에 추가한다.
     */
    @Override
    public void add(Movie movie) {
        list.add(movie);
        System.out.println(movie+ "영화 정보가 등록되었습니다.");
    }

    /*
    영화 리스트를 무비 타입 배열로 반환한다.
     */
    @Override
    public Movie[] getList() {
        return list.toArray(new Movie[list.size()]);
    }

    /*
    영화 리스트의 무비 타입만 걸러서 무비 타입 배열로 반환한다.
     */
    @Override
    public Movie[] getMovies() {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i< list.size(); i++){
            if(list.get(i) instanceof SeriesMovie)continue;
            else if(list.get(i) instanceof Movie){
                movies.add(list.get(i));
            }
        }

        return movies.toArray(new Movie[movies.size()]);
    }

    /*
    제목을 파라미터로 받아 영화 리스트에 있는 타이틀에 포함된다면 포함된 영화를 무비즈 리스트에 담아서 반환한다.
    단, 무비즈 리스트 크기가 0인 경우 타이틀낫파운드예외를 발생시킨다.
     */
    @Override
    public Movie[] searchByTitle(String title) throws TitleNotFoundException{
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTitle().contains(title)){
                movies.add(list.get(i));
            }
        }
        if(movies.size() >0) return movies.toArray(new Movie[movies.size()]);
        else throw new TitleNotFoundException(title);
    }

    /*
    id 값과 영화 리스트에 있는 영화 id값이 같으면 영화를 지운다.
     */
    public void remove(int id){
        boolean check = false;
        for(int i = 0 ; i < list.size(); i ++){
            if(list.get(i).getId() == id) {
                list.remove(i);
                System.out.println("id 값 "+ id+ " 영화가 지워졌습니다.");
                check = true;
            }
        }
        if(!check) {
            System.out.println("해당 영화는 없습니다.");
        }
    }

    /*
    영화 리스트 타입 중 시리즈 무비 타입을 골라서 시리즈 무비 타입 배열로 반환한다.
     */
    @Override
    public SeriesMovie[] getSeriesMovies() {
        List<SeriesMovie> movies = new ArrayList<>();
        for(int i = 0; i< list.size(); i++){
            if(list.get(i) instanceof SeriesMovie)
                movies.add((SeriesMovie) list.get(i));
        }

        return movies.toArray(new SeriesMovie[movies.size()]);
    }


    /*
    무비 클래스의 러닝 타임을 다 더한 후 리스트 크기로 나눠 평균 상영 시간을 구한다.
    */
    @Override
    public double getRunningTimeAvg() {
        double sum = 0;

        for(int i = 0 ; i < list.size(); i++){
            sum += list.get(i).getRunningTime();
        }

        double avg;
        avg = sum/list.size();

        return avg;
    }
}
