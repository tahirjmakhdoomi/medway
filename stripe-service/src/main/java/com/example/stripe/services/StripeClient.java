package com.example.stripe.services;

import com.stripe.Stripe;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Source;
import com.stripe.net.RequestOptions;
import com.stripe.param.ChargeCreateParams;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.SourceCreateParams;
import com.stripe.param.common.EmptyParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StripeClient {

    @Autowired
    StripeClient() {
        Stripe.apiKey = "sk_test_51HrPa4D2pk6iAljfZCbmdMQY1RmI8fhBJfAobEpNFDlrQhJMBnhwvXdVWKBI6ZcLKjmDg3JWxEpXKHI9rNHKd8Qc00vDlaVX89";
    }


    private String getCustomerId(Customer customer) throws Exception {
        return customer.getId();
    }
    private Customer getCustomer(String id) throws Exception {
        return Customer.retrieve(id);
    }

    public Charge chargeNewCard(String token, double amount,String name,String email) throws Exception {



        CustomerCreateParams customerCreateParams =
                CustomerCreateParams.builder()
                        .setEmail(email)
                        .setSource(token)
                        .setName(name)
                        .setAddress(
                                CustomerCreateParams.Address.builder()
                                        .setLine1("camac street")
                                        .setPostalCode("700104")
                                        .setCity("Kolkata")
                                        .setState("WB")
                                        .setCountry("INDIA")
                                        .build())
                        .build();

        Customer customer = Customer.create(customerCreateParams);

//        ChargeCreateParams chargeCreateParams =
//                ChargeCreateParams.builder()
//                        .setAmount(100L)
//                        .setCurrency("usd")
//                        .setDescription("Example charge")
//                        .setSource("src_1HtbUUD2pk6iAljfwRSujRjz")
//                        .setCustomer(customer.getId())
//                        .build();
        Map<String,Object> chargeCreateParams=new HashMap<String, Object>();
        chargeCreateParams.put("amount",(int)amount*100);
        chargeCreateParams.put("currency","inr");
        chargeCreateParams.put("description","medway");
        chargeCreateParams.put("customer",customer.getId());
        Charge charge = Charge.create(chargeCreateParams);
        return charge;
    }


}
