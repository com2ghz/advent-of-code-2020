package day4

import Puzzle
import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.Predicate

fun main() {
    Day4.partOne()
    Day4.partTwo()
}
object Day4 : Puzzle {
    private val HEX_COLOR_MATCHER = "#([a-f0-9]{6})".toRegex();
    private val DIGIT_MATCHER = "\\d{9}".toRegex();
    private val LINES = Files.readAllLines(Paths.get("src/main/resources/day4.txt"))

    override fun partOne() {
        val count = createPassports()
            .filter(this::requiredFieldsPresent)
            .count()
        println(count)
    }

    override fun partTwo() {
        val count = createPassports()
            .filter(this::requiredFieldsPresent)
            .filter(this::validatedFields)
            .count()
        println(count)
    }

    private fun createPassports(): ArrayList<Passport> {
        val passports = ArrayList<Passport>()
        var currentPassport = Passport()
        LINES.forEach { line ->
            if (line.isEmpty()) {
                passports.add(currentPassport)
                currentPassport = Passport()
            } else {
                val keyVal = createKeyValueMap(line)
                keyVal.forEach() {
                    when (it.key) {
                        "byr" -> currentPassport.byr = it.value
                        "iyr" -> currentPassport.iyr = it.value
                        "eyr" -> currentPassport.eyr = it.value
                        "hgt" -> currentPassport.hgt = it.value
                        "hcl" -> currentPassport.hcl = it.value
                        "ecl" -> currentPassport.ecl = it.value
                        "pid" -> currentPassport.pid = it.value
                        "cid" -> currentPassport.cid = it.value
                        else -> throw IllegalArgumentException("Unknown: " + it.key)
                    }
                }
            }
        }
        passports.add(currentPassport)
        return passports
    }

    private fun requiredFieldsPresent(passport: Passport) = passport.byr.isNotEmpty() &&
            passport.iyr.isNotEmpty() &&
            passport.eyr.isNotEmpty() &&
            passport.hgt.isNotEmpty() &&
            passport.hcl.isNotEmpty() &&
            passport.ecl.isNotEmpty() &&
            passport.pid.isNotEmpty()

    private val validBirthYear: Predicate<String> = Predicate { it.toInt() in 1920..2002 }
    private val validIssueYear: Predicate<String> = Predicate { it.toInt() in 2010..2020 }
    private val validExpirationYear: Predicate<String> = Predicate { it.toInt() in 2020..2030 }
    private val validHeight: Predicate<String> = Predicate {
        val number = it.substring(0, it.length - 2)

        val unit = it.substring(it.length - 2)
        when (unit) {
            "cm" -> number.isNotEmpty() && number.toInt() in 150..193
            "in" -> number.isNotEmpty() && number.toInt() in 59..76
            else -> false
        }
    }
    private val validHairColor: Predicate<String> = Predicate { HEX_COLOR_MATCHER.matches(it) }
    private val validEyeColor: Predicate<String> = Predicate { it in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") }
    private val validPassportId: Predicate<String> = Predicate { DIGIT_MATCHER.matches(it) }

    private fun validatedFields(passport: Passport) =
        validBirthYear.test(passport.byr)
            .and(validIssueYear.test(passport.iyr))
            .and(validExpirationYear.test(passport.eyr))
            .and(validHeight.test(passport.hgt))
            .and(validHairColor.test(passport.hcl))
            .and(validEyeColor.test(passport.ecl))
            .and(validPassportId.test(passport.pid))

    private fun createKeyValueMap(it: String) = it.split(" ")
        .map { it.split(":") }
        .map { it[0] to it[1] }
        .toMap()

    class Passport() {
        var byr: String = ""
        var iyr: String = ""
        var eyr: String = ""
        var hgt: String = ""
        var hcl: String = ""
        var ecl: String = ""
        var pid: String = ""
        var cid: String = ""
    }
}
