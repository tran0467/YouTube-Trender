/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.Comparator;

/**
 * This class implements Comparator interface
 * to order the objects of user-defined class by the number of views.
 */
public class YouTubeVideoLikeComparator implements Comparator<YouTubeVideo> {
    /**
     * This method is to compare two object by the number of views.
     *
     * @param o1 the first object
     * @param o2 the second object
     * @return the value of comparision
     */
    @Override
    public int compare(YouTubeVideo o1, YouTubeVideo o2) {
        return o1.getLikeCount() - o2.getLikeCount();
    }
}
