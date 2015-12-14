package render;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {

	public static BufferedImage knight;
	public static BufferedImage monster;
	public static BufferedImage heart;
	public static BufferedImage field;
	public static BufferedImage sword;
	public static BufferedImage shield;
	public static BufferedImage potion;
	public static BufferedImage skull;
	
	static{
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			knight = ImageIO.read(loader.getResource("mon_knight.png"));
			monster = ImageIO.read(loader.getResource("monster_drac.png"));
			heart = ImageIO.read(loader.getResource("heart.png"));
			field = ImageIO.read(loader.getResource("map.png"));
			sword = ImageIO.read(loader.getResource("sword.png"));
			shield = ImageIO.read(loader.getResource("shield.png"));
			potion = ImageIO.read(loader.getResource("potion.png"));
			skull = ImageIO.read(loader.getResource("skull.png"));
			
			//Filp the image horizontally
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-knight.getWidth(null),0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			knight = op.filter(knight, null);
			
		} catch (Exception e) {
			System.out.println("kuy");
			knight = null;
			monster = null;
			heart = null;
			field = null;
			sword = null;
			shield = null;
			potion = null;
			skull = null;

		}
	}
}
