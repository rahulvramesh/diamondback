package com.topera.epoch.service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
	
	public static void putAwsData(File file){
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
		
		s3.putObject(bucketName,file.getName(), file);
        
        
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
	
	
public static void main(String args[]){
	//putAwsData(new File("/tmp/script/aws-sdk.js"));
	getScriptFiles();
}
}
