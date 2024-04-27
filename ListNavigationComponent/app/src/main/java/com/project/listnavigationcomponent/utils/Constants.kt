package com.project.listnavigationcomponent.utils

object Constants {
    private val words = listOf(
        "air", "ant", "apple",
        "black", "boy", "big",
        "cat", "car", "cake",
        "dog", "dolphin", "desk",
        "elephant", "egg", "eye",
        "frog", "fox", "fire",
        "goat", "girl", "grass",
        "hat", "house", "hand",
        "ink", "ice", "island",
        "jacket", "jar", "juice",
        "kite", "kangaroo", "key",
        "lion", "lemon", "lamp",
        "monkey", "mouse", "milk",
        "nest", "notebook", "nose",
        "owl", "orange", "ocean",
        "pig", "pen", "pear",
        "queen", "quilt", "question",
        "rabbit", "rose", "rain",
        "sun", "snake", "star",
        "tree", "turtle", "table",
        "umbrella", "unicorn", "uniform",
        "vase", "volcano", "vegetable",
        "water", "whale", "window",
        "xylophone", "x-ray", "xenon",
        "yak", "yarn", "yo-yo",
        "zebra", "zipper", "zoo"
    )


    fun wordMap() = mutableMapOf<Char, List<String>>().apply {
        ('a'..'z').forEach { letter ->
            val wordsStartingWithLetter = words.filter { it.startsWith(letter) }
            if (wordsStartingWithLetter.isNotEmpty()) {
                this[letter] = wordsStartingWithLetter
            }
        }
    }
}