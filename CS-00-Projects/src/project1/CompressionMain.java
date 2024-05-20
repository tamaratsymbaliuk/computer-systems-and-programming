package project1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CompressionMain {
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
            System.out.println("Origwinal file size: " + originalSize + " bytes");
            System.out.println("Compressed file size: " + compressedSize + " bytes");

            // Print the bytes of the compressed file
            byte[] compressedBytes = Files.readAllBytes(Paths.get(compressedFilePath));
            System.out.println("Compressed file bytes:");
            for (byte b : compressedBytes) {
                System.out.printf("%02x ", b);
            }
            System.out.println();

            // Decompress the compressed data
            decompressor.decompress(compressedFilePath, decompressedFilePath);

            // Compare the original input and the decompressed output
            boolean areFilesIdentical = comparator.compareFiles(inputFilePath, decompressedFilePath);
            System.out.println("Are original and decompressed files identical? " + areFilesIdentical);
        } catch (IOException e) {
            System.err.println("Error during processing: " + e.getMessage());
        }
    }
}
