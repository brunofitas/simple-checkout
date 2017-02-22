package brunofitas.checkout

object Catalog {

  case class Product(name:String, price:BigDecimal)

  val products = Map[String, Product](
    "apple"   ->   Product("apple", 0.60),
    "orange"  ->   Product("orange", 0.25)
  )

}
