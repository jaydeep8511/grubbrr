package com.grubbrr.init;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


/**
 * Define Common Webdriver
 */
public class Common {
	

// --------------------- Start New code ---------------------------


	
	public static void Screenshot(WebDriver driver, String className, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file1 = new File("./ScreenShots/" + dateOnly());
			File fileq = new File("./ScreenShots/" + dateOnly() + "/" + className);
			if (!file1.exists()) {
				if (!fileq.exists()) {
					if (file1.mkdir()) {
						if (fileq.mkdir()) {
							
							File file2 = new File("./ScreenShots/" + dateOnly() + "/" + className + "/" + time() + " "
									+ screenshotName + ".png");
							FileUtils.copyFile(source, file2);
							System.out.println("Directory is created!");
						}
					} else {
						System.out.println("Already created..");
					}
					
				}
			} else {
				File file2 = new File(
						"./ScreenShots/" + dateOnly() + "/" + className + "/" + time() + " " + screenshotName + ".png");
				FileUtils.copyFile(source, file2);
			}
			
			System.out.println("Screenshot taken...");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		
	}

	public static String randomStringNumber() throws Exception {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_HH_mm_ss");
		// get current date time with Date()
		Date date = new Date();
		// Now format the date
		String date1 = dateFormat.format(date);
		// System.out.println(date1);
		return date1;
	}
	public static String dateOnly() throws Exception {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// get current date time with Date()
		Date date = new Date();
		// Now format the date
		String date1 = dateFormat.format(date);
		// System.out.println(date1);
		return date1;
	}

	
	public static void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
			/*
			 * SeleniumInit.tim=SeleniumInit.tim+secs;
			 * System.out.println(" Pause wait --> "+SeleniumInit.tim);
			 */
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}

	private static String time() throws Exception {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss ");
		// get current date time with Date()
		Date date = new Date();
		// Now format the date
		String date1 = dateFormat.format(date);
		// System.out.println(date1);
		return date1;
	}

}
