package youtubetrender;

import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This class is to create a object of WordItem
 */
public class YouTubeWordItem implements Comparable<YouTubeWordItem> {
    /**
     * The word in the list
     */
    private String word;
    /**
     * The occurrence number of the word
     */
    private int count;
    /**
     * using Set framework to create the unique of Video associated with words
     */
    private Set<YouTubeVideo> videos;

    /**
     * This constructor to create the new object YouTubeWordItem.
     *
     * @param word the word used in the name and description of videos
     */
    public YouTubeWordItem(String word) {
        this.word = word;
        count = 0;
        videos = new HashSet<YouTubeVideo>();
    }

    /**
     * This method to add the new video associated with the word into Set
     *
     * @param t the YouTubeVideo object
     */
    public void add(YouTubeVideo t) {
        count++;
        videos.add(t);
    }

    /**
     * This method is to get the number of word's occurrence from the private variable.
     *
     * @return the public number of word's occurrence
     */
    public int getCount() {
        return count;
    }


    public Set<YouTubeVideo> getVideos() {
        return videos;
    }

    /**
     * This method is to get the word from the private variable.
     *
     * @return the public word
     */
    public String getWord() {
        return word;
    }

    /**
     * This override method is to modify the String of object to print on screen.
     *
     * @return the String to print on screen
     */
    public String toString() {
        return word + "[" + count + "]";
    }

    /**
     * This override method is to compare objects in order to sort by the word's occurrence.
     *
     * @param t the YouTubeWordItem object
     * @return the value of comparision
     */
    public int compareTo(YouTubeWordItem t) {
        return t.count - this.count;
    }
}
