package com.han.thumImage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;

public class UploadUtils {
	/**
	 * …œ¥´‘≠Õº
	 * @param file
	 * @param uploadPath
	 * @param realPath
	 * @return
	 */
	public static String uploadImage(CommonsMultipartFile file,String uploadPath,String realPath){
		
		InputStream is=null;
		OutputStream out=null;
		try{
			is=file.getInputStream();
			String des=realPath+"/"+file.getOriginalFilename();
			out=new FileOutputStream(des);
			byte[] buff=new byte[1024];
			int len=0;
			while((len=is.read(buff))>0){
				out.write(buff);
			}
			System.out.println(des);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return uploadPath+"/"+file.getOriginalFilename();
	}
	
	/**
	 * Àı¬‘Õº
	 * @return
	 */
	public static String ThumnailUtil(CommonsMultipartFile file,String uploadPath,String realPath){
		
		try{
			String des=realPath+"/thum_"+file.getOriginalFilename();
			Thumbnails.of(file.getInputStream()).size(100, 100).toFile(des);
		}catch(Exception e){
			e.printStackTrace();
		}
		return uploadPath+"/thum_"+file.getOriginalFilename();
	}
}
