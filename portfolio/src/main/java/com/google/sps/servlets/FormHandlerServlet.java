package com.google.sps.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.util.UUID;

@WebServlet("/form-handler")
@MultipartConfig
public class FormHandlerServlet extends HttpServlet {

    /**
     * Handle POST method of form submission
     * @param request request from the client 
     * @param response response to the clinet
     * @throws IOException
     * @throws ServletException
     */
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    // Get the value entered in the form.
    String name = request.getParameter("form-name");
    String email = request.getParameter("form-email");
    String message = request.getParameter("form-message");

    // Get the file chosen by the user.
    Part filePart = request.getPart("image");
    String fileName = UUID.randomUUID().toString();
    InputStream fileInputStream = filePart.getInputStream();

    // Upload the file and get its URL
    String uploadedFileUrl = uploadToGCP(fileName, fileInputStream);

    // Print the value so you can see it in the server logs.
    System.out.println("Hi " + name + "! Thank you for your message as: " + message + "\n and I will get back to you ASAP");

    // Write the value to the response so the user can see it.
    response.getWriter().println("Hi " + name + "! Thank you for your message as: " + message + "\n and I will get back to you ASAP");
    response.getWriter().println(email);

    // Redirect back to main page
    response.sendRedirect("http://dle-sps-summer22.appspot.com/");
  }
  /** 
   * Uploads a file to Google Cloud Storage and returns the uploaded file's URL. 
   * @param filename the name of the file to be uploaded
   * @param fileInputStream the read stream of the input file
 * @throws IOException
   * */
  private static String uploadToGCP(String fileName, InputStream fileInputStream) throws IOException {
    String projectId = "dle-sps-summer22";
    String bucketName = "dle-sps-summer22.appspot.com";
    Storage storage =
        StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    BlobId blobId = BlobId.of(bucketName, fileName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

    // creates temporary holding of input content
    byte[] input = new byte[fileInputStream.available()];
    fileInputStream.read(input);
    // Upload the file to Cloud Storage.
    Blob blob = storage.create(blobInfo, input);

    // Return the uploaded file's URL.
    return blob.getMediaLink();
  }
}