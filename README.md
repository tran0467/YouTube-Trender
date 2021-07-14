# Project YouTube Trender

## Introduction
On Youtube, users can also add a title and description to the videos and
by examining the contents of and detecting which words appear frequently across titles and
descriptions we can detect “trending topics.”

## Purpose
to design, implement, test, and document a command line application to analyse
the results of a YouTube search using the YouTube Data API: e.g. “Trending Topics” of YouTube
videos.

## Phases
1. Parse a YouTube video data string in into a YouTube video object
2. Sort Video objects by different features (e.g. title, channel title, views, date, etc.)
3. Index the list of videos for word usage across the title and description of the videos, aka “Trending Topics”
4. Graphical user interface development
5. JUnit Testing
6. Application description document

## Features
1. Show a list of videos by a json file path that can be choosen from the list or manually type
2. Show the video details when selecting any video in the list
3. Sort the video list by criteria including Channel, Date, View, Description length, Like, Dislike, and Comment
4. Show the list of words in title and description of all videos in the list with the number of occurrences from the highest to lowest (Note: Combine the word with and without symbols/special characters, e.g. make “twinkle” and “twinkle,” the same; and Remove all symbols / special characters stand alone such as “:”, “,”, “/”, “<”, etc)
5. When selecting any word, the list of videos that have that word will be shown in the Videos panel
6. Sort the list of videos that have that word by the above sorting criteria
7. Search any word and return that word with occurrence counts and the list of videos containing that word
8. The popup window displays error messages
