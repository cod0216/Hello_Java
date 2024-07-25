package ssafy.step4;

public class MovieTest {

    public static void main(String[] args) {
        IMovieManager manager = MovieManagerImpl.instance;
        int sessionCount = 0;
        printSeparator();
        manager.add(new Movie(++sessionCount,"이터널스", "클로이 자오","액션",155 ));
        manager.add(new Movie(++sessionCount,"베놈 2", "앤디 서키스","액션",97 ));
        manager.add(new Movie(++sessionCount,"기생충", "봉준호","드라마",131 ));
        manager.add(new Movie(++sessionCount,"해리포터와 마법사의 돌", "크리스 콜롬버스","판타지",152 ));
        manager.add(new Movie(++sessionCount,"해리포터와 비밀의 방", "크리스 콜롬버스","판타지",162 ));
        manager.add(new SeriesMovie(++sessionCount,"반지의 제왕", "피터 잭슨","판타지",263 , 5, "시리즈1"));
        manager.add(new SeriesMovie(++sessionCount,"듄", "드니 뷜뇌브","액션",155 ,1, "시리즈2"));
        manager.add(new SeriesMovie(++sessionCount,"강릉", "윤영빈","강릉",119 ,2, "시리즈3"));
        printSeparator();
        System.out.println("초기화 완료");
        printSeparator();
        System.out.println("영화 정보");
        printView(manager.getMovies(),manager.getMovies().length);

        printSeparator();
        System.out.println("시리즈 정보");
        printSeparator();

        printView(manager.getSeriesMovies(),manager.getSeriesMovies().length);
        printSeparator();
        System.out.println();

        printSeparator();
        System.out.println("제목 찾기");
        printSeparator();
        try {
            printView(manager.searchByTitle("기생충"), manager.searchByTitle("기생충").length);
            printView(manager.searchByTitle("베테랑"), manager.searchByTitle("베테랑").length);
        }catch (TitleNotFoundException e){
            System.out.println(e.getTitle() + "영화는 없습니다.");
        }
        printSeparator();

        System.out.println("1번 영화 삭제");
        printSeparator();



        manager.remove(1);
        printSeparator();
        System.out.println("영화 정보");
        printSeparator();

        printView(manager.getList(), manager.getList().length);
        printSeparator();
        System.out.println("9번 영화 삭제");
        printSeparator();
        manager.remove(1);
        printSeparator();
        System.out.println("영화 정보");
        printSeparator();

        printView(manager.getList(), manager.getList().length);



    }

    private static void printView(Movie[] movies, int size) {
        for(int i = 0 ; i < size; i++){

            if(movies[i] instanceof SeriesMovie)
            System.out.println(String.format("%-15d \t| %-15s \t| %-15s \t| %-15s \t| %-15d \t| %-15d \t| %-15s", movies[i].getId(), movies[i].getTitle(), movies[i].getDirector(), movies[i].getGenre(), +movies[i].getRunningTime(), ((SeriesMovie) movies[i]).getSeriesNum(), ((SeriesMovie) movies[i]).getEpisode()));
            else if(movies[i] instanceof Movie){
                System.out.println(String.format("%-15d \t| %-15s \t| %-15s \t| %-15s \t| %-15d", movies[i].getId(), movies[i].getTitle(), movies[i].getDirector(), movies[i].getGenre(), +movies[i].getRunningTime()));
            }
        }
        System.out.println();
    }

    public static void printSeparator(){
        printSeparator("=",20);
    }
    public static void printSeparator(String str, int value){
        for(int i = 0; i < value; i++){
            System.out.print(str);
        }
        System.out.println();
    }


}
