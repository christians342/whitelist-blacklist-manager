import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;


public class ListHandler {

     private String fileName;

    public ListHandler(String fileName) throws IOException {
        this.fileName = fileName;
        File myFile = new File(fileName);
        myFile.createNewFile();
    }

    public boolean contains(String url) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            Stream<String> result = stream.filter(line -> line.equals(url));
            return result.count() > 0;
        }
    }

    public void add(String url) throws IOException {
        List<String> urls = new ArrayList<String>();
        urls.add(url);
        Files.write(Paths.get(fileName), urls, APPEND);
    }

    public List<String> getUrls() throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public void remove(String url) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> result = stream.filter(line -> !line.contains(url)).collect(Collectors.toList());
            Files.write(Paths.get(fileName), result, TRUNCATE_EXISTING);
        }
    }
}
