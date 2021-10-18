/**
 * This client program performs another striking visual effect: it morphs an image into its grescaled
 * version. This action transforms the colored image of the picture into a black and white image of the "source" picture.
 */

public class Editor4 {
    public static void main(String[] args) {
        String ppmFile1 = args[0];
        int steps =Integer.parseInt(args[1]);
        Instush.morph(Instush.read(ppmFile1),Instush.greyscaled(Instush.read(ppmFile1)),steps);
    }
}
