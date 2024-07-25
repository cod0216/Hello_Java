package ssafy.step4;

public interface IMovieManager {

    void add(Movie movie);
    Movie[] getList();
    Movie[] searchByTitle(String title) throws TitleNotFoundException;
    Movie[] getMovies();
    SeriesMovie[] getSeriesMovies();
    void remove(int id);
    double getRunningTimeAvg();

}
