package com.example.sih_v2.Schemes.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogue3 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Paramparagat Krishi Vikas Yojana ")
                .setMessage(Html.fromHtml("<b>"+"Objectives of PKVY Scheme"+"</b> <br>"+
                        "To promote eco-friendly concept of\n" +
                        "cultivation reducing the dependency on\n" +
                        "agro-chemicals and fertilizers.\n" + "<br><br>"+
                        "To optimally utilize the locally available\n" +
                        "natural resources for input production.\n" + "<br><br>"+
                        "To promote use of local indigenous\n" +
                        "traditional techniques for management of\n" +
                        "plant nutrition and plant protection.\n" + "<br><br>"+
                        "To develop potential markets for organic\n" +
                        "products"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        return builder.create();
    }
}
