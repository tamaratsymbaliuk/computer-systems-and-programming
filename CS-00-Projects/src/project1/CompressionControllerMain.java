package project1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CompressionControllerMain {
    public static void main(String[] args) {
        Compressor compressor = new Compressor();
        Decompressor decompressor = new Decompressor();
        FileComparatorBytes comparator = new FileComparatorBytes();

        try {
            String inputFile = new String(Files.readAllBytes(Paths.get("data/test.txt")));
            compressor.compress(inputFile, "output.sc");

            // Read the compressed data
            String compressedData = new String(Files.readAllBytes(Paths.get("output.sc")));
            // Decompress the compressed data
            decompressor.decompress(compressedData, "readable.txt");
            // Compare the original input and the decompressed output
            boolean areFilesIdentical = comparator.compareFiles("data/test.txt", "readable.txt");
            System.out.println("Are original and decompressed files identical? " + areFilesIdentical);
        } catch (IOException e) {
            System.err.println("Error during processing: " + e.getMessage());
        }
    }
}
