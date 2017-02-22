package brunofitas.checkout


object Catalog {

  case class Product(name:String, price:BigDecimal, promo:Option[String] = Some("noPromo"))


  val products : Map[String,Product] = {

    Map[String, Product] (
      "apple" -> Product ("apple", 0.60, Some("threeForTwo")),
      "orange" -> Product ("orange", 0.25, Some("twoForOne"))
    )
  }

  val promos : Map[String,(Int) => Int] = {

    val noPromo : (Int) => Int = (i) => i
    val twoForOne : (Int) => Int =  (i) => i - (i/2)
    val threeForTwo : (Int) => Int =  (i) => i - (i/3)

    Map[String,(Int) => Int](
      "noPromo"     -> noPromo,
      "twoForOne"   -> twoForOne,
      "threeForTwo" -> threeForTwo
    )

  }

}
