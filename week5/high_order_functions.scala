object highOrderFunctions {
	def main(args: Array[String]) {
		def pack[T](xs: List[T]): List[List[T]] = xs match {
			case Nil => Nil
			case x :: xs1 =>
				val (first, rest) = xs span (y => y == x)
				first :: pack(rest)
		}

		def encode[T](xs: List[T]): List[(T, Int)] = {
			pack(xs) map (ys => (ys.head, ys.length))
		}

		val data = List("a", "a", "a", "b", "B", "c", "c", "c", "a")

		println(pack(data))
		println(encode(data))
	}
}
