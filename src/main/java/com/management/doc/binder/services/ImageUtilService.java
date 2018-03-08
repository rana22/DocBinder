package com.management.doc.binder.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class ImageUtilService {
	
	public byte[] getThumbnail(byte[] image) {
		BufferedImage scaledImage = null;
		InputStream in = new ByteArrayInputStream(image);
		BufferedImage convertedImg;
		byte[] imageInByte = null;
		try {
			convertedImg = ImageIO.read(in);
			scaledImage = Scalr.resize(convertedImg, 200);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( scaledImage, "jpg", baos );
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return imageInByte;
	}

}
