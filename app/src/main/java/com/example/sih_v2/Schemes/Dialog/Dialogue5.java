package com.example.sih_v2.Schemes.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogue5 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pradhan Mantri Kisan Maandhan Yojana")
                .setMessage(Html.fromHtml( "<b>" + "Objective: " + "</b> <br>"+
                        "It is a government scheme meant for old age protection and social security of Small and Marginal Farmers (SMF). All Small and Marginal Farmers having cultivable landholding up to 2 hectares falling in the age group of 18 to 40 years, whose names appear in the land records of States/UTs as on 01.08.2019 are eligible to get benefit under the Scheme.\n" + "<br><br>"+
                        "<b>" + "Eligibility\n" + "</b><br><br>"+
                        "For Small and Marginal Farmers\n" + "<br><br>"+
                        "\t Entry Age between 18 to 40 years\n" + "<br><br>"+
                        "\t Cultivable land up to 2 hectares as per land records of the concerned State/UT\n" + "<br><br>"+
                        "<b>"+"Features\n" + "</b><br><br>"+
                        "\tAssured pension of Rs. 3000/- month\n" + "<br><br>"+
                        "\tVoluntary and Contributory Pension Scheme\n" + "<br><br>"+
                        "\tMatching Contribution by the Government of India\n"))
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        return builder.create();
    }
}
