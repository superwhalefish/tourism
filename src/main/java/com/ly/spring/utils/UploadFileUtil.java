package com.ly.spring.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.entity.Images;
import com.ly.spring.entity.Scenery;

@Component
public class UploadFileUtil {
	@Autowired
	private RandomUtil randomUtil;
	
	public Map<String,Object> uploadFile(MultipartFile file){
		String prefix = "";
		// 保存上传
		OutputStream out = null;
		InputStream fileInput = null;
		try {
			if (file != null) {
				String originalName = file.getOriginalFilename();
				prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
				String url = randomUtil.getRand() + "";
				String datemkdirs=randomUtil.getNewDate();
				String filepath = "E:\\expert\\images\\"+datemkdirs+"\\"+ url + "." + prefix;
//E:\eclipsework\LYTourism\src\main\webapp\images
				File files = new File(filepath);
				// 打印查看上传路径
				if (!files.getParentFile().exists()) {
					files.getParentFile().mkdirs();
				}
				file.transferTo(files);
				Map<String, Object> map2 = new HashMap<>();
				Map<String, Object> map = new HashMap<>();
				map.put("code", 0);
				map.put("msg", "");
				map.put("getUrl",datemkdirs+"/"+ url + "." + prefix);
				map2.put("src", "/images/"+ datemkdirs+"/"+ url + "." + prefix);
				map.put("data", map2);
				return map;
			}

		} catch (Exception e) {
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fileInput != null) {
					fileInput.close();
				}
			} catch (IOException e) {
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("msg", "");
		return map;
	}
	
	
	public Map<String,Object> uploadFileVideo(MultipartFile file){
		String prefix = "";
		// 保存上传
		OutputStream out = null;
		InputStream fileInput = null;
		try {
			if (file != null) {
				String originalName = file.getOriginalFilename();
				prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
				String url = randomUtil.getRand() + "";
				String datemkdirs=randomUtil.getNewDate();
				String filepath = "E:\\expert\\mp4\\"+datemkdirs+"\\"+ url + "." + prefix;
//E:\eclipsework\LYTourism\src\main\webapp\images
				File files = new File(filepath);
				// 打印查看上传路径
				if (!files.getParentFile().exists()) {
					files.getParentFile().mkdirs();
				}
				file.transferTo(files);
				Map<String, Object> map2 = new HashMap<>();
				Map<String, Object> map = new HashMap<>();
				map.put("code", 0);
				map.put("msg", "");
				map.put("getUrl",datemkdirs+"/"+ url + "." + prefix);
				map2.put("src", "/mp4/"+ datemkdirs+"/"+ url + "." + prefix);
				map.put("data", map2);
				return map;
			}

		} catch (Exception e) {
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fileInput != null) {
					fileInput.close();
				}
			} catch (IOException e) {
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("code", 1);
		map.put("msg", "");
		return map;
	}
	@Async
	public void delFile(File file) {
		file.delete();
	}
}
