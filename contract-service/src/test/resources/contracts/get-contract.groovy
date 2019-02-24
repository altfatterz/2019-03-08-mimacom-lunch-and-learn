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
                                name             : "Basic health insurance",
                                description      : "If you’re ill, always go to your chosen family doctor first.",
                                type             : "FAMILY_DOCTOR_MODEL",
                                isBasic          : true,
                                price            : 295.6,
                                deductible       : 2500,
                                withAccidentCover: true,
                        ],
                        [
                                name       : "Supplementary outpatient insurance",
                                description: "Basic supplementary insurance for preventative measures, spectacles, sport and more",
                                type       : "PLUS",
                                price      : 19.6,
                        ],
                        [
                                name       : "Supplementary hospital insurance",
                                description: "Multiple occupancy rooms across Switzerland",
                                type       : "HOSPITA_FLEX",
                                price      : 9.4,
                        ],
                        [
                                name       : "Supplementary dental insurance",
                                description: "Coverage 50%, max. CHF 1000",
                                type       : "DENTAL",
                                price      : 26,
                        ],
                        [
                                name       : "Legal expenses insurance in health matters",
                                description: "Protection in legal disputes with medical service providers regarding health insurance",
                                type       : "PROTECT",
                                price      : 1.5,
                        ]
                ]
        )
    }
}
