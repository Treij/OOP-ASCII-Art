package filters

import arrayImages.Image

/**
 * Used to manipulate greyscale image
 */
trait Filter {

    /**
     * Applies the filter to the image
     * @param img the image to manipulate
     * @return manipulated image
     */
    def apply(img: Image[Int]): Image[Int]
}
