package Main

import console.ConsoleUI


object Main extends App {

//    println("APP: app started")
    val startTime = System.nanoTime
    new ConsoleUI(args)
//    println(s"Time to convert: ${(System.nanoTime() - startTime) / 1000000} ms")

}