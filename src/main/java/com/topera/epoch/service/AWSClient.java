package com.topera.epoch.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.FileCopyUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AWSClient {
	
	public static InputStream getAwsData(String filename){
		AWSCredentials creds = new AWSCredentials() {

			public String getAWSSecretKey() {
				// TODO Auto-generated method stub
				return "5VVtmI7vcecuVbw8JsG4uo2O1/9RwwLHrTT01Itz";
			}

			public String getAWSAccessKeyId() {
				// TODO Auto-generated method stub
				return "AKIAJCMYALI46A2DIPRQ";
			}
		};

		AmazonS3 s3 = new AmazonS3Client(creds);
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		s3.setRegion(usWest2);

		String bucketName = "unzipped-topera-bucket";
		S3Object object = s3.getObject(new GetObjectRequest(bucketName, filename));
        InputStream objectData = object.getObjectContent();
        
        return objectData;
	}
	
	public static InputStream getAwsData(String filename,String bucketName){
		AWSCredentials creds = new AWSCredentials() {

			public String getAWSSecretKey() {
				// TODO Auto-generated method stub
				return "5VVtmI7vcecuVbw8JsG4uo2O1/9RwwLHrTT01Itz";
			}

			public String getAWSAccessKeyId() {
				// TODO Auto-generated method stub
				return "AKIAJCMYALI46A2DIPRQ";
			}
		};

		AmazonS3 s3 = new AmazonS3Client(creds);
		Region usWest2 = Region.getRegion(Regions.US_WEST_1);
		s3.setRegion(usWest2);
		System.out.println("AWSClient.getAwsData():fileName "+filename+ " bucket name"+bucketName);

		S3Object object = s3.getObject(new GetObjectRequest(bucketName, filename));
        InputStream objectData = object.getObjectContent();
        try {
			System.out.println("AWSClient.getAwsData()"+objectData.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return objectData;

	}
	
	public static void putAwsData(File file,String bucketName){
		AWSCredentials creds = new AWSCredentials() {

			public String getAWSSecretKey() {
				// TODO Auto-generated method stub
				return "5VVtmI7vcecuVbw8JsG4uo2O1/9RwwLHrTT01Itz";
			}

			public String getAWSAccessKeyId() {
				// TODO Auto-generated method stub
				return "AKIAJCMYALI46A2DIPRQ";
			}
		};

		AmazonS3 s3 = new AmazonS3Client(creds);
		Region usWest2 = Region.getRegion(Regions.US_WEST_1);
		s3.setRegion(usWest2);

		
		
		s3.putObject(bucketName,file.getName().split("\\.")[0], file);
        
        
	}
	
	public static Object[] getScriptFiles(){
		List<String[]> scriplist = new ArrayList<String[]>();
		AWSCredentials creds = new AWSCredentials() {

			public String getAWSSecretKey() {
				// TODO Auto-generated method stub
				return "5VVtmI7vcecuVbw8JsG4uo2O1/9RwwLHrTT01Itz";
			}

			public String getAWSAccessKeyId() {
				// TODO Auto-generated method stub
				return "AKIAJCMYALI46A2DIPRQ";
			}
		};

		AmazonS3 s3 = new AmazonS3Client(creds);
		//Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		//s3.setRegion(usWest2);

		String bucketName = "analysis-rnd-scripts";
		ObjectListing olist = s3.listObjects(bucketName);
		
		for (S3ObjectSummary objectSummary : 
			olist.getObjectSummaries()) {
			String[] script = {objectSummary.getKey()};
			scriplist.add(script);
		}
		
		return scriplist.toArray();
		
		
		
	}
	
	public static void saveFileFromS3(String filename,String bucketName, String outputFolder){
		try {
			FileOutputStream fout = new FileOutputStream(new File(outputFolder+"/"+filename));
			InputStream is = AWSClient.getAwsData(filename,bucketName);
			byte[] buff = new byte[is.available()];
			is.read(buff);
			fout.write(buff);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
public static void main(String args[]){
	System.out.println("AWSClient.main()"+new Date());
	SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
	try {
		System.out.println("AWSClient.main()"+sdf1.parse("12-19-2001"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	//putAwsData(new File("/Users/arupbanerjee/downloads/2002-0186_20151111A_ep2_LA_Session_88_Information.txt-OUTPUT.txt"),"unzipped-topera-bucket");
//	try {
//		
//		FileOutputStream fout = new FileOutputStream(new File("/tmp/2002-0186_20151111A_ep2_LA_Session_87_Information-algorithm.txt"));
//		InputStream is = AWSClient.getAwsData("2002-0186_20151111A_ep2_LA_Session_87_Information-algorithm.txt");
//		FileCopyUtils.copy(is, fout);
//		
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//	getScriptFiles();
}
}

