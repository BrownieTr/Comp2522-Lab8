package ca.bcit.comp2522.lab8;

import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;

public class CountryLab
{
    public static void main(String[] args) throws IOException
    {
        final Path path;
        final Path dirPath;
        final Path dataPath;
        final List<String> lines;
        final List<String> longerThan10;
        final List<String> shorterThan5;
        final List<String> startWithA;
        final List<String> endWithLand;
        final List<String> containUnited;
        final List<String> sortedNameAsc;
        final List<String> sortedNameDesc;
        final Set<Character> letterSet;
        final List<String> uniqueFirstLetter;

        path = Paths.get("src", "week8countries.txt");
        dirPath = Paths.get("src", "matches");
        dataPath = Paths.get("src", "matches", "data.txt");
        lines = Files.readAllLines(path);

        if (!Files.exists(dirPath)) {
            Files.createDirectory(dirPath);
        }

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        if (!Files.exists(dataPath)) {
            Files.createFile(dataPath);
        }

        longerThan10 = lines.stream()
                .filter(n -> n.length() > 10)
                .toList();
        Files.write(dataPath, List.of("Country names longer than 10 characters:"));
        Files.write(dataPath, longerThan10,  StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        shorterThan5 = lines.stream()
                .filter(n -> n.length() < 5)
                .toList();
        Files.write(dataPath, List.of("Country names shorter than 5 characters"), StandardOpenOption.APPEND);
        Files.write(dataPath, shorterThan5, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        startWithA = lines.stream()
                .filter(n -> n.charAt(0) == 'A')
                .toList();
        Files.write(dataPath, List.of("Starting with \"A\":"), StandardOpenOption.APPEND);
        Files.write(dataPath, startWithA, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        endWithLand = lines.stream()
                .filter(n -> n.endsWith("land"))
                .toList();
        Files.write(dataPath, List.of("Ending with \"land\":"), StandardOpenOption.APPEND);
        Files.write(dataPath, endWithLand, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        containUnited = lines.stream()
                .filter(n -> n.contains("United"))
                .toList();
        Files.write(dataPath, List.of("Containing \"United\":"), StandardOpenOption.APPEND);
        Files.write(dataPath, containUnited, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        sortedNameAsc = lines.stream()
                .sorted()
                .toList();
        Files.write(dataPath, List.of("Sorted Names (Ascending)"), StandardOpenOption.APPEND);
        Files.write(dataPath, sortedNameAsc, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        sortedNameDesc = lines.stream()
                .sorted()
                .toList()
                .reversed();
        Files.write(dataPath, List.of("Sorted Names (Descending)"), StandardOpenOption.APPEND);
        Files.write(dataPath, sortedNameDesc, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        letterSet = lines.stream()
                    .map(n -> n.charAt(0))
                    .collect(Collectors.toSet());
        uniqueFirstLetter = letterSet.stream()
                .map(String::valueOf)
                .toList();
        Files.write(dataPath, List.of("Unique First Letters:"), StandardOpenOption.APPEND);
        Files.write(dataPath, uniqueFirstLetter, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        for(String line : lines) {
            System.out.println(line);
        }

    }
}
