package com.sangeetagupta1998.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.CardRequirements;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.TransactionInfo;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.WalletConstants;

import java.util.Arrays;

public class PaymentActivity extends AppCompatActivity {

    Button buy,menu;
    private PaymentsClient mPaymentsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        initialize();
        setClickListener();
    }

    public void initialize(){

        buy = findViewById(R.id.buy);
        menu = findViewById(R.id.backToMenu);
        mPaymentsClient = Wallet.getPaymentsClient(this, new Wallet.WalletOptions.Builder().setEnvironment(WalletConstants.ENVIRONMENT_TEST).build());

    }

    public void setClickListener() {

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PaymentDataRequest request = createPaymentDataRequest();
                if (request != null) {
                    AutoResolveHelper.resolveTask(
                            mPaymentsClient.loadPaymentData(request),
                            PaymentActivity.this, 1);

                }
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {;
                Toast.makeText(getApplicationContext(), "Takes to Main Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PaymentActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });

    }

    private PaymentDataRequest createPaymentDataRequest() {
        PaymentDataRequest.Builder request =
                PaymentDataRequest.newBuilder()
                        .setTransactionInfo(
                                TransactionInfo.newBuilder()
                                        .setTotalPriceStatus(WalletConstants.TOTAL_PRICE_STATUS_FINAL)
                                        .setTotalPrice("10.00")
                                        .setCurrencyCode("USD")
                                        .build())
                        .addAllowedPaymentMethod(WalletConstants.PAYMENT_METHOD_CARD)
                        .addAllowedPaymentMethod(WalletConstants.PAYMENT_METHOD_TOKENIZED_CARD)
                        .setCardRequirements(
                                CardRequirements.newBuilder()
                                        .addAllowedCardNetworks(
                                                Arrays.asList(
                                                        WalletConstants.CARD_NETWORK_AMEX,
                                                        WalletConstants.CARD_NETWORK_DISCOVER,
                                                        WalletConstants.CARD_NETWORK_VISA,
                                                        WalletConstants.CARD_NETWORK_MASTERCARD))
                                        .build());

        PaymentMethodTokenizationParameters params =
                PaymentMethodTokenizationParameters.newBuilder()
                        .setPaymentMethodTokenizationType(
                                WalletConstants.PAYMENT_METHOD_TOKENIZATION_TYPE_PAYMENT_GATEWAY)
                        .addParameter("gateway", "example")
                        .addParameter("gatewayMerchantId", "exampleGatewayMerchantId")
                        .build();

        request.setPaymentMethodTokenizationParameters(params);
        return request.build();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        PaymentData paymentData = PaymentData.getFromIntent(data);
                        String token = paymentData.getPaymentMethodToken().getToken();
                        break;
                    case Activity.RESULT_CANCELED:
                        break;
                    case AutoResolveHelper.RESULT_ERROR:
                        Status status = AutoResolveHelper.getStatusFromIntent(data);
                        break;
                    default:
                }
                break;
            default:
        }
    }
}
