package esercizio.omircon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
	
		
		
		
		try {
			 Properties aProp = new Properties();
			 aProp.load(new FileInputStream ("./resources/config.properties"));
			FileReader reader = new FileReader(aProp.getProperty("path"));
			Gson gson = new Gson();
			MenuContent menuContent = gson.fromJson(reader, MenuContent.class);
			List<MenuNode> lista = menuContent.getNodes();
			menuContent.proccessJson(lista,0,1);
			Files.createDirectories(Paths.get(aProp.getProperty("outputFolderPath")));
			 
			
	
			int i = 1;
			int depth = 0;
			
			 
	         File excelFile = new File(aProp.getProperty("filePath"));
             XSSFWorkbook workbook = new XSSFWorkbook();
             Sheet sheet = workbook.createSheet("SeviceMenu");
             Row rowHeader = sheet.createRow(0);
             
            
			for(MenuNode node : menuContent.getCleanNodes()) {
				 if(depth < node.getDepth()) {
					 depth = node.getDepth();
				 }
				 Row row = sheet.createRow(i);
                 row.createCell(6).setCellValue(node.getNodeId());
                 row.createCell(7).setCellValue(node.getNodeName());
                 row.createCell(8).setCellValue(node.getNodeType());
                 row.createCell(9).setCellValue(node.getGroupType());
                 row.createCell(10).setCellValue(node.getFlowType());
                 if(node.getResource() != null) {
                	 row.createCell(11).setCellValue(node.getResource().getId());
                 }
                 
                 row.createCell(node.getDepth()).setCellValue("X");
	             i++;
			}
			
			int l = depth;
			
			for (int k = 0; k <= l; k++) {
			  rowHeader.createCell(k).setCellValue("Profondità "+ k);
			}
			
			 rowHeader.createCell(depth+1).setCellValue(aProp.getProperty("nodeId"));
             rowHeader.createCell(depth+2).setCellValue(aProp.getProperty("nodeName"));
             rowHeader.createCell(depth+3).setCellValue(aProp.getProperty("nodeType"));
             rowHeader.createCell(depth+4).setCellValue(aProp.getProperty("groupType"));
             rowHeader.createCell(depth+5).setCellValue(aProp.getProperty("flowType"));
             rowHeader.createCell(depth+6).setCellValue(aProp.getProperty("resourceId"));
             
             
             
			FileOutputStream out = new FileOutputStream(excelFile);
			 workbook.write(out);
			 out.close();
			 workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {

		}

	}
}
