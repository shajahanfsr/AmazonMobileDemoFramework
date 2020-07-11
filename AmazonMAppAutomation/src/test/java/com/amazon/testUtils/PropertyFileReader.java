package com.amazon.testUtils;

import java.io.*;
import java.util.*;

public class PropertyFileReader {

	/**
	 * Properties.
	 */
	public static Properties ObjRepoProp;
	public static Properties TextProp;

	/**
	 * Load Property File.
	 * 
	 **/
	public static void loadProprtyFile() {

		ObjRepoProp = new Properties();
		try {
			ObjRepoProp.load(new FileInputStream(
					System.getProperty("user.dir") + "/AmazonMAppAutomation/Resouces/ObjectRepo.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
