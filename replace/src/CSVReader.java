import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {

	public Map<String, String> getCSV(String csvName) {
		
		Map<String, String> csvMap = new HashMap<>();
		
		try {
            //ファイルを読み込む
            FileReader fr = new FileReader(csvName);
            BufferedReader br = new BufferedReader(fr);

            //読み込んだファイルを１行ずつ処理する
            String line;
            while ((line = br.readLine()) != null) {
                //区切り文字","で分割する
                String[] str = line.split(",");
                
                if(str.length == 2){
                	csvMap.put(str[0], str[1]);
                }

            }

            //終了処理
            br.close();

        } catch (IOException ex) {
            //例外発生時処理
            ex.printStackTrace();
        }

		return csvMap;
	}

}
