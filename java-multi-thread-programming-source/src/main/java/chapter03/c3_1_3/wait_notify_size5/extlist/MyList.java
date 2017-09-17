package chapter03.c3_1_3.wait_notify_size5.extlist;

import java.util.ArrayList;
import java.util.List;

public class MyList {

	private static List list = new ArrayList();

	public static void add() {
		list.add("anyString");
	}

	public static int size() {
		return list.size();
	}

}
