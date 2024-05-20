package project1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Decompressor {
    public void decompress(String compressedFile, String decompressedFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(compressedFile))) {
            Map<Integer, String> codeToWordMap = new HashMap<>();
            StringBuilder decompressed = new StringBuilder();
            boolean readingMapping = true;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("Compressed Data:")) { // is used to distinguish between the two sections of the compressed file: the mapping section and the actual compressed data.
                    readingMapping = false;
                    continue;
                }

                if (readingMapping) {
                    if (line.startsWith("Mapping:") || line.isBlank()) {
                        continue;
                    }
                    String[] parts = line.split(": ", 2);
                    int code = Integer.parseInt(parts[0]);
                    String word = parts[1];
                    codeToWordMap.put(code, word);
                } else {
                    String[] codes = line.split("\\s+");
                    for (String codeStr : codes) {
                        if (!codeStr.isEmpty()) {
                            int code = Integer.parseInt(codeStr);
                            decompressed.append(codeToWordMap.get(code)).append(" ");
                        }
                    }
                    decompressed.append(System.lineSeparator());
                }
            }

            // Write decompressed data to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(decompressedFile))) {
                writer.write(decompressed.toString());
            }
        }
    }
}
