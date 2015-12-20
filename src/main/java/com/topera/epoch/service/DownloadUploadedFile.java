package com.topera.epoch.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class DownloadUploadedFile {

 public static void main(String[] args) throws IOException {
  String existingBucketName = "diamondback-epocs-zip";
  String keyName = "/"+"";
  
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
  
  GetObjectRequest request = new GetObjectRequest(existingBucketName,
    keyName);
  S3Object object = s3Client.getObject(request);
  InputStream objectContent = object.getObjectContent();
  IOUtils.copy(objectContent, new FileOutputStream("/tmp/test.jpg"));

 }
 
 
 
 
 
}