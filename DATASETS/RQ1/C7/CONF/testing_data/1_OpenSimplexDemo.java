


public class OpenSimplexDemo
{
	private static final long SEED = 0;
	private static final int WIDTH = 512;
	private static final int HEIGHT = 512;
	private static final double FREQUENCY = 1.0 / 24.0;

	public static void main(String[] args)
		throws IOException {
		
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
			{
				double value = OpenSimplex2S.noise3_ImproveXY(SEED, x * FREQUENCY, y * FREQUENCY, 0.0);
				int rgb = 0x010101 * (int)((value + 1) * 127.5);
				image.setRGB(x, y, rgb);
			}
		}
		ImageIO.write(image, "png", new File("noise.png"));
	}
}
