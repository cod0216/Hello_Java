package TIL;


import java.util.Arrays;

public class MovieTest {
	public static void main(String args[]) {
		Movie m1 = new Movie(1, "영화1", "스릴러", "정상범", 120 );
		Movie m2 = new Movie(2, "영화2", "공포", "박상범", 100 );

		System.out.println(m1);
		System.out.println(m2);

		MovieManage movieManage = new MovieManage();
		movieManage.add(m1);
		movieManage.add(m2);

		Movie[] movies = movieManage.getList();
		int size = movieManage.getSize();

		for(int i = 0; i < size; i++) {
			System.out.println(movies[i]);
		}

		Movie resultMovie = movieManage.searchTitle("영화2");
		System.out.println(resultMovie);

		movies = movieManage.searchTitleLike("영");
		for (Movie movie : movies) {
			System.out.println(movie);
		}

		movieManage.remove(1);
		movies = movieManage.getList();
		for (Movie movie : movies) {
			System.out.println(movie);
		}
		movieManage.read(2);



	}
}
