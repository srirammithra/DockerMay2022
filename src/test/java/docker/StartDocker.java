package docker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class StartDocker {

	//@BeforeSuite
	public void StartFile() throws IOException, InterruptedException {
		Runtime objRuntime = Runtime.getRuntime();
		objRuntime.exec("cmd /c start GridStart.bat");
		String varFilePath = "Output.txt";
		Thread.sleep(2000);
		boolean varFlag = false;
		Calendar objCalendar = Calendar.getInstance();
		objCalendar.add(Calendar.SECOND, 30);
		long varStop = objCalendar.getTimeInMillis();
		while (System.currentTimeMillis() < varStop) {
			if (varFlag) {
				break;
			}
			BufferedReader objBufferedReader = new BufferedReader(new FileReader(varFilePath));
			String varCurrentLine = objBufferedReader.readLine();
			while (varCurrentLine != null && !varFlag) {
				if (varCurrentLine.contains("Node has been added")) {
					varFlag = true;
					break;
				}
				varCurrentLine = objBufferedReader.readLine();
			}
			objBufferedReader.close();
		}
		Assert.assertTrue(varFlag);
		Thread.sleep(5000);
	}

}
