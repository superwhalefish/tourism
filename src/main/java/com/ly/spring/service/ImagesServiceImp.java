package com.ly.spring.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.dao.ImagesDao;
import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Images;
import com.ly.spring.entity.Scenery;
import com.ly.spring.utils.RandomUtil;
import com.ly.spring.utils.UploadFileUtil;

@Service
public class ImagesServiceImp implements ImagesService {
	@Autowired
	private ImagesDao imagesDao;
	@Autowired
	private RandomUtil randomUtil;

	@Autowired
	private UploadFileUtil uploadFileUtil;
	public Map<String,Object> getImages(Fenye fenye){
		List<Images> imgs = imagesDao.getImgs(fenye);
		Integer imgsCount = imagesDao.getImgsCount(fenye);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",imgsCount);
		map.put("data",imgs);
		return map;
		
	}


	@Override
	@Transactional
	public Integer delImgByid(Integer id) {
		// TODO Auto-generated method stub
		Images img=imagesDao.findImgById(id);
		File file = new File("E:\\expert\\images\\"+img.getImgurl());
		uploadFileUtil.delFile(file);
		return imagesDao.delImgByid(id);
	}

	
	@Override
	@Transactional
	public Map<String, Object> addImgs(MultipartFile file, String imgcode) {
		// TODO Auto-generated method stub
		System.out.println(file.getName());
		if(imgcode.length()>0) {
			Map<String, Object> uploadFile = uploadFileUtil.uploadFile(file);
			String url =(String)uploadFile.get("getUrl");
			System.out.println("url:"+url);
			Images images = new Images();
			images.setImgcode(imgcode);
			images.setImgurl(url);
			imagesDao.addImgs(images);
			System.out.println(uploadFile);
			return uploadFile;
			
		}
		Map<String, Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("msg", "");
		return map;
	}


	@Override
	public Integer editImage(Images images) {
		// TODO Auto-generated method stub
		return imagesDao.editImage(images);
	}


	@Override
	public List<Images> getlunbo() {
		// TODO Auto-generated method stub
		return imagesDao.getlunbo();
	}


	@Override
	@Async
	public Integer delImgByImgCode(String imgcode) {
		// TODO Auto-generated method stub
		List<Images> images=imagesDao.findImgByImgCode(imgcode);
		for(int i=0;i<images.size();i++) {
			File file = new File("E:\\expert\\images\\"+images.get(i).getImgurl());
			uploadFileUtil.delFile(file);
		}
		return imagesDao.delImgByImgCode(imgcode);
	}
}
