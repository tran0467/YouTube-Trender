package youtubetrender;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class YouTubeVideoCommentComparatorTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Beginning to test YouTubeVideoCommentComparatorTest class");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Successfully testing YouTubeVideoCommentComparatorTest class");
    }

    @Test
    public void testCompare(){
        System.out.println("test Compare method");
        YouTubeVideo vid1 = new YouTubeVideo("Alan","18/6/2019", "New Word",
                "Nothing to say", 1,1,1,1, "1" );
        YouTubeVideo vid2 = new YouTubeVideo("Roy","17/3/2002", "Little Girl",
                "Again", 2, 2,2,2,"6" );
        YouTubeVideo vid3 = new YouTubeVideo("Alan","16/8/2000", "New Bbb",
                "Nope", 15,1,1,1, "3" );

        System.out.println("vid1 comment: 1");
        System.out.println("vid2 comment: 2");
        System.out.println("vid3 comment: 1");

        YouTubeVideoCommentComparator cp = new YouTubeVideoCommentComparator();

        System.out.println("Expected vid1 comment less than vid2 comment (<= -1)");
        System.out.println("Actual :" + cp.compare(vid1,vid2));
        assertTrue("expected to be less than", cp.compare(vid1,vid2) <= -1);

        System.out.println("Expected vid1 comment equal vid 3 comment (== 0)");
        System.out.println("Actual :" + cp.compare(vid3,vid1));
        assertTrue("expected to be equal", cp.compare(vid3,vid1) == 0);

        System.out.println("Expected vid2 comment greater than vid3 comment (>= 1)");
        System.out.println("Actual :" + cp.compare(vid2,vid3));
        assertTrue("expected to be greater", cp.compare(vid2,vid3) >=1);
        System.out.println("Successful");

    }
}
