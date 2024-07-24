package ssafy.sstep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

    private List<Movie> movieList= new ArrayList<>();

    static IMovieManager instance = new MovieManagerImpl();

    public MovieManagerImpl() {
    }
    public IMovieManager getInstance(){

        return instance;
    }

    @Override
    public void add(Movie movie) {
        movieList.add(movie);
        System.out.println(movie+ "영화 정보가 등록되었습니다.");
    }

    @Override
    public Movie[] getList() {

        Movie[] movies = movieList.toArray(new Movie[movieList.size()]);
        return movies;
    }

    @Override
    public Movie[] searchByTitle(String title) {
        List<Movie> list = new ArrayList<>();
        for(int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).getTitle().contains(title))
                list.add(movieList.get(i));
        }

        return list.toArray(new Movie[list.size()]);
    }

    @Override
    public Movie[] getMovies() {
        List<Movie> dummy = new ArrayList<>();
        for(int i = 0 ; i< movieList.size(); i ++){
            if(movieList.get(i) instanceof SeriesMovie){}
            else if(movieList.get(i) instanceof Movie){
                dummy.add(movieList.get(i));
            }
        }

        return dummy.toArray(new Movie[dummy.size()]);
    }
    public void remove(int id){
        for(int i = 0 ; i < movieList.size(); i ++){
            if(movieList.get(i).getId() == id) {
                movieList.remove(i);
                System.out.println("id 값 "+ id+ " 영화가 지워졌습니다.");
                return;
            }
        }
        System.out.println("해당 Id의 영화는 없습니다.");
    }
    @Override
    public SeriesMovie[] getSeriesMovies() {
        List<SeriesMovie> dummy = new ArrayList<>();
        int index = 0;
        for(int i = 0 ; i< movieList.size(); i ++){
            if(movieList.get(i) instanceof SeriesMovie)
                dummy.add((SeriesMovie) movieList.get(i));
        }
        return dummy.toArray(new SeriesMovie[dummy.size()]);
    }

    @Override
    public double getRunningTimeAvg() {
        double sum = 0;
        double avg = 0;

        for(int i = 0 ; i <movieList.size(); i++){
            sum += movieList.get(i).getRunningTime();
        }
        avg = sum/movieList.size();

        return avg;
    }
}
