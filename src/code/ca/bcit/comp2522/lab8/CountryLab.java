package ca.bcit.comp2522.lab8;

import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
        final List<String> longestCountry;
        final List<String> shortestCountry;
        final List<String> upperCaseName = new ArrayList<>();
        final List<String> moreThan1Word;
        final List<String> countryWithCharacterCount;
        final List<String> containsZ;
        final List<String> longerThan3;

        final Map<String,Integer> characterCount = new HashMap<String,Integer>();

        final long lineCount;

        path = Paths.get("src", "week8countries.txt");
        dirPath = Paths.get( "matches");
        dataPath = Paths.get("matches", "data.txt");
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
        Files.write(dataPath, List.of("Country names starting with 'A':"), StandardOpenOption.APPEND);
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

        Files.write(dataPath, List.of("Number of Countries"), StandardOpenOption.APPEND);
        lineCount = Files.lines(path).count();
        String lineCounted = "" + lineCount;
        Files.write(dataPath, List.of(lineCounted), StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        Files.write(dataPath, List.of("Longest Country Name"), StandardOpenOption.APPEND);

        longestCountry = Collections.singletonList(lines.stream()
                                                        .max(Comparator.comparingInt(String::length))
                                                        .get());
        Files.write(dataPath, longestCountry, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        Files.write(dataPath, List.of("Shortest Country Name"), StandardOpenOption.APPEND);
        shortestCountry = Collections.singletonList(lines.stream()
                                                         .min(Comparator.comparingInt(String::length))
                                                         .get());
        Files.write(dataPath, shortestCountry, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        Files.write(dataPath, List.of("Country names in upper case"), StandardOpenOption.APPEND);
        for(String line : lines)
        {
            upperCaseName.add(line.toUpperCase());
        }
        Files.write(dataPath, upperCaseName, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        Files.write(dataPath, List.of("Countries with more than 1 word"), StandardOpenOption.APPEND);
        moreThan1Word = lines.stream()
                .filter(n -> n.contains(" "))
                .toList();
        Files.write(dataPath, moreThan1Word, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        Files.write(dataPath, List.of("Countries with their character count"), StandardOpenOption.APPEND);
        for(String line : lines)
        {
            characterCount.put(line.toLowerCase(), line.length());
        }
        countryWithCharacterCount = characterCount.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue() + " characters")
                                                  .toList();
        Files.write(dataPath, countryWithCharacterCount, StandardOpenOption.APPEND);
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        Files.write(dataPath, List.of("Does a Country contain the letter Z"), StandardOpenOption.APPEND);
        containsZ = lines.stream()
                             .filter(n -> n.contains("Z"))
                             .toList();
        if(!containsZ.isEmpty())
        {
            Files.write(dataPath, List.of("true"), StandardOpenOption.APPEND);
        } else
        {
            Files.write(dataPath, List.of("false"), StandardOpenOption.APPEND);
        }
        Files.write(dataPath, List.of(""), StandardOpenOption.APPEND);

        Files.write(dataPath, List.of("Are of the country names longer than 3 characters"), StandardOpenOption.APPEND);
        longerThan3 = lines.stream()
                           .filter(n -> n.length() > 3)
                .toList();
        if(!longerThan3.isEmpty())
        {
            Files.write(dataPath, List.of("true"), StandardOpenOption.APPEND);

        } else
        {
            Files.write(dataPath, List.of("false"), StandardOpenOption.APPEND);
        }

        for(String line : lines) {
            System.out.println(line);
        }

    }
}
