package com.baranivskyi.tetsTask;

import com.baranivskyi.tetsTask.logic.services.Impl.CallServiceImpl;
import com.baranivskyi.tetsTask.logic.services.Impl.FileService;
import com.baranivskyi.tetsTask.model.entities.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TetsTaskApplication {

	public static void main(String[] args) {

		CallServiceImpl callService = new CallServiceImpl();
		FileService fileService = new FileService();

		Response response = new Response();
		URL url = null;
		try {
			url = new URL( "https://dummyjson.com/comments");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		response = callService.get(url, Response.class);
		fileService.writeToFile(response);



		System.out.println(response);
	}

}
