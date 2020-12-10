package esercizio.omircon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

public class Main {
public static void main (String [] args) {
	   String path = "C:\\Users\\Gigabyte\\Desktop\\Omicron\\OmicronRepo\\Input\\ServiceMenu.json";
       try {
           FileReader reader = new FileReader(path);
           Gson gson = new Gson();
           MenuContent menuContent = gson.fromJson(reader,MenuContent.class);
           List<MenuNode> nodes = menuContent.getNodes();
           for(MenuNode m : nodes){
               m.setNodes(m.getNodes());
               System.out.println(m.getNodeName());





               /*XSSFWorkbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("ServiceMenu");
               int rowNum = 1;
               for(MenuNode node: nodes) {
                   Row row = sheet.createRow(rowNum++);
                   row.createCell(1).setCellValue(node.getNodeName());
                   row.createCell(0).setCellValue(node.getNodeId());
               }
               // Write the output to a file
               FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Gigabyte\\Documents\\progetti\\OmicronStage\\Output\\servicemenu.xlsx");
               wb.write(fileOut);
               fileOut.close();

               // Closing the workbook
               wb.close();*/
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }catch (IOException ex){

       }
}
}
