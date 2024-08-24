class ThingAdder(var startId: Int) {

    fun startAddingThings() {
        while (true) {
            database.insert(Thing(startId++, "Thing $startId"))
            Thread.sleep(5000)
        }
    }
}