public class PosterManager {
    private String[] movies;
    private int limit;

    // Конструктор по умолчанию (лимит = 5)
    public PosterManager() {
        this.limit = 5;
        this.movies = new String[0];
    }

    // Конструктор с параметром лимита
    public PosterManager(int limit) {
        this.limit = limit;
        this.movies = new String[0];
    }

    // Добавление нового фильма
    public void addMovie(String movie) {
        String[] newMovies = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }
        newMovies[movies.length] = movie;
        movies = newMovies;
    }

    // Вывод всех фильмов в порядке добавления
    public String[] findAll() {
        return movies;
    }

    // Вывод последних добавленных фильмов в обратном порядке
    public String[] findLast() {
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }

    // Геттеры для тестирования
    public int getLimit() {
        return limit;
    }

    public int getMoviesCount() {
        return movies.length;
    }
}