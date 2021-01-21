package com.example.sih_v2.Schemes.Dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogue1 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pradhanmantri Fasal Bima Yojana")
                .setMessage(Html.fromHtml("<b>"+"Features\n" + "</b> <br>" +
                        "Covers all food grains, oilseeds and annual\n" +
                        "commercial/Horticultural crops.\n" + "<br><br>"+
                        "One season one rate – a uniform maximum\n" +
                        "premium of 2% for Kharif, 1.5% for Rabi,\n" +
                        "Food & Oil seed crops and 5% for Annual\n" +
                        "Commercial/Horticultural Crops.\n" + "<br><br>"+
                        "Covers all risks of crop cycle – preventive\n" +
                        "sowing; risk to standing crops and post harvest losses.\n" + "<br><br>"+
                        "For losses due to hailstorm, landslide and\n" +
                        "inundation assessment of yield losses at\n" +
                        "individual field level.\n" + "<br><br>"+
                        "Post-harvest losses for cut& spread crops on\n" +
                        "field upto 14 days due to cyclone/cyclonic\n" +
                        "rains and unseasonal rains.\n" + "<br><br>"+
                        "On account payment upto 25% of sum\n" +
                        "insured due to prevented sowing or mid\n" +
                        "season adversity."))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        return builder.create();
    }
}
