package imageGetters.generators.function

import imageGetters.generators.FunctionGenerator

import scala.math.sin

class BubblesFunctionGenerator extends FunctionGenerator(150, 150, (x, y) => {
    (((sin(x/6d) + 1) + (sin(y/6d) + 1)) * 64).round.toInt
}) {

}
