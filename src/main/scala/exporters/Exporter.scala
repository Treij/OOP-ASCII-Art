package exporters

/**
 * Parametrised eporter
 * @tparam T Type of item to export
 */
trait Exporter[T] {
    def export(item: T) : Unit
}
