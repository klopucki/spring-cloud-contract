package contracts.greeting_controller

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("return greeting John info")

    request {
        method 'POST'
        urlPath( '/greeting'){
            queryParameters {
                parameter 'name': 'John'
            }
        }
    }

    response {
        status 200
        body("HELLO John")
        headers {
            header('Content-Type': value(
                    producer(regex('text/plain;charset=ISO-8859-1')),
                    consumer('text/plain;charset=ISO-8859-1')
            ))
        }
    }
}