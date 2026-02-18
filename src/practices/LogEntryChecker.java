package practices;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class LogEntryChecker {

    public static void main(String[] args) {

        // Provide folder path and search message here
        String folderPath = "D:\\Temp\\Customer doc\\spoicdr error\\2026_02_10_12_20_27_u_FuboOZTf60KvFiW\\u_Mkz8kTFxz21MA2I\\logs_20261101324633_roznxb\\logs";   // change this
        String searchMessage = "Traffic Reports GetSPOUsageStats for siteUrl";  // change this

        searchLogs(folderPath, searchMessage);
    }

    public static void searchLogs(String folderPath, String searchMessage) {

        Path folder = Paths.get(folderPath);

        // 🔹 Create new folder inside given folder
        Path outputFolder = folder.resolve("log_search_results");

        try {
            if (!Files.exists(outputFolder)) {
                Files.createDirectories(outputFolder);
            }
        } catch (IOException e) {
            System.err.println("Failed to create output folder");
            e.printStackTrace();
            return;
        }

        // 🔹 Output file inside new folder
        Path outputFile = outputFolder.resolve("log_search_output.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(outputFile,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            Files.list(folder)
                    .filter(Files::isRegularFile)
                    .forEach(file -> processFile(file, searchMessage, writer));

            System.out.println("Search completed.");
            System.out.println("Output file created at: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path file, String searchMessage, BufferedWriter writer) {

        String searchLower = searchMessage.toLowerCase();

        try (Stream<String> lines = Files.lines(file)) {

            lines.filter(line -> line.toLowerCase().contains(searchLower))
                    .forEach(line -> {
                        try {
                            writer.write(file.getFileName() + " : " + line);
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getFileName());
            e.printStackTrace();
        }
    }

}
