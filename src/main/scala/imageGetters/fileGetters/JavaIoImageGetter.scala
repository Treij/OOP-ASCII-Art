package imageGetters.fileGetters

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import scala.collection.mutable.ArrayBuffer
import arrayImages.Image
import arrayImages.pixels.RgbPixel
import exceptions.ArgumentException

/**
 * Image loader based on the JavaIO library
 * @param path path to file
 */
class JavaIoImageGetter(path: String) extends FileImageGetter {

    val supportedExtensions: Seq[String] = Seq(".png", ".jpg", ".jpeg")

    if (!supportedExtensions.exists(extension => path.toLowerCase().endsWith(extension)))
        throw new ArgumentException("Unsupported file type")

    override def getImage: Image[RgbPixel] = {
        val inputFile = new File(path)
        val buffImage: BufferedImage = ImageIO.read(inputFile)
        val pixels = ArrayBuffer[Int]()

        for (y <- 0 until buffImage.getHeight())
            for (x <- 0 until buffImage.getWidth())
                pixels += buffImage.getRGB(x, y)


        val pixels2D = pixels.map((x: Int) => RgbPixel((x & 0xFF0000) >> 16, (x & 0xFF00) >> 8, x & 0xFF))
            .grouped(buffImage.getWidth())
            .map(x => x.toIndexedSeq)
            .toIndexedSeq

        new Image[RgbPixel](pixels2D)
    }
}
