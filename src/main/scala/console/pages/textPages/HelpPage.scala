package console.pages.textPages

import console.pages.TextPage

class HelpPage extends TextPage {
    override def render(): String = {
        var str = ""

        str += "  ##==============================##\n"
        str += "  || AsciiArtor 9000 command list ||\n"
        str += "  ##==============================##\n"
        str += "Selecting image (requires exactly one)\n"
        str += "    --image-fun FUNCTION\n"
        str += "        FUNCTION can be bubbles, grid, waves, crazy, cvut (requires correct table, can you guess it?)\n"
        str += "    --image PATH\n"
        str += "        loads image from file\n"
        str += "\n"
        str += "Specify filters (optional, can be multiple)\n"
        str += "    --invert\n"
        str += "        inverts images brightness\n"
        str += "    --brightness CHANGE1 [CHANGE2, ... CHANGEn]\n"
        str += "        changes brightness of an image, can be positive or negative\n"
        str += "    --flip x|y|xy\n"
        str += "        flips the image along given axes\n"
        str += "    --1x2ratioFix\n"
        str += "        squishes the image for fonts that are 2x higher than wide\n"
        str += "\n"
        str += "ASCII conversion table (requires one, if unspecified has default value)\n"
        str += "    --table NAME\n"
        //noinspection SpellCheckingInspection
        str += "        specify predefined table (default, long, pixelart, spots, variedSpots, columns, binary, nonlinear)\n"
        str += "    --custom-table CHARACTERS\n"
        str += "        create custom linear table\n"
        str += "\n"
        str += "Exporting image (can be multiple, defaults to console)\n"
        str += "    --output-console\n"
        str += "        prints the image into console\n"
        str += "    --output-file PATH\n"
        str += "        saves the image to a file\n"

        str
    }
}
