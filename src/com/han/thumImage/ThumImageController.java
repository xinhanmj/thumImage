package com.han.thumImage;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class ThumImageController {

	@RequestMapping("/uploadfiles")
	public String  thumImage(@RequestParam("image") CommonsMultipartFile file,HttpSession session,Map<String,Object> dataMap){
		String uploadPath="/upload";
		String realPath = session.getServletContext().getRealPath(uploadPath);
		
		String imageUrl=UploadUtils.uploadImage(file, uploadPath, realPath);//‘≠Õº
		String thumImageUrl=UploadUtils.ThumnailUtil(file, uploadPath, realPath);//Àı¬‘Õº
		
		dataMap.put("imageUrl", imageUrl);
		dataMap.put("thumImageUrl", thumImageUrl);
		return "/result";
		
	}
}
