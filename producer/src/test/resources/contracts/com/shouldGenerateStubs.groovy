package com

import org.springframework.cloud.contract.spec.Contract

println "AAAAAAAA groovy"

Contract.make {
    name("gen from groovy")
    description("description")
    request {
        method 'GET'
        urlPath("/abc")
        headers {
            accept()
            contentType(applicationJson())
        }
    }
    response {
        status OK()
    }
}