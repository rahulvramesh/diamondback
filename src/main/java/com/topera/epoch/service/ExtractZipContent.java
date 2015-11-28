package com.topera.epoch.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;

public class ExtractZipContent {
	
	

	public static void main(String[] args) {

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

		System.out.println("===========================================");
		System.out.println("Getting Started with Amazon S3");
		System.out.println("===========================================\n");



			

			File folder = new File("/tmp/topera/");
			for (File ifile : folder.listFiles()) {
				
				try {
					AsynchFileProcess.processFile(s3,bucketName,ifile);
					ifile.delete();
				} catch (ZipException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
	}
	


			

	
}