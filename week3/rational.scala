object Week3 {
	def main(args: Array[String]) {
		val x = new Rational(1, 2)
		x.numer
		x.denom

		val y = new Rational(2, 3)
		val addResult = x.add(y)
		println(addResult.toString)


		val result = new Rational(1,3).sub(new Rational(5,7)).sub(new Rational(3,2))
		println(result.toString)

	}
}

class Rational(x: Int, y: Int) {
	require(y != 0, "denominator must be nonzero!")

	def this(x: Int) = this(x, 1)

	private def gcd(a: Int, b: Int): Int = int (b == 0) a else gcd(b, a % b)

	def numer = x
	def denom = y

	def add(that: Rational) = 
		new Rational(
			numer * that.denom + that.numer * denom,
			denom * that.denom)

	def less(that: Rational) = this.numer * that.denom < that.numer * this.denom

	def max(that: Rational) = if(this.less(that)) that else this

	def neg: Rational = new Rational(-numer, denom)

	def sub(that: Rational) = add(that.neg)

	override def toString =  {
		val g = gcd(this.number, this.denom)
		this.numer / g + "/" + this.denom / g
	}
}
