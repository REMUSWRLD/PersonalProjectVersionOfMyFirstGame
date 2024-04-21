package details.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        if(appendFile){
            try (PrintWriter dataOutput = new PrintWriter(new FileWriter(filename, true))) {
                dataOutput.println(contents);
            } catch (IOException e) {
                throw new FileStorageException("Cannot open the file for writing. ");
            }
        } else {
            File dataFile = new File(filename);
            try (PrintWriter dataOutput = new PrintWriter(new FileWriter(filename))) {
                dataOutput.println(contents);
            } catch (IOException e) {
                throw new FileStorageException("Cannot open the file for writing. ");
            }
        }
    }
    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> lines = new ArrayList<>();

        File dataFile = new File(filename);
        try (Scanner dataScanner = new Scanner(dataFile)) {
            while (dataScanner.hasNextLine()) {
                String currentLine = dataScanner.nextLine();
                lines.add(currentLine);
            }
        } catch (FileNotFoundException ex) {
            throw new FileStorageException("Cannot open the file for reading. ");
        }
        return lines;
    }

}
