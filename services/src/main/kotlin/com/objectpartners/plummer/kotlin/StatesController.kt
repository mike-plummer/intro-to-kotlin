package com.objectpartners.plummer.kotlin

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping
open class StatesController {

    @org.springframework.beans.factory.annotation.Autowired
    lateinit var statesService: StatesService;

    @org.springframework.web.bind.annotation.GetMapping
    fun get(@org.springframework.web.bind.annotation.RequestParam(value = "regex", required = false) regex: String?): Collection<State> {
        if (regex != null) {
            return statesService.getMatching(regex)
        }

        return statesService.getAll()
    }

    @org.springframework.web.bind.annotation.GetMapping("{name}")
    fun getByName(@org.springframework.web.bind.annotation.PathVariable("name") name: String?): State? {
        return statesService.getByName(name)
    }
}
