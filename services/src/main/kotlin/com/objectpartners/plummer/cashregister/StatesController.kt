package com.objectpartners.plummer.cashregister

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
open class StatesController {

    @Autowired
    lateinit var statesService: StatesService;

    @GetMapping
    fun get(@RequestParam(value = "regex", required = false) regex: String?): Collection<State> {
        if (regex != null) {
            return statesService.getMatching(regex)
        }

        return statesService.getAll()
    }

    @GetMapping("{name}")
    fun getByName(@PathVariable("name") name: String?): State? {
        return statesService.getByName(name)
    }
}
