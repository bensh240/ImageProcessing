import java.awt.Color;

/**
 * A library of image processing functions.
 */
public class Instush {
	
	public static void main(String[] args) {
	    // Can be used for testing, as needed.
		Color[][] image1 = read("tinypic.ppm");
		Color[][] image2 = read("eyes.ppm");
		println(image1);



	}

	/**
	 * Returns an image created from a given PPM file.
	 * SIDE EFFECT: Sets standard input to the given file.
	 * @return the image, as a 2D array of Color values
	 */
	public static Color[][] read(String filename) {
		StdIn.setInput(filename);
		// Reads the PPM file header (ignoring some items)
		StdIn.readString();
		int numCols = StdIn.readInt();
		int numRows = StdIn.readInt();
		StdIn.readInt();
		// Creates the image 'numCols
		// For each pixel (i,j), reads 3 values from the file,
		// creates from the 3 colors a new Color object, and 
		// makes pixel (i,j) refer to that object.		
		// Replace the following statement with your code

		Color[][] image = new Color[numRows][numCols];
		// Reads the RGB values from the file, into the image.
		for (int i = 0;  i < numRows ; i++) {
			for (int j = 0; j <numCols ; j++) {
				Color newColor = new Color (StdIn.readInt() , StdIn.readInt() ,StdIn.readInt() );
				image[i][j] = newColor ;
			}
		}
		return image;
	}
	/**
	 * Prints the pixels of a given image.
	 * Each pixel is printed as a triplet of (r,g,b) values.
	 * For debugging purposes.
	 * @param image - the image to be printed
	 */
	public static void println(Color[][] image) {
	    // Write your code here
		int numCols =image[0].length;
		int numRows =image.length;
		for (int i = 0;  i < numCols ; i++) {
			for (int j = 0; j < numRows; j++) {
				System.out.print("(");
				System.out.printf("%3s", image[i][j].getRed() + ", ");    // Prints the red component
				System.out.printf("%4s", image[i][j].getGreen() + ", ");  // Prints the green component
				System.out.printf("%4s", image[i][j].getBlue());   // Prints the blue component
				System.out.print(") ");

			}
			System.out.println();
		}
	}
	
	/**
	 * Returns an image which is the horizontally flipped version of the given image. 
	 * @param image - the image to flip
	 * @return the horizontally flipped image
	 */
	public static Color[][] flippedHorizontally(Color[][] image) {
		// Replace the following statement with your code
		int numCols =image[0].length;
		int numRows =image.length;
		Color[][] HorizonColor = new Color[numRows][numCols];
		for (int i = 0; i <numRows ; i++) {
			for (int j = numCols-1 ; j >=0 ; j--) {
				HorizonColor[i][numCols - 1-j] = image[i][j];
			}
		}

		return HorizonColor;
	}
	
	/**
	 * Returns an image which is the vertically flipped version of the given image. 
	 * @param image - the image to flip
	 * @return the vertically flipped image
	 */
	public static Color[][] flippedVertically(Color[][] image){
		// Replace the following statement with your code
		int numCols =image[0].length;
		int numRows =image.length;
		Color[][] VerticalColor = new Color[numRows][numCols];
		for (int i = numRows-1; i >=0 ; i--) {
			for (int j = numCols-1 ; j >=0 ; j--) {
				VerticalColor[numRows-1-i][j] = image[i][j];
			}
		}
		return VerticalColor;
	}
	
