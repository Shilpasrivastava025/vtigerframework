package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	/**
	 * this method is used for Concatenate to File data
	 * @author Shilpa
	 */
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream("./CommonsProperty.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
		
	}
	

}
