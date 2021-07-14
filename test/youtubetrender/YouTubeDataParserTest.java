/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author Ngoc
 */
public class YouTubeDataParserTest {

    String fileName1 = "YouTubeTrender/src/data/youtubedata.json";
    YouTubeDataParser instance1 = new YouTubeDataParser();
    List<YouTubeVideo> result1 = instance1.parse(fileName1);
    String fileName2 = "YouTubeTrender/src/data/youtubedata_15_50.json";
    YouTubeDataParser instance2 = new YouTubeDataParser();
    List<YouTubeVideo> result2 = instance2.parse(fileName2);
    String fileName3 = "YouTubeTrender/src/data/youtubedata_loremipsum.json";
    YouTubeDataParser instance3 = new YouTubeDataParser();
    List<YouTubeVideo> result3 = instance3.parse(fileName3);
    String fileName4 = "YouTubeTrender/src/data/youtubedata_indextest.json";
    YouTubeDataParser instance4 = new YouTubeDataParser();
    List<YouTubeVideo> result4 = instance4.parse(fileName4);
    public YouTubeDataParserTest() throws YouTubeDataParserException {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Beginning to test YouTubeDataParser class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Successfully testing YouTubeDataParser class");
    }

    /**
     * Test of parse method, of class YouTubeDataParser.
     */
    @Test (expected = YouTubeDataParserException.class)
    public void testParseWithNull() throws Exception {
        System.out.println("test Parse method with Null filename");
        String fileName = "";
        YouTubeDataParser instance = new YouTubeDataParser();
        List<YouTubeVideo> expResult = null;
        List<YouTubeVideo> result = instance.parse(fileName);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
        System.out.println("Successful");
    }

    @Test (expected = YouTubeDataParserException.class)
    public void testParseWithMalformedFile() throws Exception {
        System.out.println("test Parse method with Malformed File");
        String fileName = "YouTubeTrender/src/data/youtubedata_malformed.json";
        YouTubeDataParser instance = new YouTubeDataParser();
        instance.parse(fileName);
        fail("The test case is a prototype.");
        System.out.println("Successful");
    }


    @Test
    public void testParse() throws FileNotFoundException {
        System.out.println("Test parse with valid filenames");
        /**
        youtubedata.json - Expected size = 1
         */
        System.out.println("Testing the file: " + fileName1);
        System.out.println("Expecting size: 1");
        // Read data
        JsonReader jsonReader = Json.createReader(new FileInputStream(fileName1));
        JsonObject jobj = jsonReader.readObject();

        // read the values of the item field
        JsonArray items = jobj.getJsonArray("items");

        System.out.println("Actual size: " + result1.size());
        assertEquals(items.size(), result1.size());

        /**
         * youtubedata_15_50.json - expected size = 50
          */
        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expecting size: 50");
        // Read data
        JsonReader jsonReader2 = Json.createReader(new FileInputStream(fileName2));
        JsonObject jobj2 = jsonReader2.readObject();

        // read the values of the item field
        JsonArray items2 = jobj2.getJsonArray("items");
        System.out.println("Actual size: " + result2.size());
        assertEquals(items2.size(), result2.size());

        /**
         * youtubedata_loremipsum.json - expected size = 10
         */
        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expecting size: 10");
        // Read data
        JsonReader jsonReader3 = Json.createReader(new FileInputStream(fileName3));
        JsonObject jobj3 = jsonReader3.readObject();

        // read the values of the item field
        JsonArray items3 = jobj3.getJsonArray("items");
        System.out.println("Actual size: " + result3.size());
        assertEquals(items3.size(), result3.size());

        /**
         * youtudedata_indextest.json - expected size = 1
         */
        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expecting size: 1");
        // Read data
        JsonReader jsonReader4 = Json.createReader(new FileInputStream(fileName4));
        JsonObject jobj4 = jsonReader4.readObject();

        // read the values of the item field
        JsonArray items4 = jobj4.getJsonArray("items");
        System.out.println("Actual size: " + result4.size());
        assertEquals(items4.size(), result4.size());
        System.out.println("Successful");
    }

    @Test
    public void testByChannel() {
        System.out.println("test byChannel method");
        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: UC1DeG8ZTab89_XNNqWxlDqA");
        System.out.println("Actual: " + instance2.byChannel().get(0).getID());
        assertEquals("UC1DeG8ZTab89_XNNqWxlDqA", instance2.byChannel().get(0).getID());

        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: UC5gki32EO6PN_lhl46G1q4w");
        System.out.println("Actual: " + instance3.byChannel().get(0).getID());
        assertEquals("UC5gki32EO6PN_lhl46G1q4w", instance3.byChannel().get(0).getID());

        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: UCehf4850q1L3ng7s7L54ATA");
        System.out.println("Actual: " + instance4.byChannel().get(0).getID());
        assertEquals("UCehf4850q1L3ng7s7L54ATA", instance4.byChannel().get(0).getID());
        System.out.println("Successful");
    }

