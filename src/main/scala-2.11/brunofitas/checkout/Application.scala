package brunofitas.checkout

object Application extends App{
  Checkout().scan(args.toList)
  println( Checkout().output )
}
