/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.*;

/**
 * This class extends YouTubeDataParser class to create a List of indexing words used in the file.
 * This class contains other methods such as sorting and finding.
 */
public class YouTubeVideoIndexer {
    /**
     * create a List to store the words
     */
    private List<YouTubeVideo> items;
    private Map<String, YouTubeWordItem> words;

    public YouTubeVideoIndexer(List<YouTubeVideo> items) {
        this.items = items;
    }

    /**
     * This method is to find every word in title and description of each video
     * and store them into the List.
     * This method makes sure that no duplicated words.
     */
    public void index() {

        words = new HashMap<>();

        for (int p = 0; p < items.size(); p++) {

            YouTubeVideo item = items.get(p);

            String text = item.getTitle() + " " + item.getDescription();

            if (text != null) {
                Scanner ws = new Scanner(text);
                while (ws.hasNext()) {
                    String w = ws.next();

                    if(!Character.isLetter(w.charAt(w.length()-1))) {
                        w = w.substring(0, w.length() - 1);
                    }

                    if(w.length()>0) {
                        if (words.containsKey(w)) {

                            YouTubeWordItem tempWI = words.get(w);
                            tempWI.add(item);
                            words.put(w, tempWI);

                        } else {

                            YouTubeWordItem tempWI = new YouTubeWordItem(w);
                            tempWI.add(item);
                            words.put(w, tempWI);
                        }
                    }
                }
            }

        }
    }

    /**
     * This method is to sort the list of word by their occurrence counts.
     *
     * @return the sorted list
     */
    public List<YouTubeWordItem> getSortedYouTubeWordItems() {

        List<YouTubeWordItem> items = new ArrayList<>(words.values());

        Collections.sort(items);

        return items;
    }

    /**
     * This method is to find if the word is in the list or not.
     *
     * @param word The input word is wanted to find in the list
     * @return If the input word is in the list, print the word with its counts and videos. Otherwise, print the message "This word is not in the List".
     */
    public YouTubeWordItem getWordItem(String word) {
        return words.get(word);
    }

    public int getWordCount(String word) {
        return words.get(word).getCount();
    }
    
    public Set<YouTubeVideo> getWordVideos(String word)
    {
        return words.get(word).getVideos();
    }
}
