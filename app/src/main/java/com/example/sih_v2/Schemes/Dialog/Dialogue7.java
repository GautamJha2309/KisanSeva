package com.example.sih_v2.Schemes.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogue7 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Gramin Bhandaran Yojana")
                .setMessage(Html.fromHtml("<b>"+"Eligibility\n" + "</b><br>" +
                        "The godowns under this scheme should be outside the municipal limits.\n" + "<br><br>" +
                        "The minimum capacity under this scheme will be 50 MT. \n" + "<br><br>" +
                        "The maximum will be 10 thousand metric tons.\n" + "<br><br>" +
                        "The height of the warehouse should not be less than 4-5 meters.\n" + "<br><br>" +
                        "Under this scheme loan will be given for construction of godown.\n" + "<br><br>" +
                        "Subsidy will be provided to you on the loan given.\n"))
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        return builder.create();
    }
}
