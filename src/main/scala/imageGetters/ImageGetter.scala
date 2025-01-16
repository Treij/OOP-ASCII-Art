package imageGetters

import arrayImages.Image
import arrayImages.pixels.RgbPixel

/**
 * Gets (Loads/generates/...) an image
 */
trait ImageGetter {

    /**
     * Gets the image
     * @return
     */
    def getImage: Image[RgbPixel]
}
