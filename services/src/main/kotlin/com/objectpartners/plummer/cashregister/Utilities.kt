package com.objectpartners.plummer.cashregister

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser

fun parseCsvFile(filename: String): Collection<Array<String>> {
    return CSVParser.parse(filename, CSVFormat.DEFAULT)
            .map { record -> arrayOf(record[0], record[1])}
}
