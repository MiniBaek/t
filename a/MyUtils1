import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyUtils1 {

	public static List<String> readFilePerLine(String fileName) throws IOException{
		List<String> readStrings = new ArrayList<String>();

		//fileName = "C:\\workspace\\test\\" + fileName;
		//fileName = "./" + fileName;
		if(!fileName.endsWith(".txt")) {
			fileName = fileName + ".txt";
		}
    
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String str;
		while ((str = reader.readLine()) != null) {
			readStrings.add(str);
		}
		reader.close();

		return readStrings;
	}
}
