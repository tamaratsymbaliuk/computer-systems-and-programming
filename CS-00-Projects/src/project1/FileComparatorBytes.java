package project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileComparatorBytes {
    public boolean compareFiles(String file1, String file2) throws IOException {
        try (InputStream is1 = new FileInputStream(file1);
             InputStream is2 = new FileInputStream(file2)) {
            int data1, data2;
            while ((data1 = is1.read()) != -1 && (data2 = is2.read()) != -1) {
                if (data1 != data2) return false;
            }
            // Check if both files have reached the end
            return is1.read() == -1 && is2.read() == -1;
        }
    }
}
