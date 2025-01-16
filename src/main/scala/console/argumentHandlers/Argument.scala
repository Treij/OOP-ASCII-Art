package console.argumentHandlers

/**
 * Handles specific argument
 * @tparam T return type
 */
trait Argument[T] {
    /**
     * Processes parameters for given argument
     * @return
     */
    def handle(): T
}
