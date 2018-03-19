/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bsenac.cafein_bot;

import java.util.ArrayList;

/**
 *
 * @author vixa
 */
public class randomWord {

    /**
     * Process the random words
     *
     * @param message the command line
     * @return
     */
    public static String processRandomWord(String message) {
        System.out.println(message);
        final String sentenceDelimitor = "\"";
        ArrayList<String> words = Category.divCommand(message);
        ArrayList<String> sentencesList = isolateSentences(words, sentenceDelimitor);
        return randomWord(sentencesList);
    }

    /**
     * Isolate sentences from a line, with a delimitor, or keep a word alone if
     * it is not in a sentance
     *
     * @param words the line of words to analyse
     * @param sentenceDelimitor the delimitor of a sentance
     */
    static ArrayList<String> isolateSentences(ArrayList<String> words, final String sentenceDelimitor) {
        ArrayList<String> sentencesList = new ArrayList<>();
        boolean inASentence = false;
        StringBuilder sentence = new StringBuilder();
        for(String word: words){
            if(inASentence || word.startsWith(sentenceDelimitor)){
                inASentence = true;
                sentence.append(word);
                if(word.startsWith(sentenceDelimitor)){
                    sentence.deleteCharAt(0);
                }
                if(!word.endsWith(sentenceDelimitor)){
                    sentence.append(" ");
                }
                if(word.endsWith(sentenceDelimitor)){
                    sentence.deleteCharAt(sentence.length()-1);
                    inASentence = false;
                    sentencesList.add(sentence.toString());
                    sentence.delete(0, sentence.length());
                }
            }else{
                sentencesList.add(word);
            }
        }
        
        return sentencesList;
    }

    /**
     * Choose a random word in the command line
     *
     * @param message the command line
     * @return the word choosen
     */
    static String randomWord(ArrayList<String> words) {
        int value = Roll.random(words.size() - 1);
        return words.get(value);
    }
}
