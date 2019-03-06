import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description "should return the contract for a given customer"

    request {
        method 'GET'
        urlPath('/contracts') {
            queryParameters {
                parameter 'customerId': value(consumer(matching("[0-9]+")), producer(1))
            }
        }
    }
    response {
        status 200
        headers {
            contentType applicationJsonUtf8()
        }
        body(

                products: [
                        [
                                id               : $(regex(uuid())),
                                productName             : $(consumer('Free choice of doctor'), producer(regex(nonBlank()))),
                                description      : $(consumer('If you’re ill, go straight to your family doctor, a specialist or a hospital'), producer(regex(nonBlank()))),
                                type             : $(consumer('FREE_CHOICE_OF_DOCTOR'), producer(regex('PHARMACY_MODEL|FAMILY_DOCTOR_MODEL|TELMED_MODEL|HMO_MODEL|FREE_CHOICE_OF_DOCTOR'))),
                                isBasic          : $(consumer(true), producer(regex(anyBoolean()))),
                                price            : $(consumer(347.70), producer(regex(aDouble()))),
                                deductible       : $(consumer(2500), producer(regex(positiveInt()))),
                                withAccidentCover: $(consumer(false), producer(regex(anyBoolean())))
                        ],
                        [
                                id         : $(regex(uuid())),
                                productName       : $(consumer('Generous Supplementary Insurance'), producer(regex(nonBlank()))),
                                description: $(consumer('Generous Supplementary Insurance'), producer(regex(nonBlank()))),
                                type       : $(consumer('PREMIUM'), producer(regex('PLUS|PREMIUM'))),
                                price      : $(consumer(45.70), producer(regex(aDouble()))),
                        ],
                        [
                                id         : $(regex(uuid())),
                                productName       : $(consumer('Single room'), producer(regex(nonBlank()))),
                                description: $(consumer('Stay on a private ward'), producer(regex(nonBlank()))),
                                type       : $(consumer('HOSPITA_PRIVATE'), producer(regex('HOSPITA_FLEX|HOSPITA_GENERAL|HOSPITA_FLEX_SEMI_PRIVATE|HOSTPITA_FLEX_PRIVATE|HOSPITA_SEMI_PRIVATE|HOSPITA_PRIVATE'))),
                                price      : $(consumer(177.70), producer(regex(aDouble()))),
                        ],
                        [
                                id         : $(regex(uuid())),
                                productName       : $(consumer('Dental check-ups and treatment'), producer(regex(nonBlank()))),
                                description: $(consumer('Dental check-ups and treatment'), producer(regex(nonBlank()))),
                                type       : $(anyOf('DENTAL')),
                                price      : $(consumer(96.50), producer(regex(aDouble()))),
                        ],
                        [
                                id         : $(regex(uuid())),
                                productName       : $(consumer('Financial and legal support'), producer(regex(nonBlank()))),
                                description: $(consumer('Protection in legal disputes with medical service providers regarding health insurance'), producer(regex(nonBlank()))),
                                type       : $(anyOf('PROTECT')),
                                price      : $(consumer(1.50), producer(regex(aDouble()))),
                        ]
                ]
        )
    }
}
