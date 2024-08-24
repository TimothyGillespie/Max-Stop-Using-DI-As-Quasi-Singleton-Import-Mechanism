data class Thing(val id: Int, val name: String)

class InMemoryDatabase {
    val things = mutableListOf<Thing>()

    fun insert(thing: Thing) {
        if (things.any { it.id == thing.id }) {
            throw BaboException("Thing with id ${thing.id} already exists")
        }
        things.add(thing)
    }
}

val database = InMemoryDatabase()