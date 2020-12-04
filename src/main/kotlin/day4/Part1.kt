package day4

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val lines = Files.readAllLines(Paths.get("src/main/resources/day4.txt"))

    val passports = ArrayList<Passport>()
    var currentPassport = Passport()
    lines.forEach {
        if (it.isEmpty()) {
            passports.add(currentPassport)
            currentPassport = Passport()
        } else {
        val keyVal = it.split(" ").map {
            val keyVal = it.split(":")
            keyVal[0] to keyVal[1]
        }.toMap()
            keyVal.map {
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

    val count = passports.filter {
        !it.byr.isEmpty() &&
                !it.iyr.isEmpty() &&
                !it.eyr.isEmpty() &&
                !it.hgt.isEmpty() &&
                !it.hcl.isEmpty() &&
                !it.ecl.isEmpty() &&
                !it.pid.isEmpty()
    }.count()

    println(count)
}

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
