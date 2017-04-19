package Main;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import SFDC2IDP.BASE.COMMON.Helper;

public class Main {
	public static void main(String[] args) {
		String textContent;
		try {
			textContent = Helper
					.getFileContent("E:/lenovo-work/work/Endeavor Progect/materials/18 PCG CTO CV Cost(NA&AP)/18 PCG CTO CV Cost(NA&AP)/原文件备份 - 副本.TXT","\n");

			System.out.println(textContent);

			// Pattern pattern = Pattern.compile("(GB10\\t.*[^\\n]\\n)");

//			Pattern pattern = Pattern.compile("(GB10\t.*[^\n]\n)");
			Pattern pattern = Pattern.compile("(((GB10)|(US20))\t.*[^$])");
			Matcher matcher = pattern.matcher(textContent);
            int count = 0 ;
            String result = "";
        	System.out.println("............................................");
			while (matcher.find()) {
				String line = matcher.group(1);
				System.out.println(count++);
				System.out.print(line);
				
//				for (int i = 0; i < matcher.groupCount(); i++) {
				result+=line;
//				}
			}
			Helper.writerFile("E:/lenovo-work/work/Endeavor Progect/materials/18 PCG CTO CV Cost(NA&AP)/18 PCG CTO CV Cost(NA&AP)/原文件备份 - 副本.TXT.result",result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
