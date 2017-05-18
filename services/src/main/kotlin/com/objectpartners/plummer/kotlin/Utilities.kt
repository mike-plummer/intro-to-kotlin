package com.objectpartners.plummer.kotlin

fun parseCsvFile(filename: String): Collection<Array<String>> {
    return org.apache.commons.csv.CSVParser.parse(filename, org.apache.commons.csv.CSVFormat.DEFAULT)
            .map { record -> arrayOf(record[0], record[1])}
}
