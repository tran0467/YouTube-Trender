/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

/**
 * This class represents the contents of a video
 */
public class YouTubeVideo {
    /**
     * The channel title of video
     */
    private String channel;
    /**
     * The published date of video
     */
    private String date;
    /**
     * The title of video
     */
    private String title;
    /**
     * The description of video
     */
    private String description;
    /**
     * The number of views of video
     */
    private int viewCount;

    /**
     * The number of likes of video
     */
    private int likeCount;

    /**
     * The number of dislikes of video
     */
    private int dislikeCount;

    /**
     * The number of comments of video
     */
    private int commentCount;

    /**
     * The id of video
     */
    private String id;

    /**
     * The constructor with parameters to create the new object for this class.
     *
     * @param channel     channel title of video
     * @param date        published date of video
     * @param title       title of video
     * @param description description of video
     * @param viewCount   the number of views of video
     * @param id          channel ID
     */
    public YouTubeVideo(String channel, String date, String title, String description, int viewCount, int likeCount, int dislikeCount, int commentCount, String id) {
        this.channel = channel;
        this.date = date;
        this.title = title;
        this.description = description;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.commentCount = commentCount;
        this.id = id;
    }

    /**
     * This method is to get the channel title of video.
     *
     * @return the channel title of video
     */
    public String getChannel() {
        return channel;
    }

    /**
     * This method is to get the published date of video
     * from the private variable.
     *
     * @return the published date of video
     */
    public String getDate() {
        return date;
    }

    /**
     * This method is to get the title of video
     * from the private variable
     *
     * @return the title of video
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method is to get the description of video
     * from the private variable
     *
     * @return the description of video
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method is to get the number of views of video
     * from the private variable
     *
     * @return the number of views of video
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * This method is to get the number of likes of video
     * from the private variable
     *
     * @return the number of likes of video
     */
    public int getLikeCount() {
        return likeCount;
    }

    /**
     * This method is to get the number of dislikes of video
     * from the private variable
     *
     * @return the number of dislikes of video
     */
    public int getDislikeCount() {
        return dislikeCount;
    }

    /**
     * This method is to get the number of comments of video
     * from the private variable
     *
     * @return the number of comments of video
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * This method is to get channel ID
     * from the private variable
     *
     * @return the channel ID
     */
    public String getID() {
        return this.id;
    }

    /**
     * This method is modify this object into String to print.
     *
     * @return the String with edited format
     */
    @Override
    public String toString() {
        return channel + ": " + title;
    }

}
