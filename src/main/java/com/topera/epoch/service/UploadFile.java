package com.topera.epoch.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

public class UploadFile {

 public static void main(String[] args) throws IOException {
  String existingBucketName = "diamondback-epocs-zip";
  String keyName = "test.zip";
  
  String filePath = "/tmp/test.zip";
  String amazonFileUploadLocationOriginal=existingBucketName+"/";


  AWSCredentials creds = new AWSCredentials() {
		
		public String getAWSSecretKey() {
			// TODO Auto-generated method stub
			return "yhCmRfoqgDPmrV6s1Fb/mk3woU67h5LfMVRICX10";
		}
		
		public String getAWSAccessKeyId() {
			// TODO Auto-generated method stub
			return "AKIAJCNREYL7KSUNFYEA";
		}
	};

  AmazonS3 s3Client = new AmazonS3Client(creds);

  FileInputStream stream = new FileInputStream(filePath);
  ObjectMetadata objectMetadata = new ObjectMetadata();
  PutObjectRequest putObjectRequest = new PutObjectRequest("diamondback-epocs-zip.s3.amazonaws.com/diamondback-epocs-zip", keyName, stream, objectMetadata);
  PutObjectResult result = s3Client.putObject(putObjectRequest);
  System.out.println("Etag:" + result.getETag() + "-->" + result);

 }
 
}