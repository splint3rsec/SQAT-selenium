import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfParser {

	private Properties properties;
	private final String filePath = "conf/variables.properties";


	public Properties readConfigurationFile() throws IOException{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
                return properties;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("variables.properties not found at " + filePath);
		}
		return null;
	}
}