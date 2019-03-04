import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label "move_to_different_region"
    input {
        triggeredBy "moveToDifferentRegion()"
    }
    outputMessage {
        sentTo "customer-updates"
        body(
                customerId: $(anInteger()),
                currentAddress: [
                        streetName: $(nonBlank()),
                        streetNr  : $(nonBlank()),
                        city      : $(nonBlank()),
                        postCode  : $(nonBlank()),
                        canton    : 'Zurich'
                ],
                newAddress: [
                        streetName: $(nonBlank()),
                        streetNr  : $(nonBlank()),
                        city      : $(nonBlank()),
                        postCode  : $(nonBlank()),
                        canton    : 'Bern'
                ]
        )
        headers {
            header("contentType", applicationJson())
        }
    }
}
