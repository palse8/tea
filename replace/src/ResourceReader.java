import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ResourceReader {

	public Map<String, String> getResource(String resourceName) {

		Map<String, String> pathMap = new HashMap<>();
		
		ResourceBundle rb = ResourceBundle.getBundle(resourceName);
		
		pathMap.put("inputpath", rb.getString("inputpath"));
		pathMap.put("outputpath", rb.getString("outputpath"));
		pathMap.put("ext", rb.getString("ext"));
		
		return pathMap;
	}

}
