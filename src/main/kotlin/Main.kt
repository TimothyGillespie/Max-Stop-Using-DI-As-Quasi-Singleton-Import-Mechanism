fun main() {
    database.insert(Thing(1, "My initial thing"))
    println("Starting of with ${database.things.size} thing in the database")

    val thingAdder = ThingAdder(2)

    val adderThread = Thread {
        thingAdder.startAddingThings()
    }

    val printerThread = Thread {
        while (true) {
            println("Currently, we have ${database.things.size} things in the database")
            Thread.sleep(1000)
        }
    }

    adderThread.start()
    printerThread.start()

    adderThread.join()
    printerThread.join()
}