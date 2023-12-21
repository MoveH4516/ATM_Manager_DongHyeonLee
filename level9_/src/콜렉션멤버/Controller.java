package 콜렉션멤버;

import java.util.HashMap;
import java.util.Map;

public class Controller {
	private Controller() {
		init();
	}
	
	private static Controller instance = new Controller();
	public static Controller getInstance() {
		return instance;
	}
	
	private Map<String, Action> mapList;
	private void init() {
		mapList = new HashMap<>();
		mapList.put("insert", new Actioninsert());
		mapList.put("delete", new Actiondelete());
		mapList.put("print", new Actionprint());
		mapList.put("change", new Actionchange());
	}
	
	public Action getAction(String key) {
		return mapList.get(key);
	}
	
	
	
}
