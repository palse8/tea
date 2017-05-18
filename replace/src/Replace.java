import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Replace {

	public static void main(String[] args) {
		String resourceName = "path";
		String csvName = "replace.csv";

		Map<String, String> pathMap = new HashMap<>();
		Map<String, String> csvMap = new HashMap<>();

		ResourceReader rr = new ResourceReader();
		CSVReader csvr = new CSVReader();

		pathMap = rr.getResource(resourceName);
		csvMap = csvr.getCSV(csvName);

		replace(pathMap, csvMap);

	}

	private static void replace(Map<String, String> pathMap, Map<String, String> csvMap) {

		String ext = pathMap.get("ext");
		String inputPath = pathMap.get("inputpath");
		String outputPath = pathMap.get("outputpath");

		Path dir = Paths.get(inputPath);
		try (Stream<Path> stream = Files.walk(dir)) {
			stream
			.filter(entry -> entry.getFileName().toString().endsWith("." + ext))
			.forEach(s ->{

				//ファイルを読み込む
				FileReader fr;
				try {
					fr = new FileReader(s.getFileName().toString());
					
					BufferedReader br = new BufferedReader(fr);
					
					File outfile = new File(s.getFileName().toString());
					
					String out = s.getParent().toString().replaceAll(inputPath, outputPath) + "/" + outfile;
					
					PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(out)));

					System.out.println(outputPath + "/" + outfile);
					
					//読み込んだファイルを１行ずつ処理する
					String line;
					while ((line = br.readLine()) != null) {
						//区切り文字","で分割する

						for(Map.Entry<String, String> e : csvMap.entrySet()){
							String rep = line.replaceAll(e.getKey(), e.getValue());
							System.out.println(rep);
							pw.println(rep);
						}

					}
					pw.close();
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}


			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
