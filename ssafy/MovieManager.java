package ssafy;

public class MovieManager {
    static int MAX_SIZE = 100;
    Movie[] movieList = new Movie[MAX_SIZE];
    int size;

    public void add(Movie movie){
        movieList[size++] = movie;
        System.out.println("영화 " + movie + "정보가 등록되었습니다.");
    }

    public Movie[] getList(){
        Movie[] list = new Movie[size];
        for(int i = 0 ; i< size; i++){
            list[i] = movieList[i];
        }

        return list;
    }

    public Movie[] getMovies(){
        Movie[] dummy = new Movie[size];
        int index=0;
        for(int i = 0 ; i < size; i++){
            if(movieList[i] instanceof SeriesMovie){

            } else if(movieList[i] instanceof Movie){
                dummy[index++] = movieList[i];
            }
        }
        Movie[] result = new Movie[index];
        for(int i = 0; i <index; i++) {
            result[i] = dummy[i];
        }

        return result;
    }
    public SeriesMovie[] seriesMovies(){
        SeriesMovie[] dummy = new SeriesMovie[size];
        int index=0;
        for(int i = 0 ; i < size; i++){
            if(movieList[i] instanceof SeriesMovie){
                dummy[index++] = (SeriesMovie) movieList[i];
            }
        }
        SeriesMovie[] result = new SeriesMovie[index];
        for(int i = 0; i <index; i++) {
            result[i] = dummy[i];
        }

        return result;
    }
    public Movie[] searchByTitle(String title){
        Movie[] movies = new Movie[size];
        int index=0;

        for(int i =0; i <size; i++){
            if(movieList[i].getTitle().contains(title)){
                movies[index++]=movieList[i];
            }
        }
        Movie[] result = new Movie[index];
        for(int i = 0; i <index; i++) {
            result[i] = movies[i];
        }
        return result;
    }

    public double getRunningTimeAvg(){
        double sum =0;
        for(int i = 0; i< size; i++){
            sum += movieList[i].getRunningTime();
        }

        sum/=size;
        return sum;
    }

}
