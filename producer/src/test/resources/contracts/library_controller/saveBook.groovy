package contracts.library_controller

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    label 'saveBook'
    request {
        method 'POST'
        url("/library")
        body([
                title : "God Father",
                author: "Mario Puzo",
                isbn  : "XX5"
        ])
        headers {
            header('Content-Type': value(
                    producer('application/json')
            ))
        }
    }

    response {
        status 200
        body([
                title : $(fromRequest().body('$.title')),
                author: $(fromRequest().body('$.author')),
                isbn  : value(producer(regex('[A-Z]{2}5')))
        ])
    }
}