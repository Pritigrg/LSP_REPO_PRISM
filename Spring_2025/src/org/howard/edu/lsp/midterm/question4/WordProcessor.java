package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
        private String sentence; // Stores the sentence to be processed

        // Constructor
        public WordProcessor(String sentence) {
            this.sentence = sentence;
        }

        // Method to find all longest words in the sentence
        public List<String> findLongestWords() {
            List<String> result = new ArrayList<String>();
            String[] words =  sentence.split(" ");
            int maxLength = 0;
            for (String word : words) {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                }
            }
            for (String word : words) {
                if (word.length() == maxLength) {
                    result.add(word);
                }
            }

            return result;
        }




}


