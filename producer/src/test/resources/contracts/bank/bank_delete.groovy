import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        method 'DELETE'
        urlPath('/bank') {
            queryParameters {
                parameter 'id': 100
            }

        }
        headers {
            header('Content-Type': value(
                    producer(applicationJson())
            ))
        }
    }

    response {
        status 200
        body(
                100
        )
        headers {
            contentType(textPlain())
        }
    }
}