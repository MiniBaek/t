import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MyTestMain1 {

	public static void main(String[] args) {

		while(true) {
			
			try {
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Input...");
				String inputStr = scanner.nextLine();
				List<String> inputStrList = MyUtils.readFilePerLine(inputStr);
				
				for(int i = 0 ; i<inputStrList.size() ; i++) {
					List<String> list = MyUtils.readFilePerLine(inputStrList.get(i));
					for(int j = 0 ; j<list.size() ; j++) {
						System.out.println(list.get(j));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
