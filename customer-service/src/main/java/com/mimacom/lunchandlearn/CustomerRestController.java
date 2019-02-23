package com.mimacom.lunchandlearn;

import com.mimacom.lunchandlearn.address.CustomerAddressRestController;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{customerId}")
    public CustomerResource getCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
        Customer customer = customerService.getCustomer(customerId);
        CustomerResource customerResource = buildCustomerResource(customer);

        customerResource.add(ControllerLinkBuilder.linkTo(methodOn(CustomerAddressRestController.class)
                .updateCustomerAddress(customerId, null)).withRel("update-address"));

        return customerResource;
    }

    private CustomerResource buildCustomerResource(Customer customer) {
        return CustomerResource.builder()
                .name(customer.getFirstName() + " " + customer.getLastName())
                .birthDate(customer.getBirthDate())
                .email(customer.getEmail())
                .mobile(customer.getMobile())
                .gender(customer.getGender())
                .address(CustomerResource.Address.builder()
                        .streetName(customer.getStreetName())
                        .streetNr(customer.getStreetNr())
                        .postCode(customer.getPostCode())
                        .city(customer.getCity())
                        .build())
                .build();
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public void handleConstraintViolation(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), "customer not found");
    }

}
