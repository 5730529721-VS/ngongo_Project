package render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class GameAnimation implements IRenderable{
	private BufferedImage image;
	private int frameCount,frameDelay;
	private int currentFrame,frameDelayCount;
	private int x,y,frameWidth,frameHeight;
	private boolean visible = false, playing = false;
	
	public GameAnimation(BufferedImage image,int frameCount,int frameDelay){
		this.image = image;
		this.frameCount = frameCount;
		this.frameDelay = frameDelay;
		this.currentFrame = 0;
		this.frameDelayCount = frameDelay;
		if (image == null){
			this.frameHeight = 0;
			this.frameWidth = 0;
		}
		else {
			this.frameHeight = image.getHeight();
			this.frameWidth = image.getWidth();
		}
	}
	
	protected void topLeftAnimationAt(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}

	public int getFrameDelay() {
		return frameDelay;
	}

	public void setFrameDelay(int frameDelay) {
		this.frameDelay = frameDelay;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public int getFrameDelayCount() {
		return frameDelayCount;
	}

	public void setFrameDelayCount(int frameDelayCount) {
		this.frameDelayCount = frameDelayCount;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	protected void AnimationAt(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void play(){
		currentFrame = 0;
		playing = true;
		visible = true;
	}
	
	public void stop(){
		currentFrame = 0;
		playing = false;
		visible = false;
	}
	
	public void updateAnimation(){
		if (playing){
			if (frameDelayCount > 0){
				frameDelayCount--;
				return;
			}
				frameDelayCount = frameDelay;
				currentFrame++;
			if (currentFrame == frameCount)
				stop();
		}
	}
	
	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public int getZ() {
		return 0; 
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}


	public synchronized void drawEnemyAttack(Graphics2D g2) {
		if (visible && image != null){
			if (currentFrame <= 2)
			g2.drawImage(image.getSubimage((currentFrame*100)+95,383 , 85, 85), null, x, y);
			else
			g2.drawImage(image.getSubimage(((5-currentFrame)*100)+95,383 , 85, 85), null, x, y);
		}
	}

	public synchronized void drawKnightAttack(Graphics2D g2) {
		if (visible && image != null){
			if (currentFrame <= 3)
			g2.drawImage(image.getSubimage((currentFrame*100)+80,825 , 60, 120), null, x, y);
			else
			g2.drawImage(image.getSubimage(((7-currentFrame)*100)+80,825 , 60, 120), null, x, y);
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		
	}

}
