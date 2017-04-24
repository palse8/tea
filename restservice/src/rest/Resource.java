
package rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/rest")
public class Resource {
	
	@POST
	@Path("/upload")
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(
			@FormDataParam("upload") InputStream uploadedInputStream,
			@FormDataParam("upload") FormDataContentDisposition fileDetail) {

			String uploadedFileLocation = "/Users/-/Desktop/upload.zip";

			// save it
			writeToFile(uploadedInputStream, uploadedFileLocation);

			String output = "File uploaded to : " + uploadedFileLocation;

			return Response.status(200).entity(output).build();

		}

		// save uploaded file to new location
		private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

			try {
				OutputStream out = new FileOutputStream(new File(
						uploadedFileLocation));
				int read = 0;
				byte[] bytes = new byte[1024];

				out = new FileOutputStream(new File(uploadedFileLocation));
				while ((read = uploadedInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	
	@GET
	@Path("/download")
	public Response callDownload(@Context HttpServletResponse response){
		
		InputStream in = null;
		OutputStream out = null;
		
		File file = new File("/Users/-/Desktop/test.zip");
		
		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment; filename=download.zip"); 
		
		try {
			in = new FileInputStream(file);
			out = response.getOutputStream();
			
			byte[] b = new byte[1024];
			int len = 0;
			while((len = in.read(b)) != -1){
				out.write(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		
		return Response.ok().build();
	}

}
