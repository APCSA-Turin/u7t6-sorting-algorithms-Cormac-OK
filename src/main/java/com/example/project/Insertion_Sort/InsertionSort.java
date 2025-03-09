package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<String> wordsA = new ArrayList<>();
        loadWordsInto(wordsA);
        ArrayList<String> wordsB = new ArrayList<>();
        loadWordsInto(wordsB);

        insertionSortWordList(wordsA);
        selectionSortWordList(wordsB);
        
    }

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int count = 0;
        for (int i = 1; i < elements.length; i ++){
            int iVal = elements[i];
            int index = i - 1;
            while(index >= 0 && elements[index] > iVal){
                count ++;
                elements[index + 1] = elements[index];
                index --;
            }
            elements[index + 1] = iVal;
        }
        System.out.println("Count: " + count);
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        int count = 0;
        for (int i = 0; i < elements.length-1; i ++){
            int min = elements[i + 1];
            int minIndex = i + 1;
            for (int j = i+1; j < elements.length; j ++){
                count ++;
                if (elements[j] < min){
                    min = elements[j];
                    minIndex = j;
                }
            }
            if(min < elements[i]){
                elements[minIndex] = elements[i];
                elements[i] = min;
            }
        }
        System.out.println("Count: " + count);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int count = 0;
        for (int i = 1; i < words.size(); i ++){
            String iVal = words.get(i);
            int index = i - 1;
            while(index >= 0 && words.get(index).compareTo(iVal) > 0){
                count ++;
                words.set(index + 1, words.get(index));
                index --;
            }
            words.set(index + 1, iVal);
        }
        System.out.println("Count: " + count);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int count = 0;
        for (int i = 0; i < words.size()-1; i ++){
            String min = words.get(i + 1);
            int minIndex = i + 1;
            for (int j = i+1; j < words.size(); j ++){
                count ++;
                if (words.get(j).compareTo(min) < 0){
                    min = words.get(j);
                    minIndex = j;
                }
            }
            if(min.compareTo(words.get(i)) < 0){
                words.set(minIndex, words.get(i));
                words.set(i, min);
            }
        }
        System.out.println("Count: " + count);
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

   
}