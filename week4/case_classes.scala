object Case_Classes {
	def main(args: Array[String]) {
		println(exprs.show(Sum(Number(1), Number(44)))	)
		println(exprs.show(Sum(Prod(Number(2), Var("x")), Var("y"))))
		println(exprs.show(Prod(Sum(Number(2), Var("x")), Var("y"))))
	}
}

trait Expr {
	def eval: Int = this match {
		case Number(n) => n
		case Sum(e1, e2) => e1.eval + e2.eval
	}
}

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(x: String) extends Expr

object exprs {
/*	def show(e: Expr): String = e match {
		case Number(x) => x.toString
		case Sum(l, r) => show(l) + " + " + show(r)
		case Prod(Sum(sl, sr), r) => "(" + show(sl) + " + " + show(sr) + ")" + " * " + show(r)
		case Prod(l, r) => show(l) + " * " + show(r)
		case Var(name) => name
	}*/

	def bracketsExpr(e: Expr) = {
		e match {
			case Sum(_, _) => "(" + show(e) + ")"
			case _ => show(e)
		}
	}


	def show(e: Expr): String = e match {
		case Number(n) => n.toString
		case Var(s) => s
		case Sum(e1, e2) => show(e1) + " + " + show(e2)
		case Prod(e1, e2) => bracketsExpr(e1) + " * " + bracketsExpr(e2)
	}
}

