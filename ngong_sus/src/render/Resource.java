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
	static{
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			knight = ImageIO.read(loader.getResource("mon_knight.png"));
			monster = ImageIO.read(loader.getResource("monster_drac.png"));
			heart = ImageIO.read(loader.getResource("heart.png"));
			field = ImageIO.read(loader.getResource("field.png"));
			
			//Filp the image horizontally
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-knight.getWidth(null),0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			knight = op.filter(knight, null);
			
		} catch (Exception e) {
			knight = null;
			monster = null;
			heart = null;
			field = null;

		}
	}
}
