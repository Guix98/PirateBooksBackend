package bo.edu.ucb.sis.piratebay.service;

import bo.edu.ucb.sis.piratebay.model.PaymentIntentModel;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
    @Value("${stripe.key.secret}")
    String secretKey;
    public PaymentIntent paymentIntent (PaymentIntentModel paymentIntentModel) throws StripeException {
        Stripe.apiKey = secretKey;


        List<Object> paymentMethodTypes =
                new ArrayList<>();
        paymentMethodTypes.add("card");
        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentIntentModel.getAmount());
        params.put("currency", paymentIntentModel.getCurrency());
        params.put("description", paymentIntentModel.getDescription());
        params.put(
                "payment_method_types",
                paymentMethodTypes
        );

        return PaymentIntent.create(params);
    }
    public PaymentIntent confirm (String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent =
                PaymentIntent.retrieve(id);

        Map<String, Object> params = new HashMap<>();
        params.put("payment_method", "pm_card_visa");

        paymentIntent.confirm(params);

        return paymentIntent;
    }
    public PaymentIntent cancel (String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
                paymentIntent.cancel();
        return paymentIntent;
    }

}
