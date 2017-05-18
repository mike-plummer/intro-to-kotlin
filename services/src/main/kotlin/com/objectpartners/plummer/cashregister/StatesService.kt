package com.objectpartners.plummer.cashregister

interface StatesService {
    fun getAll(): Collection<State>
    fun getMatching(regex: String?): Collection<State>
    fun getByName(name: String?): State?
}
