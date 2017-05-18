package com.objectpartners.plummer.kotlin

interface StatesService {
    fun getAll(): Collection<com.objectpartners.plummer.cashregister.State>
    fun getMatching(regex: String?): Collection<com.objectpartners.plummer.cashregister.State>
    fun getByName(name: String?): com.objectpartners.plummer.cashregister.State?
}
