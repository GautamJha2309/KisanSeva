package com.example.sih_v2.Schemes.Dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogue2 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pradhanmantri Krishi Sinchai Yojana")
                .setMessage(Html.fromHtml("<b>"+"Objectives:\n"+"</b><br>" +
                        "Developing a long term solution for\n" +
                        "mitigating the effect of drought and\n" +
                        "increasing area under irrigation with motto\n" +
                        "of Har Khet Ko Pani.\n" + "<br><br>"+
                        "Achieve convergence of investments in irrigation at the field level." + "<br><br>"+
                        "Expand cultivable area under assured\n" +
                        "irrigation\n" + "<br><br>"+
                        "Improve on-farm water use efficiency to\n" +
                        "reduce wastage of water\n" + "<br><br>"+
                        "Enhance the adoption of precision irrigation\n" +
                        "and other water saving technologies (More\n" +
                        "crop per drop),\n" + "<br><br>"+
                        "Promote sustainable water conservation\n" +
                        "practices etc. "))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        return builder.create();
    }
}
