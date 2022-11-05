package wordOcurrenceJavaDoc;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/theRaven.txt"));

        // Empty map to store word and frequencies of all words
        Map<String, Integer> wordCounts = new HashMap<>();

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            // splitting line
            String[] words = line.split("[\\s.;,:!()\"]+");

            // iterate all words
            for (String word : words) {

                word = word.trim();

                if (word.length() > 0) {

                    if (wordCounts.containsKey(word)) {
                        wordCounts.put(word, wordCounts.get(word) + 1);
                    } else {
                        wordCounts.put(word, 1);
                    }
                }
            }
        }

        // sorting wordCounts by frequency
        Map<String, Integer> sortedWords = wordCounts.entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // printing word and frequencies of all words
        int g = -1;
        while (g < 0)
        {
            String input = JOptionPane.showInputDialog("Please introduce your name to start the program");
            if (input.length() > 0) {
                g++;
                System.out.println("Thank you, check the console to see the word ocurrence");
            }else
                System.out.println("Error: No input by the user");
        }
        System.out.printf("%-20s%15s\n", "Word", "Frequency");

        System.out.printf("%-20s%15s\n", "====", "=========");

        for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {

            System.out.printf("%-20s%10s\n", entry.getKey(), entry.getValue());
        }

        bufferedReader.close();
    }

}