    @Test
    public void testByDate() {
        System.out.println("Test byDate method");
        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: UC6eCfDyUc4TwvwxwTDxMfMg");
        System.out.println("Actual: " + instance2.byDate().get(0).getID());
        assertEquals("UC6eCfDyUc4TwvwxwTDxMfMg", instance2.byDate().get(0).getID());

        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: UCPDis9pjXuqyI7RYLJ");
        System.out.println("Actual: " + instance3.byDate().get(0).getID());
        assertEquals("UCPDis9pjXuqyI7RYLJ-TTSA", instance3.byDate().get(0).getID());

        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: UCehf4850q1L3ng7s7L54ATA");
        System.out.println("Actual: " + instance4.byDate().get(0).getID());
        assertEquals("UCehf4850q1L3ng7s7L54ATA", instance4.byDate().get(0).getID());
        System.out.println("Successful");
    }

    @Test
    public void testByView() {
        System.out.println("test byView method");

        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: UCPckaTvXvCmfCSZhFIIhi0g");
        System.out.println("Actual: " + instance2.byView().get(0).getID());
        assertEquals("UCPckaTvXvCmfCSZhFIIhi0g", instance2.byView().get(0).getID());

        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: UC5gki32EO6PN_lhl46G1q4w");
        System.out.println("Actual: " + instance3.byView().get(0).getID());
        assertEquals("UC5gki32EO6PN_lhl46G1q4w", instance3.byView().get(0).getID());

        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: UCehf4850q1L3ng7s7L54ATA");
        System.out.println("Actual: " + instance4.byView().get(0).getID());
        assertEquals("UCehf4850q1L3ng7s7L54ATA", instance4.byView().get(0).getID());
        System.out.println("Successful");
    }

    @Test
    public void testByLike() {
        System.out.println("test byLike method");

        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: UCe_3CoEeinvPMze2u_aENBg");
        System.out.println("Actual: " + instance2.byLike().get(0).getID());
        assertEquals("UCe_3CoEeinvPMze2u_aENBg", instance2.byLike().get(0).getID());

        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: UC5gki32EO6PN_lhl46G1q4w");
        System.out.println("Actual: " + instance3.byLike().get(0).getID());
        assertEquals("UC5gki32EO6PN_lhl46G1q4w", instance3.byLike().get(0).getID());

        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: UCehf4850q1L3ng7s7L54ATA");
        System.out.println("Actual: " + instance4.byLike().get(0).getID());
        assertEquals("UCehf4850q1L3ng7s7L54ATA", instance4.byLike().get(0).getID());
        System.out.println("Successful");
    }

    @Test
    public void testByDislike() {
        System.out.println("test byDislike method");

        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: UCe_3CoEeinvPMze2u_aENBg");
        System.out.println("Actual: " + instance2.byDislike().get(0).getID());
        assertEquals("UCe_3CoEeinvPMze2u_aENBg", instance2.byDislike().get(0).getID());

        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: UCXoDvkmiyy57LOU7E6saINw");
        System.out.println("Actual: " + instance3.byDislike().get(0).getID());
        assertEquals("UCXoDvkmiyy57LOU7E6saINw", instance3.byDislike().get(0).getID());

        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: UCehf4850q1L3ng7s7L54ATA");
        System.out.println("Actual: " + instance4.byDislike().get(0).getID());
        assertEquals("UCehf4850q1L3ng7s7L54ATA", instance4.byDislike().get(0).getID());
        System.out.println("Successful");
    }

    @Test
    public void testByComment() {
        System.out.println("test byComment method");

        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: UCPckaTvXvCmfCSZhFIIhi0g");
        System.out.println("Actual: " + instance2.byComment().get(0).getID());
        assertEquals("UCPckaTvXvCmfCSZhFIIhi0g", instance2.byComment().get(0).getID());

        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: UC7lxhDFfw0jbfr0K8W3Ydmw");
        System.out.println("Actual: " + instance3.byComment().get(0).getID());
        assertEquals("UC7lxhDFfw0jbfr0K8W3Ydmw", instance3.byComment().get(0).getID());

        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: UCehf4850q1L3ng7s7L54ATA");
        System.out.println("Actual: " + instance4.byComment().get(0).getID());
        assertEquals("UCehf4850q1L3ng7s7L54ATA", instance4.byComment().get(0).getID());
        System.out.println("Successful");
    }

    @Test
    public void testByDescription() {
        System.out.println("test byDescription method");

        System.out.println("Testing the file: " + fileName2);
        System.out.println("Expected: UC1DeG8ZTab89_XNNqWxlDqA");
        System.out.println("Actual: " + instance2.byDescription().get(0).getID());
        assertEquals("UC1DeG8ZTab89_XNNqWxlDqA", instance2.byDescription().get(0).getID());

        System.out.println("Testing the file: " + fileName3);
        System.out.println("Expected: UCq19-LqvG35A-30oyAiPiqA");
        System.out.println("Actual: " + instance3.byDescription().get(0).getID());
        assertEquals("UCq19-LqvG35A-30oyAiPiqA", instance3.byDescription().get(0).getID());

        System.out.println("Testing the file: " + fileName4);
        System.out.println("Expected: UCehf4850q1L3ng7s7L54ATA");
        System.out.println("Actual: " + instance4.byDescription().get(0).getID());
        assertEquals("UCehf4850q1L3ng7s7L54ATA", instance4.byDescription().get(0).getID());
        System.out.println("Successful");
    }
}
