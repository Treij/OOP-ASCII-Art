package imageGetters.generators.function

import imageGetters.generators.FunctionGenerator

import scala.math.sin

class WavesFunctionGenerator extends FunctionGenerator(150, 150, (x, y) => {
    ((sin(x / 6d + sin(y / 4d)) + 1) * 128).round.toInt
}) {

}
