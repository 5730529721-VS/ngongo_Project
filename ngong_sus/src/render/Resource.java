package render;

import java.applet.Applet;
import java.applet.AudioClip;
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
	public static BufferedImage background;

	public static BufferedImage gamename;

	public static AudioClip introSound;
	public static AudioClip knightEcho;
	public static AudioClip monEcho;
	public static AudioClip pauseSound;

	static {
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
			background = ImageIO.read(loader.getResource("background.png"));

			gamename = ImageIO.read(loader.getResource("game_name.png"));

			introSound = Applet.newAudioClip((loader.getResource("background.wav")).toURI().toURL());
			knightEcho = Applet.newAudioClip((loader.getResource("knight_echo.wav")).toURI().toURL());
			monEcho = Applet.newAudioClip((loader.getResource("mon_echo.wav")).toURI().toURL());
			pauseSound = Applet.newAudioClip((loader.getResource("pause.wav")).toURI().toURL());

			// Filp the image horizontally
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-knight.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			knight = op.filter(knight, null);

		} catch (Exception e) {
			
			knight = null;
			monster = null;
			heart = null;
			field = null;
			sword = null;
			shield = null;
			potion = null;
			skull = null;
			background = null;
			introSound = null;
			knightEcho = null;
			monEcho = null;
			pauseSound = null;
		}
	}
}
