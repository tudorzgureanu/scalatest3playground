import org.scalatest.{FunSuiteLike, Matchers}

class ContainerMatchersSuite extends FunSuiteLike with Matchers {

  test("container matchers") {
    val collection = Seq(1, 2, 3, 4)

    collection should contain oneElementOf List(8, 7, 6, 3)
    collection should contain oneElementOf Vector(2)

    collection should contain noElementsOf Seq(8, 7, 6, 5)
    collection should contain noElementsOf List()

    collection should contain atLeastOneElementOf List(8, 7, 6, 3)
    collection should contain atLeastOneElementOf Set(1, 2, 6, 3)

    collection should contain atMostOneElementOf List(8, 7, 6, 3)
    collection should contain atMostOneElementOf Seq(5)
    collection should contain atMostOneElementOf Vector()

    collection should contain allElementsOf List(1, 3, 3, 3, 4, 3, 2)

    collection should contain inOrderElementsOf List(1, 2, 3, 4)
    collection should contain inOrderElementsOf Vector(1, 2, 3, 4, 1)
    collection should contain inOrderElementsOf List(1, 2, 3, 4, 2)
  }
}
