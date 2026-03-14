package propertyFileRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Exception {

		File file = new File(System.getProperty("user.dir")+"/datafiles/config.properties");
		FileInputStream fis= new FileInputStream(file);
		Properties config = new Properties();
		config.load(fis);
		String str = config.getProperty("browser");
		System.out.println(str);
		
		
	}

}
