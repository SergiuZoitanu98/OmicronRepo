package esercizio.omircon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

public class MenuContent {
	private String version;
	private List<MenuNode> nodes;

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

	public List<MenuNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<MenuNode> nodes) {
		this.nodes = nodes;
	}

	public void metodo(List<MenuNode> lista, int depth) {
		String path = "C:\\Users\\Laura Caltagirone\\omicron\\OmicronRepo\\Input\\ServiceMenu.json";
		try {
			FileReader reader = new FileReader(path);
			Gson gson = new Gson();
			MenuContent menuContent = gson.fromJson(reader, MenuContent.class);
			lista = menuContent.getNodes();
proccessJson(lista);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {

		}
	}

	public void proccessJson(List<MenuNode> nodes) {

		for (MenuNode node : nodes) {
			System.out.println(node.getNodeName() + "\n" + node.getNodeType() + "\n" + node.getGroupType() + "\n" + node.getFlowType() );
			try {
				proccessJson(node.getNodes());
			} catch (Exception ex) {

			}
		}
	}
}
