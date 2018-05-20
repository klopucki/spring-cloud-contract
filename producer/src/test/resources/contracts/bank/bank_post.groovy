package contracts.greeting_controller

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        method 'POST'
        url("/bank")
        body([
                accountId : 1,
                address: "Wojciechowska 5"
        ])
        headers {
            header('Content-Type': value(
                    producer(applicationJson())
            ))
        }
    }

    response {
        status 200
        body([
                entityId: 1,
                accountId : 1,
                address: "Wojciechowska 5"
        ])
        headers {
            header('Content-Type': value(
                    producer(applicationJsonUtf8())
            ))
        }
    }
}