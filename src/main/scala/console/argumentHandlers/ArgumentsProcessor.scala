package console.argumentHandlers

trait ArgumentsProcessor[T] {
    /**
     * Processes the arguments
     */
    def process(commands: Seq[Seq[String]]): T

    /**
     * @return Array of accepted arguments
     */
    def getAcceptedCommands: Seq[String]
}
