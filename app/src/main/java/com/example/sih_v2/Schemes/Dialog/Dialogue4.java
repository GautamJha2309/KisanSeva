package com.example.sih_v2.Schemes.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialogue4 extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pradhan Mantri Kisan Samman Nidhi")
                .setMessage(Html.fromHtml("<b>"+ "Objective\n" + "</b> <br>" +
                        "PM Kisan is a Central Sector scheme with 100% funding from Government of India.\n" + "<br><br>"+
                        "It has become operational from 1.12.2018.\n" + "<br><br>"+
                        "Under the scheme an income support of 6,000/- per year in three equal installments will be provided to small and marginal farmer families having combined land holding/ownership of upto 2 hectares.\n" + "<br><br>"+
                        "Definition of family for the scheme is husband, wife and minor children.\n" + "<br><br>"+
                        "State Government and UT administration will identify the farmer families which are eligible for support as per scheme guidelines.\n" + "<br><br>"+
                        "The fund will be directly transferred to the bank accounts of the beneficiaries.\n" + "<br><br>"+
                        "The first instalment for the period 1.12.2018 to 31.03.2019 is to be provided in the financial year itself.\n" + "<br><br>"+
                        "There are various Exclusion Categories for the scheme.\n" + "<br><br>"+ "<b>" + "Eligibility" + "</b> <br>" +
                        "All Institutional Land holders.\n" + "<br><br>"+
                        "Farmer families which belong to one or more of the following categories:\n" + "<br>"+
                        "1. Former and present holders of constitutional posts\n" + "<br><br>"+
                        "2. Former and present Ministers/ State Ministers and former/present Members of LokSabha/ RajyaSabha/ State Legislative Assemblies/ State Legislative Councils,former and present Mayors of Municipal Corporations, former and present Chairpersons of District Panchayats.\n" + "<br><br>"+
                        "3. All serving or retired officers and employees of Central/ State Government Ministries /Offices/Departments and its field units Central or State PSEs and Attached offices /Autonomous Institutions under Government as well as regular employees of the Local Bodies\n" + "<br><br>"+
                        "4. All superannuated/retired pensioners whose monthly pension is Rs.10,000/-or more\n" + "<br><br>"+
                        "All Persons who paid Income Tax in last assessment year\n" + "<br><br>"+
                        "Professionals like Doctors, Engineers, Lawyers, Chartered Accountants, and Architects registered with Professional bodies and carrying out profession by undertaking practices.\n"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        return builder.create();
    }
}
