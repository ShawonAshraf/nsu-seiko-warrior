//
//  main.swift
//  VocabPractice
//
//  Created by Shawon Ashraf on 5/17/19.
//  Copyright © 2019 Shawon Ashraf. All rights reserved.
//

import Foundation

let englishWords = [
    "I",
    "University",
    "Japanese Language",
    "Sweets;Snacks",
    "Family",
    "Friend",
    "To Swim",
    "Every day",
    "Lunch",
    "The best"
]

func getRandomWord() -> String {
    return englishWords[Int.random(in: 0..<englishWords.count)]
}

while true {
    let input = readLine()!
    if input == "e" {
        break
    } else {
        print("\(getRandomWord()) => ?    @ \(Date())")
    }
}
