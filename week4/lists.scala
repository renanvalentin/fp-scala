object Lists {
	def main(args: Array[String]) {
		val unsorted = List(3,5,2,1)
		val sorted = isort(unsorted)
		println(sorted)
	}
	
	
	def isort(list: List[Int]): List[Int] = list match {
		case List() => List()
		case headOfList :: tailOfList => insert(headOfList, isort(tailOfList))

	}

	def insert(headOfList: Int, tailOfList: List[Int]): List[Int] = tailOfList match {
		case List() => List(headOfList)
		case headOfTail :: tailOfTail => if (headOfList <= headOfTail) headOfList :: tailOfList else headOfTail :: insert(headOfList, tailOfTail)
	}
}



