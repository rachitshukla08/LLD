package fooddeliverysystem.factory;

import fooddeliverysystem.managers.CardBasedPaymentManager;
import fooddeliverysystem.managers.NetBankingPaymentManager;
import fooddeliverysystem.managers.PaymentManager;

import java.util.Map;

public class PaymentManagerFactory {
    private PaymentManagerFactory(){}

    public static PaymentManager getPaymentManager(String paymentMode, Map<String, String> paymentInfo){
        PaymentManager paymentManager = null;
        if(paymentMode.equals("netbanking"))
            paymentManager = getNetBankingPaymentManager(paymentInfo);
        else if(paymentMode.equals("card"))
            paymentManager = getCardBasedPaymentManager(paymentInfo);
        else
            throw new RuntimeException("Invalid payment type");
        return paymentManager;
    }

    private static PaymentManager getNetBankingPaymentManager(Map<String, String> paymentInfo) {
        return new NetBankingPaymentManager(paymentInfo.get("bankName"),
                paymentInfo.get("username"),
                paymentInfo.get("password"),
                paymentInfo.get("pin"),
                Double.parseDouble(paymentInfo.get("amount")));
    }

    private static PaymentManager getCardBasedPaymentManager(Map<String, String> paymentInfo) {
        return new CardBasedPaymentManager(paymentInfo.get("bankName"),
                paymentInfo.get("card"),
                paymentInfo.get("pin"),
                Double.parseDouble(paymentInfo.get("amount")));
    }
}
