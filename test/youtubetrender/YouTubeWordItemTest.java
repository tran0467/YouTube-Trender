package youtubetrender;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YouTubeWordItemTest {
    YouTubeVideo vid1 = new YouTubeVideo("Alan","18/6/2019", "New Word",
            "Nothing to say", 1,1,1,1, "1" );
    YouTubeVideo vid2 = new YouTubeVideo("Roy","17/3/2002", "Little Girl",
            "Again", 2, 2,2,2,"6" );
    YouTubeVideo vid3 = new YouTubeVideo("Alan","16/8/2000", "New Bbb",
            "Nope", 15,3,3,3, "3" );
    private Set<YouTubeVideo> videos = new HashSet<>();
    private YouTubeWordItem word = new YouTubeWordItem("b");

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Beginning to test YouTubeWordItem class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Successfully testing YouTubeWordItem class");
    }

    @Test
    public void testAdd() {
        System.out.println("test add method");
        word.add(vid1);
        assertTrue("Set contains the video", word.getVideos().contains(vid1));
        System.out.println("Successful");
    }

    @Test
    public void testGetCount() {
        System.out.println("test getCount method");
        word.add(vid1);
        System.out.println("Expected: 1");
        System.out.println("Actual: " + word.getCount());
        assertEquals(1, word.getCount());
        System.out.println("Successful");
    }

    @Test
    public void testGetVideo() {
        word.add(vid1);
        videos.add(vid1);
        assertEquals(videos, word.getVideos());
        System.out.println("Successful");
    }

    @Test
    public void testGetWord() {
        System.out.println("test getWord method");
        System.out.println("Expected: b");
        System.out.println("Actual: " + word.getWord());
        assertEquals("b", word.getWord());
        System.out.println("Successful");
    }

    @Test
    public void testCompareTo() {
        System.out.println("test compareTo method");
        YouTubeWordItem w = new YouTubeWordItem("c");
        YouTubeWordItem wor = new YouTubeWordItem("a");
        YouTubeWordItem wo = new YouTubeWordItem("b");

        word.add(vid1);
        word.add(vid1);
        w.add(vid2);
        w.add(vid3);
        wor.add(vid1);
        wor.add(vid2);
        wor.add(vid3);
        wo.add(vid3);

        assertTrue("expected to be less than", word.compareTo(wo) <= -1);
        assertTrue("expected to be equal", word.compareTo(w) == 0);
        assertTrue("expected to be greater", word.compareTo(wor) >=1);
        System.out.println("Successful");
    }

}
