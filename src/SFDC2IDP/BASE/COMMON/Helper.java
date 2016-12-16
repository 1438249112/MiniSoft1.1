package SFDC2IDP.BASE.COMMON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.ContentEncodingHttpClient;

/**
 *
 * 依赖 commons-httpclient-3.1.jar commons-codec-1.4.jar
 * 
 * @author tianjun
 *
 */
public class Helper {
	 public static void writerFile(String filePath,String content) throws Exception{
		 File resultFile = new File(filePath);
		 if(!resultFile.getParentFile().exists()){
			 resultFile.getParentFile().mkdirs();
		 }
			if (resultFile.exists()) {
				resultFile.delete();
			}resultFile.createNewFile();
		 FileWriter fileWriter = new FileWriter(resultFile);
		 fileWriter.append(content);
 		fileWriter.flush();
 		fileWriter.close();
	 }
	public static void main(String[] args) {
		Helper.getFieldNamesFromSalesForceByObjectName("Contact",true);
	}
	private static HashMap<String,HashSet<String>> results = new HashMap<String,HashSet<String>> ();
	public static HashSet<String> getFieldNamesFromSalesForceByObjectName(
			String objectName) {
		return getFieldNamesFromSalesForceByObjectName(objectName,false);
	}
    public static String getFileContent(String filePath) throws Exception{
		//2.2.读取模板文件
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		String templateString = "";
		String line = "";
		while ((line = br.readLine()) != null) {
			templateString += " " + line;
		}
		return templateString = templateString.trim();
    }
    public static String getFileContent(File file) throws Exception{
 		//2.2.读取模板文件
 		BufferedReader br = new BufferedReader(new FileReader(file));
 		String templateString = "";
 		String line = "";
 		while ((line = br.readLine()) != null) {
 			templateString += " " + line;
 		}
 		return templateString = templateString.trim();
     }
	public static HashSet<String> getFieldNamesFromSalesForceByObjectName(
			String objectName,Boolean toLowerCase) {
		 HashSet<String> result = new  HashSet<String>();
		if(objectName==null || objectName.trim().equals("")){
			return result;
		}else{
			objectName = objectName.trim().toLowerCase();
		}
		
          if(results.containsKey(objectName)){
        	  return results.get(objectName);
          }
		try {
			String path = CONSTANTS.WSO2_SFDCObjectStruct_URL+ objectName;
			ContentEncodingHttpClient httpClient = new ContentEncodingHttpClient();
			HttpResponse response = httpClient.execute(new HttpGet(path));
			System.out.println(Helper.class.getCanonicalName() +"  StatusCode:"+response.getStatusLine().getStatusCode());
			if(response.getStatusLine().getStatusCode()==200){
				System.out.println(Helper.class.getCanonicalName() + ":" + path);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				String line = "";
				while ((line = br.readLine()) != null) {
					System.out
							.println(Helper.class.getCanonicalName() + " Object Structure In Salesforce:" + line);
					if(toLowerCase){
						line = line.toLowerCase();
					}
					result = dealWithString(line);
				}
				;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		results.put(objectName, result);
		
		return result;

	}

  //删除文件和目录
     public static void clearFiles(Object file){
    	 File f = null;
    	 if(file != null){
    		 if(file instanceof File){
    	    		f = (File) file;
    	    	 }else{
    	    		 f = new File(file.toString());
    	    	 }
    	         if(f.exists()){
    	              deleteFile(f);
    	         }
    	 }
    }
    private static void deleteFile(File file){
         if(file.isDirectory()){
              File[] files = file.listFiles();
              for(int i=0; i<files.length; i++){
                   deleteFile(files[i]);
              }
         }
         file.delete();
    }
    
	private static HashSet<String> dealWithString(String sql)
			throws IOException {
		HashSet<String> resultSet = new HashSet<String>();
		if (!sql.matches("(?i)Select\\sfrom")) {

			sql = sql.replaceFirst("(?i)<SOQL>", "").replaceFirst("(?i)</SOQL>", "");
			String xmlString = "";

			sql = sql.trim();
			// System.out.println(sql);
			// 去掉 select
			sql = sql.replaceFirst("^(?i)select\\s", "");
			// System.out.println(sql);
			// 获取表名
			String[] filesAtableName = sql.split("(?i)\\sfrom\\s");
			String tableName = filesAtableName[1].trim();
			// System.out.println(tableName);
			// 获取字段值
			String fields[] = filesAtableName[0].split(",");
			Arrays.sort(fields);
			// System.out.println(Arrays.toString(fields));
			for (String filed : fields) {
				resultSet.add(filed.trim());
			}
		}
		return resultSet;

	}

}
