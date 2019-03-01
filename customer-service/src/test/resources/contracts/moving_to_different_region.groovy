import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label "moving_to_different_region"
    input {
        triggeredBy "movingToDifferentRegion()"
    }
    outputMessage {
        sentTo "customer-updates"
        body(
                customerId: $(anInteger()),
                currentAddress: [
                        streetName: $(nonBlank()),
                        streetNr  : $(nonBlank()),
                        city      : 'Zurich',
                        postCode  : $(nonBlank()),
                ],
                newAddress: [
                        streetName: $(nonBlank()),
                        streetNr  : $(nonBlank()),
                        city      : 'Bern',
                        postCode  : $(nonBlank()),
                ]
        )
        headers {
            header("contentType", applicationJson())
        }
    }
}
