import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTestMain2 {

	static String name = null;
	
	public static void main(String[] args) throws IOException {
		
    		MyTestMain2 myTestMain2 = new MyTestMain2();
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String inputStr = scanner.nextLine();
			String name = inputStr.split(" ")[0];
			String path = inputStr.split(" ")[1];
			
			do {
				name = myTestMain2.call(name, path);
			} while (name != null);
		}
	}
	
	private String call(String callName, String callPath) throws IOException {
		
		List<String> list = MyUtils.readLineOfFile(callName);
		String result = null;
		
		for(int i = 0 ; i<list.size() ; i++) {
			String path = proxyList.get(i).split("#")[0];
			String type = proxyList.get(i).split("#")[1];
			
			if(path.equals(callPath)) { //Call한 Path 와 찾은Path 가 동일하면
				if(type.startsWith("Service")) { //type : 서비스 : 서비스호출
					callService(type);
				}else if(type.startsWith("Proxy")) { //type : Proxy : Proxy호출
					result = type;
					break;
				}
			}
		}
		return result;
	}
	
	private void callService(String type) throws IOException {
		List<String> list = MyUtils.readLineOfFile(type);
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}
}
