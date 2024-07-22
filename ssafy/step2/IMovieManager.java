package ssafy.step2;

public interface IMovieManager {

    void add(Movie movie);
    Movie[] getList();
    Movie[] searchByTitle(String title);
    Movie[] getMovies();
    SeriesMovie[] getSeriesMovies();
    void remove(int id);
    double getRunningTimeAvg();
    int getSize();
}
