package brunofitas.checkout

import scala.collection.mutable.ListBuffer
import Catalog._


class Checkout {

  val products : Map[String, Product] =
    Catalog.products

  val cart : ListBuffer[String] =
    ListBuffer.empty[String]

  def scan(items:List[String]) : Unit =
    items.foreach(i => if(products.contains(i)) cart.append(i))

  def clear() : Unit =
    cart.clear

  def total =
    cart.distinct.map(p => promos(products(p).promo.getOrElse("noPromo"))(cart.count(i => i == p)) * products(p).price).sum

  def output : String =
    s"£ ${"%.2f".format(total)}"

}

object Checkout{
  private val instance = new Checkout()
  def apply() = instance
}
