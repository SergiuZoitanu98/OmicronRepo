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

	private  int maxDepth = 0;

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

	public List<MenuNode> getNodes()	 {
		return nodes;
	}

	public void setNodes(List<MenuNode> nodes) {
		this.nodes = nodes;
	}



	public void proccessJson(List<MenuNode> nodes, int depth) {

		if (depth > maxDepth) {
			maxDepth = depth;
		}
		for (MenuNode node : nodes) {
			this.setCleanNodes(node);
			node.setDepth(depth);
			if (node.getNodes() != null && !node.getNodes().isEmpty()) {
				proccessJson(node.getNodes(), depth+1);
			}
		}
	}






	public List<MenuNode> getCleanNodes() {
		return cleanNodes;
	}

	public void setCleanNodes(MenuNode node) {

		this.cleanNodes.add(node);


	}
}