package youtubetrender;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class YouTubeVideoChannelComparatorTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Beginning to test YouTubeVideoChannelComparator Class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Successfully testing YouTubeVideoChannelComparator Class");
    }

    @Test
    public void testCompare(){
        System.out.println("test Compare method");
        YouTubeVideo vid1 = new YouTubeVideo("Alan","18/6/2019", "New Word",
                "Nothing to say", 1,1,1,1, "1" );
        YouTubeVideo vid2 = new YouTubeVideo("Roy","17/3/2002", "Little Girl",
                "Again", 2, 2,2,2,"6" );
        YouTubeVideo vid3 = new YouTubeVideo("Alan","16/8/2000", "New Bbb",
                "Nope", 15,3,3,3, "3" );
        System.out.println("vid1 channel: Alan");
        System.out.println("vid2 channel: Roy");
        System.out.println("vid3 channel: Alan");
        YouTubeVideoChannelComparator channel = new YouTubeVideoChannelComparator();
        System.out.println("Expected vid1 channel less than vid2 channel (<= -1)");
        System.out.println("Actual :" + channel.compare(vid1,vid2));
        assertTrue("expected to be less than", channel.compare(vid1,vid2) <= -1);

        System.out.println("Expected vid1 channel equal vid 3 channel (== 0)");
        System.out.println("Actual :" + channel.compare(vid3,vid1));
        assertTrue("expected to be equal", channel.compare(vid3,vid1) == 0);

        System.out.println("Expected vid2 channel greater than vid3 channel (>= 1)");
        System.out.println("Actual :" + channel.compare(vid2,vid3));
        assertTrue("expected to be greater", channel.compare(vid2,vid3) >=1);
        System.out.println("Successful");
    }
}
