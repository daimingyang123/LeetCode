package com.mingyangdai;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;


public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		File dir = new File("/usr/local/devtools/dmelt/lib/");
		main.ergodic(dir);
		
		
	}
	
	public void ergodic(File dir) {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				ergodic(files[i]);
			} else {
				if (files[i].getName().endsWith("jar")) {
					File target = new File("/Users/daimingyang/Desktop/jar/" + files[i].getName());
					try {
						Files.move(files[i], target);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}