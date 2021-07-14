/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParsingException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class has a parsing method and sorting methods.
 */
public class YouTubeDataParser {

    /**
     * This List named list to store the list of videos from JSON file.
     */
    private List<YouTubeVideo> list = new ArrayList<>();

    /**
     * This method can take a file name and extract a list
     * of videos from the given JSON file
     *
     * @param fileName the directory of JSON file
     * @return the List after parsing from the given JSON file
     * @throws YouTubeDataParserException if the file is not found or has an error to parse
     */
    public List<YouTubeVideo> parse(String fileName) throws YouTubeDataParserException {

        JsonReader jsonReader = null;

        try {
            //read data
            jsonReader = Json.createReader(new FileInputStream(fileName));
        } catch (FileNotFoundException fnfe) {
            throw new YouTubeDataParserException("File not found: " + fileName);
        }

        JsonObject jobj = null;
        try {
            jobj = jsonReader.readObject();
        } catch (JsonParsingException jpe) {
            throw new YouTubeDataParserException("Parsing exception: " + jpe.getMessage());
        }

        // read the values of the item field
        JsonArray items = jobj.getJsonArray("items");

        for (int i = 0; i < items.size(); i++) {
            JsonObject video = items.getJsonObject(i);
            JsonObject snippet = video.getJsonObject("snippet");

            // parsing to Youtube video
            String channelId = snippet.getString("channelId");
            String channelTitle = snippet.getString("channelTitle");
            String publishAt = snippet.getString("publishedAt");
            String title = snippet.getString("title");
            String description = snippet.getString("description");

            // parsing statistics
            JsonObject statistics = video.getJsonObject("statistics");
            int viewCount = Integer.valueOf(statistics.getString("viewCount"));
            int likeCount = 0;
            int dislikeCount = 0;
            if (statistics.get("likeCount") != null) {
                likeCount = Integer.valueOf(statistics.getString("likeCount"));
            }
            if (statistics.get("dislikeCount") != null) {
                dislikeCount = Integer.valueOf(statistics.getString("dislikeCount"));
            }
            int commentCount = Integer.valueOf(statistics.getString("commentCount"));

            YouTubeVideo ytv = new YouTubeVideo(channelTitle, publishAt, title, description, viewCount, likeCount, dislikeCount, commentCount, channelId);

            // add to the list 
            list.add(ytv);
        }

        return list;
    }


    /**
     * This method is to sort the video list by channel title
     * and print the sorted list on screen.
     */
    public List<YouTubeVideo> byChannel() {
        Collections.sort(list, new YouTubeVideoChannelComparator());
        return list;
    }

    /**
     * This method is to sort the video list by published date
     * and print the sorted list on screen.
     */
    public List<YouTubeVideo> byDate() {
        Collections.sort(list, new YouTubeVideoDateComparator());
        return list;
    }

    /**
     * This method is to sort the video list by number of views
     * and print the sorted list on screen.
     */
    public List<YouTubeVideo> byView() {
        Collections.sort(list, new YouTubeVideoViewComparator());
        return list;
    }

    /**
     * This method is to sort the video list by number of likes
     * and print the sorted list on screen.
     */
    public List<YouTubeVideo> byLike() {
        Collections.sort(list, new YouTubeVideoLikeComparator());
        return list;
    }

    /**
     * This method is to sort the video list by number of views
     * and print the sorted list on screen.
     */
    public List<YouTubeVideo> byDislike() {
        Collections.sort(list, new YouTubeVideoDislikeComparator());
        return list;
    }

    /**
     * This method is to sort the video list by number of views
     * and print the sorted list on screen.
     */
    public List<YouTubeVideo> byComment() {
        Collections.sort(list, new YouTubeVideoCommentComparator());
        return list;
    }

    /**
     * This method is to sort the video list by length of description
     * and print the sorted list on screen.
     */
    public List<YouTubeVideo> byDescription() {
        Collections.sort(list, new YouTubeVideoDescriptionComparator());
        return list;
    }

    /**
     * This method is to print the list of videos
     *
     * @return the String of the video list
     */
    @Override
    public String toString() {
        return list.toString();
    }

}
