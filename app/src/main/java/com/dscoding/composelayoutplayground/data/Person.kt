package com.dscoding.composelayoutplayground.data

data class Person(
    val firstName: String,
    val lastName: String,
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$firstName$lastName",
            "$firstName $lastName",
            "${firstName.first()}${lastName.first()}",
            "${firstName.first()} ${lastName.first()}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

val allPersons = listOf(
    Person(
        firstName = "Diogo",
        lastName = "Santos",
    ),
    Person(
        firstName = "Jeff",
        lastName = "Bezos"
    ),
    Person(
        firstName = "Steve",
        lastName = "Jobs"
    ),
    Person(
        firstName = "Elon",
        lastName = "Musk"
    ),
    Person(
        firstName = "Tim",
        lastName = "Cook"
    ),
    Person(
        firstName = "Harry",
        lastName = "Potter"
    ),
    Person(
        firstName = "Ron",
        lastName = "Weasley"
    ),
    Person(
        firstName = "Hermione",
        lastName = "Granger"
    ),
)
