package ssafy.step2;

public class MovieManagerImpl implements IMovieManager{
    static int MAX_SIZE = 100;
    private Movie[] movieList = new Movie[MAX_SIZE];
    private int size;
    static IMovieManager instance = new MovieManagerImpl();

    public MovieManagerImpl() {
    }
    public IMovieManager getInstance(){

        return instance;
    }

    @Override
    public void add(Movie movie) {
        movieList[size++] = movie;
        System.out.println(movie+ "영화 정보가 등록되었습니다.");
    }

    @Override
    public Movie[] getList() {
        return movieList;
    }

    @Override
    public Movie[] searchByTitle(String title) {
        Movie[] dummy = new Movie[size];
        int index=0;
        for (int i = 0; i < size; i++) {
            if(movieList[i].getTitle().equals(title))
                dummy[index++] = movieList[i];
        }
        Movie[] result = new Movie[index];
        for(int i = 0 ; i < index; i ++){
            result[i] = dummy[i];
        }
        return result;
    }

    @Override
    public Movie[] getMovies() {
        Movie[] dummy = new Movie[size];
        int index = 0;
        for(int i = 0 ; i< size; i ++){
            if(movieList[i] instanceof SeriesMovie)continue;
            else if(movieList[i] instanceof Movie){
                dummy[index++] = movieList[i];
            }
        }

        Movie[] result = new Movie[index];
        for(int i = 0 ; i < index; i++){
            result[i] = dummy[i];
        }
        return result;
    }
    public int getSize(){
        return size;
    }
    public void remove(int id){
        int index = 0;
        boolean check = false;
        for(int i = 0 ; i < size; i ++){
            if(movieList[i].getId() == id) {
                movieList[i] = null;
                index = i;
                check=true;

                System.out.println("id 값 "+ id+ " 영화가 지워졌습니다.");
            }
        }
        if(check) {
            for (int i = index; i < size - 1; i++) {
                movieList[i] = movieList[i + 1];

            }
            size--;
        }else System.out.println("해당 Id의 영화는 없습니다.");
    }
    @Override
    public SeriesMovie[] getSeriesMovies() {
        SeriesMovie[] dummy = new SeriesMovie[size];
        int index = 0;
        for(int i = 0 ; i< size; i ++){
            if(movieList[i] instanceof SeriesMovie)
                dummy[index++] = (SeriesMovie) movieList[i];
        }
        SeriesMovie[] result = new SeriesMovie[index];
        for(int i = 0 ; i < index; i++){
            result[i] = dummy[i];
        }
        return result;
    }

    @Override
    public double getRunningTimeAvg() {
        double sum = 0;
        double avg = 0;
        for(int i = 0 ; i < size; i++){
            sum += movieList[i].getRunningTime();
        }
        avg = sum/size;

        return avg;
    }
}
