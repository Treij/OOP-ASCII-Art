package imageGetters.generators.function

import imageGetters.generators.FunctionGenerator

class GridFunctionGenerator extends FunctionGenerator(150, 150, (x, y) => {
    (x % 2 + y % 2) * 127
}){

}
