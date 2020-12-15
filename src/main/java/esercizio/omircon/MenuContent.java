package esercizio.omircon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;

public class MenuContent {
	private String version;
	private List<MenuNode> nodes;
	private int depth;
    private int rowNum = 0;
    private List<MenuNode> cleanNodes = new ArrayList<MenuNode>();
	public MenuContent() {
		super();
	}

	public String getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return "MenuContent{" + "version='" + version + '\'' + ", nodes=" + nodes +

				'}';
	}


	
	public void setVersion(String version) {
		this.version = version;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getDepth() {
		return depth;
	}
	public List<MenuNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<MenuNode> nodes) {
		this.nodes = nodes;
	}



	public void proccessJson(List<MenuNode> nodes, int depth, int rowNum) {
		
		boolean alreadyIncremented = false;
		for (MenuNode node : nodes) {
			node.setDepth(depth);
			try {
				if(!alreadyIncremented) {
				depth++;
				alreadyIncremented = true;
			}
			this.setCleanNodes(node);
			  proccessJson(node.getNodes(), depth, rowNum);
			} catch(Exception e) {
				
			}
		}
	}

	

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public List<MenuNode> getCleanNodes() {
		return cleanNodes;
	}

	public void setCleanNodes(MenuNode node) {
		
		this.cleanNodes.add(node);
		
	}
}
