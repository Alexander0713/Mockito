import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {

    // Тест конструктора по умолчанию
    @Test
    public void testDefaultConstructor() {
        PosterManager manager = new PosterManager();

        assertEquals(5, manager.getLimit());
        assertEquals(0, manager.getMoviesCount());
    }

    // Тест конструктора с кастомным лимитом
    @Test
    public void testCustomConstructor() {
        PosterManager manager = new PosterManager(7);

        assertEquals(7, manager.getLimit());
        assertEquals(0, manager.getMoviesCount());
    }

    // Тест добавления одного фильма
    @Test
    public void testAddSingleMovie() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Inception");

        assertEquals(1, manager.getMoviesCount());
        String[] allMovies = manager.findAll();
        assertEquals("Inception", allMovies[0]);
    }

    // Тест добавления нескольких фильмов
    @Test
    public void testAddMultipleMovies() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Inception");
        manager.addMovie("The Matrix");
        manager.addMovie("Interstellar");

        assertEquals(3, manager.getMoviesCount());
        String[] allMovies = manager.findAll();
        assertEquals("Inception", allMovies[0]);
        assertEquals("The Matrix", allMovies[1]);
        assertEquals("Interstellar", allMovies[2]);
    }

    // Тест findAll для пустого менеджера
    @Test
    public void testFindAllWhenEmpty() {
        PosterManager manager = new PosterManager();

        String[] result = manager.findAll();

        assertEquals(0, result.length);
    }

    // Тест findLast для пустого менеджера
    @Test
    public void testFindLastWhenEmpty() {
        PosterManager manager = new PosterManager();

        String[] result = manager.findLast();

        assertEquals(0, result.length);
    }

    // Тест findLast когда фильмов меньше лимита
    @Test
    public void testFindLastWhenLessThanLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addMovie("Movie1");
        manager.addMovie("Movie2");

        String[] result = manager.findLast();

        assertEquals(2, result.length);
        assertEquals("Movie2", result[0]);
        assertEquals("Movie1", result[1]);
    }

    // Тест findLast когда фильмов равно лимиту
    @Test
    public void testFindLastWhenEqualToLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addMovie("Movie1");
        manager.addMovie("Movie2");
        manager.addMovie("Movie3");

        String[] result = manager.findLast();

        assertEquals(3, result.length);
        assertEquals("Movie3", result[0]);
        assertEquals("Movie2", result[1]);
        assertEquals("Movie1", result[2]);
    }

    // Тест findLast когда фильмов больше лимита
    @Test
    public void testFindLastWhenMoreThanLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addMovie("Movie1");
        manager.addMovie("Movie2");
        manager.addMovie("Movie3");
        manager.addMovie("Movie4");
        manager.addMovie("Movie5");

        String[] result = manager.findLast();

        assertEquals(3, result.length);
        assertEquals("Movie5", result[0]);
        assertEquals("Movie4", result[1]);
        assertEquals("Movie3", result[2]);
    }

    // Тест findLast с лимитом по умолчанию
    @Test
    public void testFindLastWithDefaultLimit() {
        PosterManager manager = new PosterManager(); // лимит = 5

        // Добавляем 7 фильмов
        for (int i = 1; i <= 7; i++) {
            manager.addMovie("Movie" + i);
        }

        String[] result = manager.findLast();

        assertEquals(5, result.length);
        assertEquals("Movie7", result[0]);
        assertEquals("Movie6", result[1]);
        assertEquals("Movie5", result[2]);
        assertEquals("Movie4", result[3]);
        assertEquals("Movie3", result[4]);
    }

    // Тест с большим количеством фильмов
    @Test
    public void testWithLargeNumberOfMovies() {
        PosterManager manager = new PosterManager(10);

        for (int i = 1; i <= 15; i++) {
            manager.addMovie("Film" + i);
        }

        String[] lastMovies = manager.findLast();
        String[] allMovies = manager.findAll();

        assertEquals(10, lastMovies.length);
        assertEquals(15, allMovies.length);
        assertEquals("Film15", lastMovies[0]);
        assertEquals("Film6", lastMovies[9]);
        assertEquals("Film1", allMovies[0]);
        assertEquals("Film15", allMovies[14]);
    }
}