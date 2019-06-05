package lk.ijse.absd.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/employee")
public class UploadController
{
	private final String filepath = "D:/uploads/"; //saved uploads
	
	@RequestMapping(value = "uploaddata", method = RequestMethod.POST)
	public ResponseEntity<String> uploadDataFile(
	@RequestParam(value = "file", required = true) MultipartFile file )
	{
		System.out.println("ResponseEntity<String> uploadDataFile" );
	   if ( file != null )
	   {
	     File convFile = new File( filepath+file.getOriginalFilename() );
	     try
	     {
	       convFile.createNewFile();
	       FileOutputStream fos = new FileOutputStream( convFile );
	       fos.write( file.getBytes() );
	       fos.close();
	       System.out.println("Your File Name is : " + convFile.getName());
	     }
	     catch ( FileNotFoundException e )
	     {
	    	 System.out.println( e );
	     }
	     catch ( IOException e )
	     {
	    	 System.out.println( e );
	     }
	     return new ResponseEntity<String>( HttpStatus.OK );
	   }
	   else
	   {
	     return new ResponseEntity<String>( HttpStatus.NOT_FOUND );
	   }
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<String> test(){
		System.out.println("Working");
		return new ResponseEntity<String>( HttpStatus.OK );
	}
	
}
