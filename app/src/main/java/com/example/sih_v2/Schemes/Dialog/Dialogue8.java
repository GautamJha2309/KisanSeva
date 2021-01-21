package com.example.sih_v2.Schemes.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogue8 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Kisan Credit Card")
                .setMessage(Html.fromHtml("<b>"+"Objectives:\n" + "</b>" +
                        "\nTo meet the short term credit requirements for cultivation of crops, post harvest expenses, produce marketing loan, consumption requirements of farmer household, working capital for maintenance of farm assets and activities allied to agriculture like dairy animals, inland fishery etc. investment credit requirement for agriculture and allied activities like pump sets, sprayers, dairy animals etc.\n"+ "<br>"+"<br>"+
                        "<b>"+"\nEligibility: "+"</b>"+ "Farmers - individual/joint borrowers who\n" +
                        "are owner cultivators;\n" + "<br>" +
                        "Tenant farmers, oral lessees & share\n" +
                        "croppers;\n" + "<br>" +
                        "Self Help Groups (SHGs) or Joint Liability\n" +
                        "Groups (JLGs) of farmers including tenant\n" +
                        "farmers, share croppers etc." ))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        return builder.create();
    }
}
