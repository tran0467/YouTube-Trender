/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

/**
 * This class is that extends Exception to indicate a parsing error.
 * The YouTubeDataParser should throw this exception when it
 * encounters an error during the parsing of a JSON file.
 */
public class YouTubeDataParserException extends Exception {
    /**
     * This constructor allows to input the error message
     * when catching the error during the parsing
     *
     * @param message message printed to show the error
     */
    YouTubeDataParserException(String message) {
        super(message);
    }
}
