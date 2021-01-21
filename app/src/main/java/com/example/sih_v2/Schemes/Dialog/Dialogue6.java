package com.example.sih_v2.Schemes.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogue6 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Soil Health Card Scheme")
                .setMessage(Html.fromHtml( "<b>"+"Objective: "+ "</b><br>"+
                        "Soil Health Card Scheme is a scheme launched by the Government of India in 19 February 2015. Under the scheme, the government plans to issue soil cards to farmers which will carry crop-wise recommendations of nutrients and fertilisers required for the individual farms to help farmers to improve productivity through judicious use of inputs. \n" +
                        "\n" + "<br><br>"+
                        "<b>"+"Function\n" + "</b><br>"+
                        "The authorities of the scheme collect various soil samples and these samples will be sent to the testing laboratories where experts would conduct tests on the samples." +"<br><br>"+
                        "Soil samples are drawn by the State Government by the Department of Agriculture staffs by using GPS tools and revenue maps in a grid of  2.5 ha in irrigated area and 10 ha in rain-fed area." + "<br><br>" +
                        "Once testing is done, the experts analyze the soil samples and note the strengths and weaknesses of the soil." + "<br><br>" +
                        "If there can be changes made to improve the nutrients of the soil, then experts will give suggestions to make the changes.\n"))
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        return builder.create();
    }
}
