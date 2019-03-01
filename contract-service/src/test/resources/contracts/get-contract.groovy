import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description "should return the contract for a given customer"

    request {
        method 'GET'
        url '/contracts?customerId=1'
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
                                name             : $(regex(nonBlank())),
                                description      : $(regex(nonBlank())),
                                type             : $(regex('PHARMACY_MODEL|FAMILY_DOCTOR_MODEL|TELMED_MODEL|HMO_MODEL|FREE_CHOICE_OF_DOCTOR')),
                                isBasic          : $(regex(anyBoolean())),
                                price            : $(regex(aDouble())),
                                deductible       : $(regex(anInteger())),
                                withAccidentCover: $(regex(anyBoolean())),
                        ],
                        [
                                id         : $(regex(uuid())),
                                name       : $(regex(nonBlank())),
                                description: $(regex(nonBlank())),
                                type       : $(regex('PLUS|PREMIUM')),
                                price      : $(regex(aDouble())),
                        ],
                        [
                                id         : $(regex(uuid())),
                                name       : $(regex(nonBlank())),
                                description: $(regex(nonBlank())),
                                type       : $(regex('HOSPITA_FLEX|HOSPITA_GENERAL|HOSPITA_FLEX_SEMI_PRIVATE|HOSTPITA_FLEX_PRIVATE|HOSPITA_SEMI_PRIVATE|HOSPITA_PRIVATE')),
                                price      : $(regex(aDouble())),
                        ],
                        [
                                id         : $(regex(uuid())),
                                name       : $(regex(nonBlank())),
                                description: $(regex(nonBlank())),
                                type       : $(anyOf('DENTAL')),
                                price      : $(regex(aDouble())),
                        ],
                        [
                                id         : $(regex(uuid())),
                                name       : $(regex(nonBlank())),
                                description: $(regex(nonBlank())),
                                type       : $(anyOf('PROTECT')),
                                price      : $(regex(aDouble())),
                        ]
                ]
        )
    }
}
