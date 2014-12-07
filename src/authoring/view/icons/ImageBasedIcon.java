package authoring.view.icons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;

/**
 * Represents an image, but does not instantiate JavaFX object so that the
 * object can easily be serialized if necessary.
 * 
 * @author Chris Bernt
 * @author Kevin Li
 * @author Arjun Jain
 * @author Wesley Valentine
 *
 */
public abstract class ImageBasedIcon extends FileIcon {

	private static final int DEFAULT_ROTATION = 0;
	private static final int DEFAULT_IMAGE_HEIGHT = 50;
	private static final int DEFAULT_IMAGE_WIDTH = 50;
	protected ImageView myImageView;
	protected double myWidth;
	protected double myHeight;
	protected double myRotation;

	public ImageBasedIcon(String name, File location, GameHandler... event) {
		super(location, name, event);
		myWidth = DEFAULT_IMAGE_WIDTH;
		myHeight = DEFAULT_IMAGE_HEIGHT;
		myRotation = DEFAULT_ROTATION;
		makeGraphic();

	}

	/**
	 * creates an instance of the JavaFX object that can be displayed on the
	 * GUI. Takes in a MouseEvent so that the graphic will respond to the
	 * specified events.
	 * 
	 * @param event
	 */

	private void makeGraphic() {
		System.out.println(myGameLocation.getPath());
		File file = new File(myGameLocation.getPath() + "/images/"
				+ myLabel);
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);

			myImageView = new ImageView(image);

			myImageView.setFitHeight(myHeight);
			myImageView.setFitWidth(myWidth);
			myImageView.setRotate(myRotation);

			this.getChildren().add(myImageView);

			for (GameHandler g : myOnClick) {
				this.addEventFilter(g.getEventType(), g);
			}

		} catch (IOException e) {
			System.out.println("Couldn't use path");
		}
	}

	public void setDimensions(double width, double height, double rotation) {
		myWidth = width;
		myHeight = height;
		myRotation = rotation;
		myImageView.setFitHeight(myHeight);
		myImageView.setFitWidth(myWidth);
		myImageView.setRotate(myRotation);
	}

}