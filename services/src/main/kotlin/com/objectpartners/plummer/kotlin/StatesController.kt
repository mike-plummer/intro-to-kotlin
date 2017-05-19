package com.objectpartners.plummer.kotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.objectpartners.plummer.kotlin.domain.StateResource

@RestController
@RequestMapping("/states")
open class StatesController {

    @Autowired
    lateinit var service: StatesService

    @GetMapping
    fun get(@RequestParam(value = "pattern", required = false) pattern: String?): Collection<StateResource> {
        if (pattern != null) {
            return service.getMatching(pattern)
        }
        return service.getAll()
    }

    @GetMapping("{name}")
    fun getByName(@PathVariable("name") name: String?): StateResource? {
        return service.getByName(name)
    }
}
