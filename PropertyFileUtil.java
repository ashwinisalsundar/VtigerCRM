package CommonUtils;
	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class PropertyFileUtil {
		
		public String getDataFromPropertyFile(String keyname) throws IOException {
			
			//Copy from Test1.java
			FileInputStream fis = new FileInputStream("src\\test\\resources\\LoginCredencials.properties");
			Properties p = new Properties();
			p.load(fis);
			String value = p.getProperty(keyname);
			
			return value;
		}
	}

