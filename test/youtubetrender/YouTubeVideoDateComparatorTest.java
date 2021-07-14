package youtubetrender;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class YouTubeVideoDateComparatorTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Beginning to test YouTubeVideoDateComparator Class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Successfully testing YouTubeVideoDateComparator Class");
    }

    @Test
    public void testCompare(){
        System.out.println("test Compare method");
        YouTubeVideo vid1 = new YouTubeVideo("Alan","2020", "New Word",
                "Nothing to say", 1,1,1,1, "1" );
        YouTubeVideo vid2 = new YouTubeVideo("Roy","2002", "Little Girl",
                "Again", 2, 2,2,2,"6" );
        YouTubeVideo vid3 = new YouTubeVideo("Alan","2020", "New Bbb",
                "Nope", 15,3,3,3, "3" );

        YouTubeVideoDateComparator cp = new YouTubeVideoDateComparator();
        System.out.println("vid1 date: 2020");
        System.out.println("vid2 date: 2002");
        System.out.println("vid3 date: 2020");

        System.out.println("Expected vid2 date less than vid1 date (<= -1)");
        System.out.println("Actual :" + cp.compare(vid2,vid1));
        assertTrue("expected to be less than", cp.compare(vid2,vid1) <= -1);

        System.out.println("Expected vid1 date equal vid 3 date (== 0)");
        System.out.println("Actual :" + cp.compare(vid3,vid1));
        assertTrue("expected to be equal", cp.compare(vid3,vid1) == 0);

        System.out.println("Expected vid3 date greater than vid2 date (>= 1)");
        System.out.println("Actual :" + cp.compare(vid3,vid2));
        assertTrue("expected to be greater", cp.compare(vid3,vid2) >=1);
        System.out.println("Successful");System.out.println("Successful");
    }
}
