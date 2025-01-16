package filters
import arrayImages.Image

/**
 * This filter doesn't change the image (basically replacement for a null value)
 */
class IdentityFilter extends Filter {
    override def apply(img: Image[Int]): Image[Int] = img
}
