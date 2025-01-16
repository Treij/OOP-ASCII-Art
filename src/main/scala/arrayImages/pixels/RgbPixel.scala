package arrayImages.pixels


/**
 * This calss represents a pixel with 3 color values
 * @param r red
 * @param g green
 * @param b blue
 */
case class RgbPixel(r: Int, g: Int, b: Int) {
    require(r >= 0 && r < 256 && g >= 0 && g < 256 && b >= 0 && b < 256)
}
