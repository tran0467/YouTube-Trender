package youtubetrender;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class YouTubeVideoTest {

    String fileName1 = "YouTubeTrender/src/data/youtubedata.json";
    YouTubeDataParser instance1 = new YouTubeDataParser();
    List<YouTubeVideo> result1 = instance1.parse(fileName1);

    public YouTubeVideoTest() throws YouTubeDataParserException {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Beginning to test YouTubeVideo Class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Successfully testing YouTubeVideo Class");
    }

    @Test
    public void testGetChannel() {
        System.out.println("test getChannel method");
        System.out.println("Expected: Joe Bloggs");
        System.out.println("Actual: " + result1.get(0).getChannel());
        assertEquals("Joe Bloggs", result1.get(0).getChannel());
        System.out.println("Successful");
    }

    @Test
    public void testGetDate() {
        System.out.println("test getDate method");
        System.out.println("Expected: 2016-04-20T23:15:17.000Z");
        System.out.println("Actual: " + result1.get(0).getDate());
        assertEquals("2016-04-20T23:15:17.000Z", result1.get(0).getDate());
        System.out.println("Successful");
    }

    @Test
    public void testGetTitle() {
        System.out.println("test getTitle method");
        System.out.println("Expected: This should have a really useful title");
        System.out.println("Actual: " + result1.get(0).getTitle());
        assertEquals("This should have a really useful title", result1.get(0).getTitle());
        System.out.println("Successful");
    }

    @Test
    public void testSetTitle() {
        System.out.println("test setTitle method");
        result1.get(0).setTitle("New Title");
        System.out.println("Expected: New Title");
        System.out.println("Actual: " + result1.get(0).getTitle());
        assertEquals("New Title", result1.get(0).getTitle());
        System.out.println("Successful");
    }

    @Test
    public void testGetDescription() {
        System.out.println("test getDescription method");
        System.out.println("Expected: This should have a really useful description. " +
                "However lots of youtubers put links and other promotional material.");
        System.out.println("Actual: " + result1.get(0).getDescription());
        assertEquals("This should have a really useful description.  " +
                "However lots of youtubers put links and other promotional material.",
                result1.get(0).getDescription());
        System.out.println("Successful");
    }

    @Test
    public void testSetDescription() {
        System.out.println("test setDescription");
        result1.get(0).setDescription("New Description");
        System.out.println("Expected: New Description");
        System.out.println("Actual: " + result1.get(0).getDescription());
        assertEquals("New Description", result1.get(0).getDescription());
        System.out.println("Successful");
    }

    @Test
    public void testGetView() {
        System.out.println("test getView method");
        System.out.println("Expected: 14180950");
        System.out.println("Actual: " + result1.get(0).getViewCount());
        assertEquals(14180950, result1.get(0).getViewCount());
        System.out.println("Successful");
    }

    @Test
    public void testGetLike() {
        System.out.println("test getLike method");
        System.out.println("Expected: 28740");
        System.out.println("Actual: " + result1.get(0).getLikeCount());
        assertEquals(28740, result1.get(0).getLikeCount());
        System.out.println("Successful");
    }

    @Test
    public void testGetDislike() {
        System.out.println("test getLike method");
        System.out.println("Expected: 4499");
        System.out.println("Actual: " + result1.get(0).getDislikeCount());
        assertEquals(4499, result1.get(0).getDislikeCount());
        System.out.println("Successful");
    }

    @Test
    public void testGetComment() {
        System.out.println("test getComment method");
        System.out.println("Expected: 11754");
        System.out.println("Actual: " + result1.get(0).getCommentCount());
        assertEquals(11754, result1.get(0).getCommentCount());
        System.out.println("Successful");
    }

    @Test
    public void testGetID() {
        System.out.println("test getID method");
        System.out.println("Expected: UCehf4850q1L3ng7s7L54ATA");
        System.out.println("Actual: " + result1.get(0).getID());
        assertEquals("UCehf4850q1L3ng7s7L54ATA", result1.get(0).getID());
        System.out.println("Successful");
    }
}
