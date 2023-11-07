package dev.n9mac.pharaoh.learncorespringframework

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired
    private WebController webController

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        webController
    }

}