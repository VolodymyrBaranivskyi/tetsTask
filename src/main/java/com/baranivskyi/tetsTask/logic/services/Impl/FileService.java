package com.baranivskyi.tetsTask.logic.services.Impl;

import com.baranivskyi.tetsTask.model.entities.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileService {

    public void writeToFile(Response response) {

        try {
            File file = new File("testFile.txt");

            if (file.createNewFile()) {
                FileWriter myWriter = new FileWriter(file);

                myWriter.write(writeHeader());
                myWriter.append("\n");
                response.getComments().forEach(comment -> {
                    StringBuilder rowsBuilder = new StringBuilder();
                    rowsBuilder.append(comment.getId() + " | ");
                    rowsBuilder.append(comment.getBody() + "| ");
                    rowsBuilder.append(comment.getPostId() + "| ");
                    rowsBuilder.append(comment.getUser().getUserName().substring(0, 1).toUpperCase()
                            + comment.getUser().getUserName().substring(1) + " | ");
                    rowsBuilder.append(comment.getUser().getUserName() + " | ");
                    rowsBuilder.append(toDateFormat() + " \n");

                    try {
                        myWriter.append(rowsBuilder);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String writeHeader() {
        return "id | body | postId | username | updatedAt";
    }

    public String toDateFormat(){

        SimpleDateFormat formatter = new SimpleDateFormat("d-m-Y H:m:s");
        return formatter.format(new Date());
    }

}
