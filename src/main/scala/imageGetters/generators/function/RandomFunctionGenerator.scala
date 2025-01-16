package imageGetters.generators.function

import imageGetters.generators.FunctionGenerator

import scala.math.sin
import scala.util.Random

class RandomFunctionGenerator extends FunctionGenerator(Random.between(10, 51), Random.between(10, 51), (x, y) => {
    Random.nextInt(256)
}) {

}
