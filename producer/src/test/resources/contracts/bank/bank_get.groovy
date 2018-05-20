import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        method 'GET'
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
        body([
                entityId: 100,
                accountId : 1,
                address: "Watykańska"
        ])
        headers {
            contentType(applicationJson())
        }
    }
}