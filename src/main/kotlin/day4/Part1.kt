package day4

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val lines = Files.readAllLines(Paths.get("src/main/resources/day4.txt"))

    val passports = ArrayList<Passport>()
    var currentPassport = Passport()
    lines.forEach { line ->
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

    val count = passports.filter {
        requiredFieldsPresent(it)
    }.count()

    println(count)
}

private fun requiredFieldsPresent(passport: Passport) = passport.byr.isNotEmpty() &&
        passport.iyr.isNotEmpty() &&
        passport.eyr.isNotEmpty() &&
        passport.hgt.isNotEmpty() &&
        passport.hcl.isNotEmpty() &&
        passport.ecl.isNotEmpty() &&
        passport.pid.isNotEmpty()

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

    override fun toString(): String {
        return "{byr: $byr, iyr: $iyr, eyr: $eyr, hgt: $hgt, hcl: $hcl, ecl: $ecl, pid: $pid, cid: $cid}"
    }
}
