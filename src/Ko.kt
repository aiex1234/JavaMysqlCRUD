fun main(args: Array<String>) {
    var str: String = "test"

    val list5:List<Int> = listOf(1,2,3,4,5)

    println(list5.map { elem -> elem * 2 })

    val list6 = list5.map { elem -> elem * 2 }

    println(list6)
    println(list5)



    (1..10)
            .map {
                println("map=  $it")
                it * 2 }   // 1~10 들어오고
            .filter {
                println("filter=  $it")
                it > 10 } //

            // 12 ~ 20까지  it
            .map { "Value = $it" }

            // 12 -> "Value = 12"
            .forEach { println(it) }

    val list: MutableList<Int> = mutableListOf(1,2,3,4,5,6,7,8,9,10)

    val list2: MutableList<String> = mutableListOf()

    val test :(String, String, String) -> String = {
        helloText, helloText2, helloText3 ->
        helloText + helloText2 + helloText3
    }

    val test2: String = test("명인" , "애연", "시원")

    println(test2)

    fun hello(helloText : String) = "hello $helloText"

    println(hello("시원"))

    for(i in 0 until list.size) {
        val checkInt: Int = list[i] * 2
        if (checkInt > 10)
            list2.add("Value = $checkInt")
    }

    for(i in 0 until list2.size) {
        println(list2[i])
    }

    var a: Int = 1
    var b: String = "test"

    val list3 : List<Any> = listOf(1, "3,2,4,4s")
}
