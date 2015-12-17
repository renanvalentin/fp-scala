object Lists{
	def main(args: Array[String]) {
		val initList = init[String](List("batman", "robin"))
		println(initList)

		val concatList = concat[String](List("batman"), List("robin", "joker"))
		println(concatList)

		val concatList2 = concatOptimal[String](List("Spidey"),  List("Venom", "Carnage"))
		println(concatList2)

		val reverseList = reverse(List("Batman", "Robin", "Joker"))
		println(reverseList)

		val sequence = List('a', 'b', 'c', 'd')
		println(sequence drop 1 + 1)

		val dropList = removeAt(1, List('a', 'b', 'c', 'd'))
		println(dropList)
	}

	def init[T](xs: List[T]): List[T] = xs match {
		case List() => throw new Error("init of empty list")
		case List(x) => List(x)
		case y :: ys => y :: init(ys)
	}

	def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
		case List() => ys
		case z :: zs => z :: concat[T](zs, ys)
	}

	def concatOptimal[T](xs: List[T], ys: List[T]):List[T] = xs match {
		case List() => ys
		case _ =>  concatOptimal(xs init, (xs last) :: ys) 
	}

	def reverse[T](xs: List[T]):List[T] = xs match {
		case List() => xs
		case y :: ys => reverse(ys) ++ List(y)
	}

	def removeAt[T](n: Int, xs: List[T]):List[T] = (xs take n) ::: (xs drop n + 1)
}
