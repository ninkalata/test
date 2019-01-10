package com.demo.training;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.demo.training1.FileUpload;

@WebServlet("/upload")
@MultipartConfig

public class fileupload extends HttpServlet {
	// upload form in database
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		System.out.println(filePart);
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		InputStream fileContent = filePart.getInputStream();
		String mainvalidate = request.getParameter("type");
		String flevel = request.getParameter("level");

		try {
			//FileUpload.main(fileContent, fileName, flevel);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}