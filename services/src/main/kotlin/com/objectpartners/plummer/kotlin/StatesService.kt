package com.objectpartners.plummer.kotlin

import com.objectpartners.plummer.kotlin.domain.StateResource

interface StatesService {
    fun getAll(): Collection<StateResource>
    fun getMatching(pattern: String?): Collection<StateResource>
    fun getByName(nameToFind: String?): StateResource?
}
