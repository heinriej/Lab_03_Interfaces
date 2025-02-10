import javax.swing.*;
import java.io.*;
import java.util.*;

public interface Filter {
    boolean accept(Object x);
}

class ShortWordFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof String) {
            return ((String) x).length() < 5;
        }
        return false;
    }
}

class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            displayShortWords(file);
        }
    }

    private static void displayShortWords(File file) {
        Filter filter = new ShortWordFilter();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (filter.accept(word)) {
                    System.out.println(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}