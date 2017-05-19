package com.objectpartners.plummer.kotlin

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.nio.charset.StandardCharsets


fun loadCsv(filename: String): Collection<CSVRecord> {
    return CSVParser.parse(
            Application::class.java.getResource(filename),
            StandardCharsets.UTF_8,
            CSVFormat.DEFAULT).records
}