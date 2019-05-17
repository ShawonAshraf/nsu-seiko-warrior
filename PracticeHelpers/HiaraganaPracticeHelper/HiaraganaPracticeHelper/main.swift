//
//  main.swift
//  HiaraganaPracticeHelper
//
//  Created by Shawon Ashraf on 5/17/19.
//  Copyright © 2019 Shawon Ashraf. All rights reserved.
//

import Foundation

let vowels = ["a", "e", "i", "o", "u"]
let consonants = ["k", "s", "t", "n", "h", "m", "y", "r", "w"]

// prompt to write the character as asked
func askToWrite() {
    var combination = getRandomCombination()
    
    // check for valid combination
    while !isValidCombination(combo: combination) {
        combination = getRandomCombination()
    }
    
    combination = specialCombination(combo: combination)
    print("Write => \(combination)    @    \(Date())")
}

func getRandomCombination() -> String {
    let vIndex = Int.random(in: 0..<vowels.count)
    let cIndex = Int.random(in: 0..<consonants.count)
    
    return "\(consonants[cIndex])\(vowels[vIndex])"
}

func specialCombination(combo: String) -> String {
    switch combo {
    case "tu":
        return "tsu"
    case "hu":
        return "fu"
    case "ti":
        return "chi"
    case "si":
        return "shi"
    default:
        return combo
    }
}

func isValidCombination(combo: String) -> Bool {
    switch combo {
    case "yi":
        return false
    case "ye":
        return false
    case "wu":
        return false
    case "wi":
        return false
    case "we":
        return false
    default:
        return true
    }
}

print("Press enter to start, e to exit")
while true {
    let input = readLine()!
    
    if input == "e" {
        break
    } else {
        askToWrite()
    }
}


