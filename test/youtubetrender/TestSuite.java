package youtubetrender;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({YouTubeDataParserTest.class, YouTubeVideoTest.class,
        YouTubeVideoChannelComparatorTest.class, YouTubeVideoDateComparatorTest.class,
        YouTubeVideoDescriptionComparatorTest.class, YouTubeVideoViewComparatorTest.class,
        YouTubeWordItemTest.class, YouTubeVideoIndexerTest.class,
        YouTubeVideoLikeComparatorTest.class, YouTubeVideoDislikeComparatorTest.class,
        YouTubeVideoCommentComparatorTest.class})
public class TestSuite {
}