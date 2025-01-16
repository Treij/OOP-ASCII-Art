package console.pages

trait Page[T] {
    def render(): T
}
