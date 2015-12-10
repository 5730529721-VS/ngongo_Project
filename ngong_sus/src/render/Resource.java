package render;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {
	public static BufferedImage knight;
	public static BufferedImage monster;
	static{
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			knight = ImageIO.read(loader.getResource("mon_knight.png"));
			monster = ImageIO.read(loader.getResource("monster_drac.png"));
		} catch (Exception e) {
			knight = null;
			monster = null;
		}
	}
}
