package com.ly.spring.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.dao.ImagesDao;
import com.ly.spring.dao.SceneryDao;
import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Images;
import com.ly.spring.entity.Scenery;
import com.ly.spring.utils.RandomUtil;
import com.ly.spring.utils.UploadFileUtil;

@Service
public class SceneryServiceImp implements SceneryService {
	@Autowired
	private SceneryDao sceneryDao;
	@Autowired
	private RandomUtil randomUtil;
	@Autowired
	private ImagesDao imagesDao;
	@Autowired
	private ImagesService imagesService;
	@Autowired
private UploadFileUtil uploadFileUtil;
	@Override
	public Map<String, Object> getScenery(Fenye fenye) {
		// TODO Auto-generated method stub
		List<Scenery> scenery = sceneryDao.getScenery(fenye);
		Integer sceneryCount = sceneryDao.getSceneryCount(fenye);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", sceneryCount);
		map.put("data", scenery);
		return map;
	}

	@Override
	public Integer editScenery(Scenery scenery) {
		// TODO Auto-generated method stub
		if ("已发布".equals(scenery.getPublishstate())) {
			scenery.setPublishtime(randomUtil.getNewTime());
		}
		if ("未发布".equals(scenery.getPublishstate())) {
			scenery.setUnpublishtime(randomUtil.getNewTime());
		}
		return sceneryDao.editScenery(scenery);
	}

	@Override
	@Transactional
	public Integer addScenery(Scenery scenery) {
		// TODO Auto-generated method stub
		String rand = randomUtil.getRand();
		scenery.setImgcode(rand);
		scenery.setUptime(randomUtil.getNewTime());
		return sceneryDao.addScenery(scenery);
	}

	@Override
	@Transactional
	public Integer delScenery(Integer id) {
		// TODO Auto-generated method stub
		//String selectImgcodeById = sceneryDao.selectImgcodeById(id);
		Scenery selectImgById = sceneryDao.selectSceneryById(id);
		File file = new File("E:\\images\\"+selectImgById.getSimg());
		uploadFileUtil.delImg(file);
	//	Integer delImgByImgCode = imagesDao.delImgByImgCode(selectImgById.getImgcode());
		imagesService.delImgByImgCode(selectImgById.getImgcode());
		
		
		return sceneryDao.delScenery(id);
	}

	@Override
	@Transactional
	public Map<String, Object> uploadSceneryImages(MultipartFile file, Integer id) {
		// TODO Auto-generated method stub
		Map<String, Object> uploadFile = uploadFileUtil.uploadFile(file);
		String url =(String)uploadFile.get("getUrl");
		Scenery scenery = new Scenery();
		scenery.setId(id);
		scenery.setSimg(url);
		sceneryDao.editScenery(scenery);
		String selectImgcodeById = sceneryDao.selectImgcodeById(id);
		Images images = new Images();
		images.setImgcode(selectImgcodeById);
		images.setImgurl(url);
		imagesDao.addImgs(images);
		return uploadFile;
	}

	@Override
	public List<Scenery> getSceneryAll() {
		// TODO Auto-generated method stub
		return sceneryDao.getSceneryAll();
	}

	@Override
	public List<Scenery> vgetSceneryByCid(String cid) {
		// TODO Auto-generated method stub
		return sceneryDao.vgetSceneryByCid(cid);
	}

	@Override
	public List<Scenery> vGetSceneryAll(Fenye fenye) {
		// TODO Auto-generated method stub
		return sceneryDao.getSceneryByFenye(fenye);
	}

}
