object listReduction {
	def main(args: Array[String]) {
		def mapFun[T, U](xs: List[T], f: T => U): List[U] =
			(xs foldRight List[U]())(f(_) :: _)

		mapFun[Int, Int](List(1, 2, 3), x => x + 1)

		def lengthFun[T](xs: List[T]): Int =
			(xs foldRight 0)((_, r) => r + 1)

		println(List(1,2,3,4,5) reduceRight ((x, n) => { println(x); x - n }))
		List(1,2,3,4,5) reduceLeft ((x, n) => { println(x); x - n })
	}
}
