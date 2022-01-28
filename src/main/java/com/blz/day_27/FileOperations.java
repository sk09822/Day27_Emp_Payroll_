package com.blz.day_27;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class FileOperations {
    public static String myFolder = "MyFiles";

    public void checkFileOperations() throws IOException, IOException {

        //check file exists or not
        Path filePath = Paths.get(myFolder+"\\sample.txt");
        Path folderPath = Paths.get(myFolder + "\\Sandip");

        //delete file and check file not exists
        if(Files.exists(filePath)) {

            FileUtils.deleteQuietly(filePath.toFile());
            System.out.print("\nFile deleted");
        }

        //create file if it does not exists
        if(Files.exists(filePath)) {
            System.out.print("File exists");
        }
        else {
            try {
                Files.createFile(filePath);
                System.out.print("\nFile created");
            }catch(IOException e) {
                System.out.print("File not created");
            }
        }

        //create folder if it does not exist
        if(Files.notExists(folderPath)) {

            Files.createDirectories(folderPath);
            System.out.print("Directory created");
        }

        //create multiple files at a time
        IntStream.range(1,5).forEach(count -> {

            Path tempFiles = Paths.get(myFolder+"\\sample" + count);
            if(Files.notExists(tempFiles)) {
                try {
                    Files.createFile(tempFiles);
                    System.out.println("sample"+ count + " File created");
                }catch(IOException e) {
                    System.out.print("File not created");
                }

            }
        });

        Path myFolderPath = Paths.get(myFolder);
        //List Files with extension
        Files.list(myFolderPath).filter(Files::isRegularFile).forEach(System.out::println);

        //List Files with Directories as well as Files with Extension
        Files.newDirectoryStream(myFolderPath).forEach(System.out::println);

        Files.newDirectoryStream(myFolderPath, path -> path.toFile().isFile() && path.toString().startsWith("sample"))
                .forEach(System.out::println);
    }
}
