package com.example.szopa.poetry;

/**
 * Created by Szopa on 22/03/2016.
 */
public class Poem {
    private Source1 aSource1 = new Source1();
    private String poem = "";
    private String source = aSource1.getSource();

    public java.lang.String writePoem(int numberOfWords, int numberOfLines, int numberOfParagraphs) {
        // split the big source string into an array of word-length strings
        // (one or more space marks the splitting boundary)
        String[] sourceToWords = source.split("\\s+");
        for (int i = 0; i < sourceToWords.length; i++) {
            sourceToWords[i] = sourceToWords[i].replaceAll("[^\\w]", ""); // delete all non-word characters (. - , etc.)
        }

        // two loops for the sake of clarity
        // count all uppercase words in array
        int l = 0;
        for (int j = 0; j < sourceToWords.length; j++) {
            if (Character.isUpperCase(sourceToWords[j].charAt(0))) {
                l++;
            }
        }

        String[] upperCaseList = new String [l];
        // search for all uppercase words and add them to a separate array
        int m = 0;
        for (int j = 0; j < sourceToWords.length; j++) {
            if (Character.isUpperCase(sourceToWords[j].charAt(0))) {
                upperCaseList[m] = sourceToWords[j];
                m++;
            }
        }

        // print a poem using random elements from the array sourceToWords[]
        for (int i = 0; i < numberOfParagraphs; i++) {
            for (int j = 0; j < numberOfLines; j++) {
                if(numberOfWords > 0) {
                    int randomInitialWord = (int) (Math.random() * upperCaseList.length);
                    poem += upperCaseList[randomInitialWord] + " ";
                }
                for (int k = 0; k < numberOfWords - 1; k++) {
                    int randomWord = (int) (Math.random() * sourceToWords.length);
                    poem += sourceToWords[randomWord] + " ";
                }
                poem += "\n";
            }
            poem += "\n";
        }

        return poem;
    }

    }