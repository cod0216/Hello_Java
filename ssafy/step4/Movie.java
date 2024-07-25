package ssafy.step4;


/*
멤버 변수 : 영화 id값, 제목, 감독, 장르, 러닝 타임
 */
public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private int runningTime;

    //생성자
    public Movie() {
    }

    //생성자 오버로드
    public Movie(int id, String title, String director, String genre, int runningTime) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }


//    toString 오버라이드
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                '}';
    }
}
