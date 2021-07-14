/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.Comparator;

/**
 * This class implements Comparator interface
 * to order the objects of user-defined class by published date.
 */
public class YouTubeVideoDateComparator implements Comparator<YouTubeVideo> {
    /**
     * This method is to compare two object by published date.
     *
     * @param o1 the first object
     * @param o2 the second object
     * @return the value of comparision
     */
    @Override
    public int compare(YouTubeVideo o1, YouTubeVideo o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
