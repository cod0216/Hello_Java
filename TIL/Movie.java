package TIL;



/**
 * <pre>
 * 영화 도메인 클래스
 *
 * 영화 도메인 속성 정보
 *  img : parasite.jpg
 *  title : 기생충
 *  genre : 드라마
 *  director : 봉준호
 *  runningTime : 131
 *
 *  DTO(Data Transfer Object) Pattern
 *  1. Encapsulation : information hiding(데이터, 알고리즘 보호)
 *  2. 설계규칙 :
 *  	(1) private 멤버변수 			private String title;
 *  	(2) public setter()			public void setTitle(String title){
 *  									if(isTitle(title)){
 *  										this.title=title
 *  									}
 *  								}
 *  	(3) public getter()			public	String getTitle() { return title;}
 *  	(4)	private isValidate()	private boolean isTitle(String title) {
 *  									if(검증조건){
 *  										return true;
 *  									} else {
 *  										return false;
 *  									}
 *  								}
 *
 *  </pre>
 *  @author 최은창
 *  @version ver.1.0
 *  @since jdk17
 *  @see java.lang.Object#toString()
 */



/**
 *
 */
public class Movie {
    /** 영화번호 */
    private int id;
    /** 영화제목 */
    private String title ="";
    /** 영화감독 */
    private String director = "";
    /** 영화장르 */
    private String genre = "";
    /** 상영시간 */
    private int runningTime;

    /**기본 생성자*/
    public Movie() {
//		System.out.println("영화 기본 생성자!!!");
    }

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
//		System.out.println("영화 필수 데이터!!!");
    }

    public Movie(int id, String title, String director, String genre, int runningTime) {
//		super(); //명시적으로 부모의 생성자를 지정하지 않으면 자동으로 부모의 기본생성자super() 추가됨
//
//		this.id = id;
//		this.title = title;

        this(id, title);
        this.director = director;
        this.genre = genre;
        this.runningTime = runningTime;
//		System.out.println("영화 전체데이터!!!");
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the runningTime
     */
    public int getRunningTime() {
        return runningTime;
    }

    /**
     * @param runningTime the runningTime to set
     */
    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return "id : " + id + "\ntitle : " + title + "\ndirector : " + director + "\ngenre : " + genre
                + "\nrunningTime : " + runningTime + "\n---------------------------";
    }


//	@Override
//	public String toString() {
//		return id + "| " + title + "| " + director + "| " + genre + "| " + runningTime + "]";
//	}

//	@Override
//	public String toString() {
//		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre + ", runningTime="
//				+ runningTime + "]";
//	}










}
