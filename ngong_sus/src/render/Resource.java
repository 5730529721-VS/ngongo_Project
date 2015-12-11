package render;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {

	public static BufferedImage knight;
	public static BufferedImage monster;
	public static BufferedImage heart;
	static{
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			knight = ImageIO.read(loader.getResource("mon_knight.png"));
			monster = ImageIO.read(loader.getResource("monster_drac.png"));
			heart = ImageIO.read(loader.getResource("heart.png"));
		} catch (Exception e) {
			knight = null;
			monster = null;
			heart = null;
		}
	}
}
