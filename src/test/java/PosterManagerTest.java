import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {

    @Test
    public void testDefaultConstructor() {
        PosterManager manager = new PosterManager();

        String[] expectedAll = {};
        String[] expectedLast = {};

        assertArrayEquals(expectedAll, manager.findAll());
        assertArrayEquals(expectedLast, manager.findLast());
    }

    @Test
    public void testCustomConstructor() {
        PosterManager manager = new PosterManager(7);

        String[] expectedAll = {};
        String[] expectedLast = {};

        assertArrayEquals(expectedAll, manager.findAll());
        assertArrayEquals(expectedLast, manager.findLast());
    }

    @Test
    public void testAddSingleMovie() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Inception");

        String[] expectedAll = {"Inception"};
        String[] expectedLast = {"Inception"};

        assertArrayEquals(expectedAll, manager.findAll());
        assertArrayEquals(expectedLast, manager.findLast());
    }

    @Test
    public void testAddMultipleMovies() {
        PosterManager manager = new PosterManager();
        manager.addMovie("Inception");
        manager.addMovie("The Matrix");
        manager.addMovie("Interstellar");

        String[] expectedAll = {"Inception", "The Matrix", "Interstellar"};
        String[] expectedLast = {"Interstellar", "The Matrix", "Inception"};

        assertArrayEquals(expectedAll, manager.findAll());
        assertArrayEquals(expectedLast, manager.findLast());
    }

    @Test
    public void testFindAllWhenEmpty() {
        PosterManager manager = new PosterManager();

        String[] expected = {};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLastWhenEmpty() {
        PosterManager manager = new PosterManager();

        String[] expected = {};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastWhenLessThanLimit() {
        PosterManager manager = new PosterManager(5);
        manager.addMovie("Movie1");
        manager.addMovie("Movie2");

        String[] expected = {"Movie2", "Movie1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastWhenEqualToLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addMovie("Movie1");
        manager.addMovie("Movie2");
        manager.addMovie("Movie3");

        String[] expected = {"Movie3", "Movie2", "Movie1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastWhenMoreThanLimit() {
        PosterManager manager = new PosterManager(3);
        manager.addMovie("Movie1");
        manager.addMovie("Movie2");
        manager.addMovie("Movie3");
        manager.addMovie("Movie4");
        manager.addMovie("Movie5");

        String[] expected = {"Movie5", "Movie4", "Movie3"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastWithDefaultLimit() {
        PosterManager manager = new PosterManager();

        for (int i = 1; i <= 7; i++) {
            manager.addMovie("Movie" + i);
        }

        String[] expected = {"Movie7", "Movie6", "Movie5", "Movie4", "Movie3"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testWithLargeNumberOfMovies() {
        PosterManager manager = new PosterManager(10);

        for (int i = 1; i <= 15; i++) {
            manager.addMovie("Film" + i);
        }

        String[] expectedAll = {"Film1", "Film2", "Film3", "Film4", "Film5", "Film6", "Film7", "Film8", "Film9", "Film10", "Film11", "Film12", "Film13", "Film14", "Film15"};
        String[] expectedLast = {"Film15", "Film14", "Film13", "Film12", "Film11", "Film10", "Film9", "Film8", "Film7", "Film6"};

        assertArrayEquals(expectedAll, manager.findAll());
        assertArrayEquals(expectedLast, manager.findLast());
    }
}