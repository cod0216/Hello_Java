package ssafy;

public class MovieTest {
    public static void main(String[] args) {

        MovieManager manager = new MovieManager();
        Movie movie1 = new Movie(1, "A1","김하하","공포", 120);
        Movie movie2 = new Movie(2, "A2","김풍하","스릴러", 140);

        SeriesMovie movie3 = new SeriesMovie(3, "A3","김필하","유머", 143,10, "10편");
        SeriesMovie movie4 = new SeriesMovie(4, "A4","김충하","액션", 111, 10, "10편");

        manager.add(movie1);
        manager.add(movie2);

        manager.add(movie3);
        manager.add(movie4);

        Movie[] movies = manager.getList();
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.println();
        System.out.println("영화 편균 상영 시간은" + manager.getRunningTimeAvg() + "입니다.");
        System.out.println();

        Movie[] findMovies = manager.searchByTitle("A");
        System.out.println("=========찾은 영화========");
        for (Movie findMovie : findMovies) {
            System.out.println(findMovie);
        }
        System.out.println("=======================");

        SeriesMovie[] findSeriesMovie = manager.seriesMovies();
        System.out.println();
        
        System.out.println("=========시리즈========");
        for (SeriesMovie seriesMovie : findSeriesMovie) {
            System.out.println(seriesMovie);
        }
        System.out.println("=======================");
        System.out.println();

        Movie[] movie = manager.getMovies();
        System.out.println("==========영화===========");
        for (Movie movie5 : movie) {
            System.out.println(movie5);
        }
        System.out.println("=======================");
    }
}
