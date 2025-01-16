package imageGetters.generators.function

import imageGetters.generators.FunctionGenerator

class GradientFunctionGenerator extends FunctionGenerator(128, 128, (x, y) => {
    x+y
}) {

}
