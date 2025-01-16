package imageGetters.generators.function

import imageGetters.generators.FunctionGenerator

class CvutFunctionGenerator extends FunctionGenerator(128, 128, (x, _) => {
    val v = Vector(115, 120, 122, 145, 255, 141, 145, 68)
    if (x >= v.length) 255 else v(x)
}) {

}
