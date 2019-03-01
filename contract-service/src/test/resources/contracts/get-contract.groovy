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
                                id               : $(uuid()),
                                name             : $(nonEmpty()),
                                description      : $(nonEmpty()),
                                type             : $(regex('PHARMACY_MODEL|FAMILY_DOCTOR_MODEL|TELMED_MODEL|HMO_MODEL|FREE_CHOICE_OF_DOCTOR')),
                                isBasic          : $(anyBoolean()),
                                price            : $(aDouble()),
                                deductible       : $(anInteger()),
                                withAccidentCover: $(anyBoolean()),
                        ],
                        [
                                id         : $(uuid()),
                                name       : $(nonEmpty()),
                                description: $(nonEmpty()),
                                type       : $(regex('PLUS|PREMIUM')),
                                price      : $(aDouble()),
                        ],
                        [
                                id         : $(uuid()),
                                name       : $(nonEmpty()),
                                description: $(nonEmpty()),
                                type       : $(regex('HOSPITA_FLEX|HOSPITA_GENERAL|HOSPITA_FLEX_SEMI_PRIVATE|HOSTPITA_FLEX_PRIVATE|HOSPITA_SEMI_PRIVATE|HOSPITA_PRIVATE')),
                                price      : $(aDouble()),
                        ],
                        [
                                id         : $(uuid()),
                                name       : $(nonEmpty()),
                                description: $(nonEmpty()),
                                type       : $(anyOf('DENTAL')),
                                price      : $(aDouble()),
                        ],
                        [
                                id         : $(uuid()),
                                name       : $(nonEmpty()),
                                description: $(nonEmpty()),
                                type       : $(anyOf('PROTECT')),
                                price      : $(aDouble()),
                        ]
                ]
        )
    }
}
