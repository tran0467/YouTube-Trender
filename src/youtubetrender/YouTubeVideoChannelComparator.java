/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.Comparator;

/**
 * This class implements Comparator interface
 * to order the objects of user-defined class by channel title.
 */
public class YouTubeVideoChannelComparator implements Comparator<YouTubeVideo> {
    /**
     * This method is to compare two object by channel title.
     *
     * @param o1 the first object
     * @param o2 the second object
     * @return the value of comparision
     */
    @Override
    public int compare(YouTubeVideo o1, YouTubeVideo o2) {
        return o1.getChannel().compareTo(o2.getChannel());
    }

}
