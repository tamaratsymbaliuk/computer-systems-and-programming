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
            String inputFilePath = "data/test.txt";
            String compressedFilePath = "output.sc";
            String decompressedFilePath = "readable.txt";

            // Read the input file
            String inputFile = new String(Files.readAllBytes(Paths.get(inputFilePath)));
            // Compress the input file
            compressor.compress(inputFile, compressedFilePath);

            // Print sizes of the original and compressed files
            long originalSize = Files.size(Paths.get(inputFilePath));
            long compressedSize = Files.size(Paths.get(compressedFilePath));
            System.out.println("Original file size: " + originalSize + " bytes");
            System.out.println("Compressed file size: " + compressedSize + " bytes");

            // Optionally, print the contents of the compressed file
            String compressedData = new String(Files.readAllBytes(Paths.get(compressedFilePath)));
            System.out.println("Compressed data:\n" + compressedData);

            // Decompress the compressed data
            decompressor.decompress(compressedData, decompressedFilePath);

            // Compare the original input and the decompressed output
            boolean areFilesIdentical = comparator.compareFiles(inputFilePath, decompressedFilePath);
            System.out.println("Are original and decompressed files identical? " + areFilesIdentical);
        } catch (IOException e) {
            System.err.println("Error during processing: " + e.getMessage());
        }
    }
}
