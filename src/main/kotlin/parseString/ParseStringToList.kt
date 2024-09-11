package org.example.parseString

const val string = "name=John, age=12, height=12, email=hsm@test.com; name=John, age=31, height=12, email=hsm@test.com; name=Hunter, age=29, height=21, email=some3@test.com;"

fun parsePeople(input: String): List<Person> {
    val people = mutableListOf<Person>()
    val records = input.split(';').filterNot { it.isEmpty() }

    for (record in records) {
        val items = record.split(',')

        val attributes = mutableMapOf<String, String>()
        for (item in items) {
            val (key, value) = item.split('=')
            attributes[key.trim()] = value.trim()
        }

        // Create Person object with safe defaults
        people.add(
            Person(
            name = attributes["name"] ?: "",
            age = attributes["age"]?.toIntOrNull() ?: 0,
            height = attributes["height"]?.toIntOrNull() ?: 0,
            email = attributes["email"] ?: ""
        )
        )
    }

    return people
}

data class Person(val name: String?, val age: Int?, val height: Int?, val email: String?) {
    override fun toString(): String {
        return "name=$name, age=$age, height=$height, email=$email"
    }
}


fun main() {
    println(parsePeople(string).distinctBy { it.name }.joinToString(separator = "; ", postfix = ";"))
}
