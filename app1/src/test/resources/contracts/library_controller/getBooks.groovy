package contracts.library_controller

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        method 'GET'
        url("/library")
    }

    response {
        status 201
        body([
                title : "Harry Potter",
                author: "J. K. Rowling",
                isbn  : value(consumer('XXX'), producer(regex('[A-Z]{3}')))
        ])
        headers {
            header('Content-Type': value(
                    consumer('application/json;charset=UTF-8')
            ))
        }
    }
}


    mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DarchetypeVersion=RELEASE

mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=RELEASE