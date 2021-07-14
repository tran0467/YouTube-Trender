package youtubetrender;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class YouTubeVideoIndexerTest {

    String fileName1 = "YouTubeTrender/src/data/youtubedata.json";
    YouTubeDataParser instance1 = new YouTubeDataParser();
    List<YouTubeVideo> result1 = instance1.parse(fileName1);
    YouTubeVideoIndexer vidIndex1 = new YouTubeVideoIndexer(result1);
    List<YouTubeWordItem> wordlist1 = new ArrayList<>();

    String fileName2 = "YouTubeTrender/src/data/youtubedata_15_50.json";
    YouTubeDataParser instance2 = new YouTubeDataParser();
    List<YouTubeVideo> result2 = instance2.parse(fileName2);
    YouTubeVideoIndexer vidIndex2 = new YouTubeVideoIndexer(result2);
    List<YouTubeWordItem> wordlist2 = new ArrayList<>();

    String fileName3 = "YouTubeTrender/src/data/youtubedata_loremipsum.json";
    YouTubeDataParser instance3 = new YouTubeDataParser();
    List<YouTubeVideo> result3 = instance3.parse(fileName3);
    YouTubeVideoIndexer vidIndex3 = new YouTubeVideoIndexer(result3);
    List<YouTubeWordItem> wordlist3 = new ArrayList<>();

    String fileName4 = "YouTubeTrender/src/data/youtubedata_indextest.json";
    YouTubeDataParser instance4 = new YouTubeDataParser();
    List<YouTubeVideo> result4 = instance4.parse(fileName4);
    YouTubeVideoIndexer vidIndex4 = new YouTubeVideoIndexer(result4);
    List<YouTubeWordItem> wordlist4 = new ArrayList<>();

    public YouTubeVideoIndexerTest() throws YouTubeDataParserException {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Beginning to test YouTubeVideoIndexer Class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Successfully testing YouTubeVideoIndexer Class");
    }

    @Test
    public void testIndexandSorting() {
        System.out.println("test Index method and getSortedYouTubeWordItems method");
        vidIndex1.index();
        wordlist1 = vidIndex1.getSortedYouTubeWordItems();
        System.out.println("Testing the file: " + fileName1);
        System.out.println("Expected: a[2]");
        System.out.println("Actual: " + wordlist1.get(0).toString());
        assertEquals("a[2]", wordlist1.get(0).toString());

        vidIndex2.index();
        wordlist2 = vidIndex2.getSortedYouTubeWordItems();
        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: the[97]");
        System.out.println("Actual: " + wordlist2.get(0).toString());
        assertEquals("the[97]", wordlist2.get(0).toString());

        vidIndex3.index();
        wordlist3 = vidIndex3.getSortedYouTubeWordItems();
        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: sit[17]");
        System.out.println("Actual: " + wordlist3.get(0).toString());
        assertEquals("sit[17]", wordlist3.get(0).toString());

        vidIndex4.index();
        wordlist4 = vidIndex4.getSortedYouTubeWordItems();
        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: FIVE[5]");
        System.out.println("Actual: " + wordlist4.get(0).toString());
        assertEquals("FIVE[5]", wordlist4.get(0).toString());
        System.out.println("Successful");
    }

    @Test
    public void testGetWordItem(){
        System.out.println("test getWordItem method");
        vidIndex1.index();
        System.out.println("Testing the file: " + fileName1);
        System.out.println("Expected: a[2]");
        System.out.println("Actual: " + vidIndex1.getWordItem("a").toString());
        assertEquals("a[2]", vidIndex1.getWordItem("a").toString());

        vidIndex2.index();
        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: the[97]");
        System.out.println("Actual: " + vidIndex2.getWordItem("the").toString());
        assertEquals("the[97]", vidIndex2.getWordItem("the").toString());

        vidIndex3.index();
        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: sit[17]");
        System.out.println("Actual: " + vidIndex3.getWordItem("sit").toString());
        assertEquals("sit[17]", vidIndex3.getWordItem("sit").toString());

        vidIndex4.index();
        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: FIVE[5]");
        System.out.println("Actual: " + vidIndex4.getWordItem("FIVE").toString());
        assertEquals("FIVE[5]", vidIndex4.getWordItem("FIVE").toString());
        System.out.println("Successful");
    }

    @Test
    public void testGetWordCount(){
        System.out.println("test getWordCount method");
        vidIndex1.index();
        System.out.println("Testing the file: " + fileName1);
        System.out.println("Expected: 2");
        System.out.println("Actual: " + vidIndex1.getWordCount("a"));
        assertEquals(2, vidIndex1.getWordCount("a"));

        vidIndex2.index();
        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: 97");
        System.out.println("Actual: " + vidIndex2.getWordCount("the"));
        assertEquals(97, vidIndex2.getWordCount("the"));

        vidIndex3.index();
        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: 17");
        System.out.println("Actual: " + vidIndex3.getWordCount("sit"));
        assertEquals(17, vidIndex3.getWordCount("sit"));

        vidIndex4.index();
        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: 5");
        System.out.println("Actual: " + vidIndex4.getWordCount("FIVE"));
        assertEquals(5, vidIndex4.getWordCount("FIVE"));
        System.out.println("Successful");
    }

    @Test
    public void testGetWordVideo(){
        System.out.println("test getWordVideo method");
        vidIndex1.index();
        Set<YouTubeVideo> test = new HashSet<>();
        test = vidIndex1.getWordVideos("a");
        System.out.println("Testing the file: " + fileName1);
        System.out.println("Expected: [Joe Bloggs: This should have a really useful title]");
        System.out.println("Actual: " + test.toString());
        assertEquals("[Joe Bloggs: This should have a really useful title]", test.toString());

        vidIndex2.index();
        test = vidIndex2.getWordVideos("REAL");
        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: [FaZe Rain: SHOULD WE GET THIS DOG?!]");
        System.out.println("Actual: " + test.toString());
        assertEquals("[FaZe Rain: SHOULD WE GET THIS DOG?!]", test.toString());

        vidIndex3.index();
        test = vidIndex3.getWordVideos("dui");
        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: [The Slow Mo Guys: Vestibulum tellus elit]");
        System.out.println("Actual: " + test.toString());
        assertEquals("[The Slow Mo Guys: Vestibulum tellus elit]", test.toString());

        vidIndex4.index();
        test = vidIndex4.getWordVideos("ONE");
        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: [Joe Bloggs: ONE TWO TWO THREE THREE THREE]");
        System.out.println("Actual: " + test.toString());
        assertEquals("[Joe Bloggs: ONE TWO TWO THREE THREE THREE]", test.toString());
        System.out.println("Successful");
    }
}
