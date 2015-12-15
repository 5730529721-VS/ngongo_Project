package render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	public static RenderableHolder getInstance() {
		return instance;
	}

	private ArrayList<IRenderable> items;

	public RenderableHolder() {
		items = new ArrayList<IRenderable>();
	}

	public void add(IRenderable item) {
		items.add(item);
		Collections.sort(items, new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if (o1.getZ() > o2.getZ())
					return -1;
				return 1;
			}
		});
	}

	public ArrayList<IRenderable> getRenderableList() {
		return items;
	}

	public void clear() {
		// TODO Auto-generated method stub
		items = new ArrayList<IRenderable>();
	}

}
