package imageGetters.generators.function

import imageGetters.generators.FunctionGenerator

import scala.math.{cos, sin}

class CrazyFunctionGenerator extends FunctionGenerator(128, 128, (x, y) => {
    val a = (x / 20d) + 1.5
    val b = y / 20d
    ((sin(sin(a)) - cos(sin(a*b)+cos(a)) + 2) * 128).round.toInt
}) {

}
