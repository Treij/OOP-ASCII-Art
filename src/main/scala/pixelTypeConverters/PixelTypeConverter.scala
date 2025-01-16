package pixelTypeConverters

import arrayImages.Image

/**
 * Used for converting between images with different pixel type
 * @tparam T Original image pixel type
 * @tparam U New image pixel type
 */
trait PixelTypeConverter[T, U] {

    /**
     * Converts the image
     */
    def convert(img: Image[T]) : Image[U]
}
