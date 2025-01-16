package filters
import arrayImages.Image

/**
 * Applies multiple filters to the image
 * @param filters
 */
class MultiFilter(filters: Seq[Filter]) extends Filter {
    override def apply(img: Image[Int]): Image[Int] = {
        filters.foldLeft(img)((accumulator, filter) => filter.apply(accumulator))
    }
}
