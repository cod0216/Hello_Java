package ssafy.step4;


// Movie를 상속받고 시리즈 넘버와 에피소드를 맴버 변수로 추가한다.
public class SeriesMovie extends Movie {
    private int seriesNum;
    private String episode;


    //생성자
    public SeriesMovie() {
    }

    //생성자 오버로드
    public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode) {
        super(id, title, director, genre, runningTime);
        this.seriesNum = seriesNum;
        this.episode = episode;
    }

    //getter setter
    public int getSeriesNum() {
        return seriesNum;
    }

    public void setSeriesNum(int seriesNum) {
        this.seriesNum = seriesNum;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
}
