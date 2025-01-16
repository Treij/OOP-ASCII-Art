package imageGetters.generators.function

import imageGetters.generators.FunctionGenerator

import scala.math.{cos, sin}

class SinCosFunctionGenerator extends FunctionGenerator(150, 150, (x, y) => {
    ((sin(cos(((x-75)*(y-75))/200d)) + 1) * 128).round.toInt
}) {

}