	/**
	 * Returns the average of the RGB values of all the pixels in a given image.
	 * @param image - the image
	 * @return the average of all the RGB values of the image
	 */
	public static double average(Color[][] image) {
		// Replace the following statement with your code
		int numCols =image[0].length;
		int numRows =image.length;
		double sum = 0;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j <numCols ; j++) {
				sum = image[i][j].getRed() + image[i][j].getBlue() + image[i][j].getGreen() ;
			}
		}
		double ave = sum / (numCols*numRows*3);

		return ave;
	}

	/**
	 * Returns the luminance value of a given pixel. Luminance is a weighted average
	 * of the RGB values of the pixel, given by 0.299 * r + 0.587 * g + 0.114 * b.
	 * Used as a shade of grey, as part of the greyscaling process.
	 * @param pixel - the pixel
	 * @return the greyscale value of the pixel, as a Color object
	 *         (r = g = b = the greyscale value)
	 */
	public static Color luminance(Color pixel) {
		// Replace the following statement with your code
		int temoPoxel =  (int)(0.299*pixel.getRed() + 0.587*pixel.getGreen() + 0.114*pixel.getBlue());
		Color newPoxel = new Color (temoPoxel , temoPoxel , temoPoxel);

		return newPoxel;
	}
	
	/**
	 * Returns an image which is the greyscaled version of the given image.
	 * @param image - the image
	 * @return rhe greyscaled version of the image
	 */
	public static Color[][] greyscaled(Color[][] image) {
		// Replace the following statement with your code
		int numCols = image[0].length;
		int numRows = image.length;
		Color[][] greyColor = new Color[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				greyColor[i][j] = luminance(image[i][j]);
			}
		}
		return greyColor;
	}
	
	/**
	 * Returns an umage which is the scaled version of the given image. 
	 * The image is scaled (resized) to be of the given width and height.
	 * @param image - the image
	 * @param width - the width of the scaled image
	 * @param height - the height of the scaled image
	 * @return - the scaled image
	 */
	public static Color[][] scaled(Color[][] image, int width, int height) {
		// Replace the following statement with your code
			Color[][] scaledImage = new Color [height][width];
			int w0 =image[0].length;
			int h0 =image.length;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int w2 = (int) (j * w0 / width);
					int h2 = (int) (i * h0 / height);
					scaledImage[i][j] = image[h2][w2];
				}
			}
		return scaledImage;
	}

	/**
	 * Morphs the source image into the target image, gradually, in n steps.
	 * Animates the morphing process by displaying the morphed image in each step.
	 * The target image is an image which is scaled to be a version of the target
	 * image, scaled to have the width and height of the source image.
	 * @param source - source image
	 * @param target - target image
	 * @param n - number of morphing steps
	 */
	public static void morph(Color[][] source, Color[][] target, int n){
		int ws = source[0].length;
		int hs = source.length;
		int wt = target[0].length;
		int ht = target.length;
		if (ws != wt || hs != ht){
			target = scaled(target, ws, hs);
		}
		Color[][] BlendColor = new Color[hs][ws];
		for (int i = 0; i < n; i++) {
			double n2 = n;
			double n3 = (n2 - i) /n2;
			BlendColor= blend(source, target,n3);
			show(BlendColor);
		}
	}
	/**
	 * Returns a blended color which is the linear combination of two colors.
	 * Each r, g, b, value v is calculated using v = (1 - alpha) * v1 + alpha * v2.
	 * 
	 * //@param pixel1 - the first color
	 * //@param pixel2 - the second color
	 * @param alpha - the linear combination parameter
	 * @return the blended color
	 */
	public static Color blend(Color c1, Color c2, double alpha) {
		// Replace the following statement with your code
			int newRed = (int)(alpha*c1.getRed() +(1-alpha)*c2.getRed()) ;
			int newGreen = (int)(alpha*c1.getGreen() +(1-alpha)*c2.getGreen());
			int newBlue =(int)(alpha* c1.getBlue() +(1-alpha)*c2.getBlue());
			Color blendColor = new Color(newRed , newGreen , newBlue);

		return blendColor;
	}
	
	/**
	 * Returns an image which is the blending of the two given images.
	 * The blending is the linear combination of (1 - alpha) parts the
	 * first image and (alpha) parts the second image.
	 * The two images must have the same dimensions. 
	 * @param image1 - the first image
	 * @param image2 - the second image
	 * @param alpha - the linear combination parameter
	 * @return - the blended image
	 */
	public static Color[][] blend(Color[][] image1, Color[][] image2, double alpha) {
		// Replace the following statement with your code
			int w0 =image1[0].length;
			int h0 =image1.length;
			Color [][] blendColor = new Color[h0][w0];
			for (int i = 0; i < h0; i++) {
				for (int j = 0; j < w0; j++) {
					blendColor[i][j] = blend(image1[i][j], image2[i][j], alpha);
				}
			}

		return blendColor;
	}

	
     /**
	 * Renders (displays) an image on the screen, using StdDraw. 
	 * 
	 * @param image - the image to show
	 */
	public static void show(Color[][] image) {
		StdDraw.setCanvasSize(image[0].length, image.length);
		int width = image[0].length;
		int height = image.length;
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.show(25); 
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Sets the pen color to the color of the pixel
				StdDraw.setPenColor( image[i][j].getRed(),
					                 image[i][j].getGreen(),
					                 image[i][j].getBlue() );
				// Draws the pixel as a tiny filled square of size 1
				StdDraw.filledSquare(j + 0.5, height - i - 0.5, 0.5);
			}
		}
		StdDraw.show();
	}
}

