package me.ryan.black.hoody.api.domain

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class SampleController {

    @GetMapping("/")
    fun index(model: Model, principal: Principal): String {
        model.addAttribute("message", "Hello~!! ${principal.name}")
        return "index"
    }

    @GetMapping("/info")
    fun info(model: Model): String {
        model.addAttribute("message", "Info")
        return "info"
    }

    @GetMapping("/dashboard")
    fun dashboard(model: Model, principal: Principal): String {
        model.addAttribute("message", "Hello~!! ${principal.name}")
        return "dashboard"
    }

    @GetMapping("/admin")
    fun admin(model: Model, principal: Principal): String {
        model.addAttribute("message", "Hello Admin~!! ${principal.name}")
        return "admin"
    }
}
