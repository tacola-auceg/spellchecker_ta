package analyser;

import java.net.URL;
import java.awt.*;
import javax.swing.*;
import java.io.*;

/**
 * Load images from correct place (directory or JAR file) into GUI.
 */
public class FileLocator
{
	/**
	 * Load file from correct place (directory or JAR file).
	 * @param imageName name of image to be loaded (with no path)
	 * @return loaded image
	*/
	public static URL getFile(String fileName)
	{
		ClassLoader cl = FileLocator.class.getClassLoader();
		return cl.getResource(fileName);
	}
}
