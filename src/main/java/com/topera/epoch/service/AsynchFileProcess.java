package com.topera.epoch.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;

public class AsynchFileProcess {

    @Asynchronous
	public static void processFile(AmazonS3 s3,String bucketName,File ifile) throws ZipException, IOException, FileNotFoundException {

				ZipFile zipFile = new ZipFile(ifile);
		Enumeration<?> enu = zipFile.entries();
		while (enu.hasMoreElements()) {
			ZipEntry zipEntry = (ZipEntry) enu.nextElement();

			String name = zipEntry.getName();
			
			File file = new File(name);
			if (name.endsWith("/")) {
				file.mkdirs();
				continue;
			}

			File parent = file.getParentFile();
			if (parent != null) {
				parent.mkdirs();
			}
			if (file.getName().contains("txt")) {
				InputStream is = zipFile.getInputStream(zipEntry);
				FileOutputStream fos = new FileOutputStream(file);

				byte[] bytes = new byte[1024];
				int length;
				while ((length = is.read(bytes)) >= 0) {
					fos.write(bytes, 0, length);
				}
				String key = file.getName().split("/")[file.getName().split("/").length - 1];

				System.out.println("Uploading a new object to S3 from a file\n");
				s3.putObject(new PutObjectRequest(bucketName, key, file));
         		is.close();
				fos.close();
				
			}

		}
		zipFile.close();

		ifile.delete();
	}

}
