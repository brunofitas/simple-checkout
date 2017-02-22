package brunofitas.checkout

import org.scalatest.{FlatSpec, Matchers, BeforeAndAfter}

class CheckoutTests extends FlatSpec with BeforeAndAfter with Matchers{

  var ck:Checkout = _

  before{
    ck = Checkout()
  }

  "Checkout()" must "be a singleton and initialize with an empty cart and some products" in {
    assert(ck.isInstanceOf[Checkout])
    assert(ck == Checkout())
    assert(ck.cart.isEmpty)
    assert(ck.products.nonEmpty)
  }

  "scan" must "add catalog products to cart or ignore them if unknown" in {
    ck.scan(List("apple"))
    assert(ck.cart.size == 1)

    ck.scan(List("orange"))
    assert(ck.cart.size == 2)

    ck.scan(List("unknown"))
    assert(ck.cart.size == 2)
  }

  "clear" must "clear all items from the cart" in {
    assert(ck.cart.nonEmpty)
    ck.clear()
    assert(ck.cart.isEmpty)
  }

  "total" must "produce a sum of all item prices in the car" in {
    ck.clear()
    assert(ck.cart.isEmpty)
    ck.scan(List("orange", "orange", "apple"))
    assert(ck.total == BigDecimal(1.10))
  }

  "output" must "produce a string with the total" in {
    ck.clear()
    assert(ck.cart.isEmpty)
    ck.scan(List("orange", "orange", "apple"))
    assert(ck.total == BigDecimal(1.10))
    assert(ck.output == "£ 1,10")
  }



}

