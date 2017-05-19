package com.objectpartners.plummer.kotlin

import com.objectpartners.plummer.kotlin.domain.StateResource
import org.springframework.stereotype.Service

@Service
open class StatesServiceImpl: StatesService {

    object DATA {
        val STATES: Collection<StateResource> = loadCsv("/data.csv")
                .map { record -> arrayOf(record.get(0), record.get(1)) }
                .map { row -> StateResource(row[0], row[1]) }
    }

    override fun getAll(): Collection<StateResource> {
        return DATA.STATES
    }

    override fun getMatching(pattern: String?): Collection<StateResource> {
        if (pattern == null) {
            return emptyList()
        }
        val regex = Regex(pattern)
        return DATA.STATES
                .filter { (name) -> regex.containsMatchIn(name) }
    }

    override fun getByName(nameToFind: String?): StateResource? {
        if (nameToFind == null) {
            return null
        }

        return DATA.STATES
                .find { (name) -> name == nameToFind }
    }

}