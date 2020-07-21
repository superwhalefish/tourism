package com.ly.spring.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

@Component
public class FreeSpace {

	public static Map<String, String> getAllDrive() {

		Map<String, String> map = new TreeMap<String, String>();

		File[] roots = File.listRoots();
		double unit = Math.pow(1024, 3);

		for (int i = 0; i < roots.length; i++) {

			String hd = roots[i].getPath();

			double freespace = roots[i].getFreeSpace() / unit;

			freespace = Math.ceil((freespace * 10)) / 10;

			map.put(hd, String.valueOf(freespace));
		}

		return map;
	}

	public static Map<String, Integer> getDriveByReg(String f) {
		File file = new File(f);
		long totalSpace = file.getTotalSpace();
		long freeSpace = file.getFreeSpace();
		long usedSpace = totalSpace - freeSpace;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("all", (int) (totalSpace / 1024 / 1024 / 1024));
		map.put("free", (int) (totalSpace / 1024 / 1024 / 1024));
		map.put("use", (int) (usedSpace / 1024 / 1024 / 1024));
		System.out.println("总空间大小 : " + totalSpace / 1024 / 1024 / 1024 + "G");
		System.out.println("剩余空间大小 : " + freeSpace / 1024 / 1024 / 1024 + "G");
		System.out.println("已用空间大小 : " + usedSpace / 1024 / 1024 / 1024 + "G");
		return map;
	}

}
