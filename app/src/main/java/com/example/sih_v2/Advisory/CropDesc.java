package com.example.sih_v2.Advisory;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.R;

import io.paperdb.Paper;

public class CropDesc extends AppCompatActivity {

    TextView Crop, Type, Variety, maturity, Zones, actualYield, predYield, accuracy;
    String  desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_desc);

        Crop = (TextView)findViewById(R.id.text);
        Type = (TextView)findViewById(R.id.crop);
        Variety = (TextView)findViewById(R.id.var);
        Intent intent = getIntent();
        String cropName = intent.getStringExtra("crop");
        String typeName = intent.getStringExtra("type");
        String varietyName = intent.getStringExtra("variety");
        Crop.setText(cropName);
        Type.setText(typeName);
        Variety.setText(varietyName);
        maturity = (TextView)findViewById(R.id.mat);
        Zones = (TextView)findViewById(R.id.zones);
        actualYield = (TextView)findViewById(R.id.actualYieldText);
        predYield = (TextView)findViewById(R.id.predYieldText);
        accuracy = (TextView)findViewById(R.id.accuracyText);


        assert cropName != null;
        assert typeName != null;
        assert varietyName != null;
        assert Zones != null;


        if (cropName.equals("Cereals")) {
            if (typeName.equals("Finger millet")) {
                maturity.setText("Late 125-130");
                Zones.setText("Konkan Region of MAHARASHTRA");
                actualYield.setText("32.5");
                predYield.setText("17");
                accuracy.setText("56.66%");
            } else if (typeName.equals("Maize")) {
                switch (varietyName) {
                    case "Hishell (MCH-42) (Hybrid)":   //||  ||  ||  ||  ||  || {
                        //maturity = (TextView)findViewById(R.id.mat);
                        maturity.setText("Kharif Crop Medium < 95 Days");
                        Zones.setText("Rajasthan Gujrat, Madhya Pradesh and Chhattisgarh");
                        actualYield.setText("75");
                        predYield.setText("52.19");
                        accuracy.setText("66.06");
                        break;

                    case "HM-12 (HKH 313) (Hybrid)":
                        maturity.setText("Kharif Crop Medium < 95 Days");
                        Zones.setText("Eastern UP Bihar Jharkhand and Odisha\n");
                        actualYield.setText("110");
                        predYield.setText("84.16");
                        accuracy.setText("76.5");
                        break;

                    case "KMH 3712 (Hybrid)":
                        maturity.setText("Kharif Crop Medium < 95 Days");
                        Zones.setText("Punjab, Haryana, Delhi, Uttar Pradesh, Bihar, Jharkhand, Odisha, Rajasthan, Gujarat, Madhya Pradesh, and Chhattisgarh\n");
                        actualYield.setText("91.4");
                        predYield.setText("64.21");
                        accuracy.setText("70.25");
                        break;

                    case "NMH-803 (Hybrid)":
                        maturity.setText("Kharif Crop Medium < 95 Days");
                        Zones.setText("Eastern Uttar Pradesh, Bihar, Jharkhand, Odisha, Gujarat, Rajasthan, Madhya Pradesh and Chhattisgarh in Kharif seasons\n");
                        actualYield.setText("91.4");
                        predYield.setText("64.32");
                        accuracy.setText("70.37");

                        break;
                    case "KMH-25K60 (Hybrid)":
                        maturity.setText("Kharif Crop Medium < 95 Days");
                        Zones.setText("Andhra Pradesh, Maharashtra, Karnataka and Tamil Nadu\n");
                        actualYield.setText("97.2");
                        predYield.setText("68.36");
                        accuracy.setText("70.32");
                        break;

                    case "KMH-3426 (Hybrid)":
                        maturity.setText("Kharif Crop Medium < 95 Days");
                        Zones.setText("Eastern Uttar Pradesh, Bihar, Odisha, Jharkhand, Rajasthan, Gujarat, Madhya Pradesh and Chhattisgarh in Kharif seasons\n");
                        actualYield.setText("112.4");
                        predYield.setText("82.5");
                        accuracy.setText("73.67");
                        break;

                    case "NMH-731 (Hybrid)":
                        maturity.setText("Kharif Crop Late >96 days");
                        Zones.setText("Gujarat, Rajasthan, Madhya Pradesh and Chhattisgarh in Kharif seasons\n");
                        actualYield.setText("93");
                        predYield.setText("63.09");
                        accuracy.setText("69.32");
                        break;

                    case "SMH-3904":
                        maturity.setText("Kharif Crop Late > 96 days");
                        Zones.setText("Gujarat, Rajasthan, Madhya Pradesh and Chhattisgarh\n");
                        break;

                        case "":
                        maturity.setText("Extra early < 75 days");
                        Zones.setText("Jammu and Kashmir, Himachal Pradesh and  Uttarakhand\n");
                        break;
                }
            } else if (typeName.equals("Pearl Millet")) {
                switch (varietyName) {
                    case "86M66 (MSH 226) (Hyrid)":   //||  ||  ||  ||  ||  || {
                        //maturity = (TextView)findViewById(R.id.mat);
                        maturity.setText("Late 90 days");
                        Zones.setText("Summer growing areas of Gujarat Maharashtra, Rajasthan & Tamil Nadu\n");
                        break;
                    case "86M86  (MH 1684) (Hybrid)":
                        maturity.setText("Late 80-85 Days");
                        Zones.setText("Rajasthan, Gujarat, Haryana, U.P, M.P, Punjab, Delhi, Maharashtra, Karnataka, Andhra Pradesh and Tamil Nadu\n");
                        break;
                    case "Kaveri Super Boss (Hybrid)  (MH 1553)":
                        maturity.setText("Late 80-85 Days");
                        Zones.setText("Rajasthan, Gujarat, Haryana, Punjab, Delhi, UP, Maharashtra, Karnataka, A.P and Tamil Nadu\n");
                        break;
                    case "MP-7792 (MH-1609)":
                        maturity.setText("Late 76 - 82 Total");
                        Zones.setText("Rajasthan, Gujarat, Haryana, U.P, M.P, Punjab, Delhi, Maharashtra, Karnataka, Andhra Pradesh and Tamil Nadu\n");
                        break;
                    case "MP-7872  (MH-1610)":
                        maturity.setText("Late 78-85 Days");
                        Zones.setText("Rajasthan, Gujarat, Haryana, U.P, M.P, Punjab, Delhi, Maharashtra, Karnataka, Andhra Pradesh and Tamil Nadu\n");
                        break;
                }
            } else if (typeName.equals("Rice")) {
                switch (varietyName) {
                    case "Arize Tej (HRI 169) (IET21411) (Hybrid)":   //||  ||  ||  ||  ||  || {
                        //maturity = (TextView)findViewById(R.id.mat);
                        maturity.setText("Mid early 122 - 126 Days");
                        Zones.setText("Bihar, Chhattisgarh, Gujarat, Andhra Pradesh and Tamil Nadu under irrigated timely sown condition in Kharif season\n");
                        break;
                    case "CO 4  (IET 21449)  (TNRH 174)":
                        maturity.setText("Medium 135-138");
                        Zones.setText("Tamil Nadu, Gujarat & Maharahtra under irrigated condition during Rabi season for Southern Zone & Kharif season for Western Zone\n");
                        break;
                    case "JKRH 3333 (IET 20759) (Hybrid)":
                        maturity.setText("Medium 135-138");
                        Zones.setText("West Bengal, Bihar, Chhattisgarh, Gujarat and Andhra Pradesh\n");
                        break;
                    case "NK 5251 (IET 19738) (Hybrid)":
                        maturity.setText("Medium Early 125-130\n");
                        Zones.setText("Tamil Nadu, Karnataka, Andhra Pradesh, Maharashtra, Gujarat\n");
                        break;
                    case "NPH 924-1 (IET 21255) (Hybrid)":
                        maturity.setText("Medium  120 - 128 Days\n");
                        Zones.setText("West Bengal and Assam under irrigated areas where Boro rice crop is grown\n");
                        break;
                    case "PNPH 24 (IET 21406)  (Hybrid)":
                        maturity.setText("Mid early 97 - 100 Days\n");
                        Zones.setText("Bihar, West Bengal and Odisha under irrigated non submersible conditions\n");
                        break;
                    case "RH-1531 (Frontline Gold) (IET 21404) (Hybrid)":
                        maturity.setText("Medium Early 125-130 Days\n");
                        Zones.setText("Madhya Pradesh, Uttar Pradesh, Andhra Pradesh and Karnataka\n");
                        break;
                    case "US 382 (IET 20727) (Hybrid)":
                        maturity.setText("Medium Early 115-128 Days");
                        Zones.setText("Tripura, Madhya Pradesh and  Karnataka\n");
                        break;
                }
            } else if (typeName.equals("Sorghum")) {
                switch (varietyName) {
                    case "CSH-27  (SPH-1644)":   //||  ||  ||  ||  ||  || {
                        //maturity = (TextView)findViewById(R.id.mat);
                        maturity.setText("Kharif/ Medium 104-108");
                        Zones.setText("Rajasthan, Gujarat, Uttar Pradesh, Andhra Pradesh, Tamil Nadu- Kharif hybrid\n");
                        break;
                    case "CSH28 (NSH54) (SPH 1647) (Hybrid)":
                        maturity.setText("Kharif/Medium 111");
                        Zones.setText("Maharashtra, Karnataka, MP, South Gujarat and North Andhra Pradesh\n");
                        break;
                    case "CSV 27  (SPV 1870)":
                        maturity.setText("Kharif/ Medium 113-119");
                        Zones.setText("Andhra Pradesh, Madhya Pradesh, Tamil Nadu and Haryana under rainfed condition in Kharif season\n");
                        break;
                    case "CSV 29 R (SPV 2033)":
                        maturity.setText("Rabi/Medium 118");
                        Zones.setText("Maharashtra, Karnataka and AP under deep black soils,  Rabi sorghum variety\n");
                        break;
                    case "CSV26  (SPV 1829)":
                        maturity.setText("Rabi/ Medium  115-117");
                        Zones.setText("Under shallow soils conditions of rabi sorghum growing areas of India, Rabi Sorghum variety\n");
                        break;
                    case "SPH-1629 (MLSH 296 Gold/DJ 2002) (Hybrid)":
                        maturity.setText("Kharif/ Medium  109");
                        Zones.setText("Bihar, West Bengal and Odisha under irrigated non submersible conditions\n");
                        break;
                }
            }
            else if (typeName.equals("Wheat")) {
                switch (varietyName) {
                    case "PBW 644":   //||  ||  ||  ||  ||  || {
                        //maturity = (TextView)findViewById(R.id.mat);
                        maturity.setText("Late  137-167 Days");
                        Zones.setText("Rajasthan, Gujarat, Uttar Pradesh, Andhra Pradesh, Tamil Nadu- Kharif hybrid\n");
                        break;
                    case "Pusa Pachheti (HD 3059)":
                        maturity.setText("Late 121 Days");
                        Zones.setText("Maharashtra, Karnataka, MP, South Gujarat and North Andhra Pradesh\n");
                        break;
                    case "TL  2969  (Triticale)":
                        maturity.setText("Late  152-187 Days");
                        Zones.setText("Andhra Pradesh, Madhya Pradesh, Tamil Nadu and Haryana under rainfed condition in Kharif season\n");
                        break;
                    case "UAS-428 (Durum)":
                        maturity.setText("Medium  108");
                        Zones.setText("Maharashtra, Karnataka and AP under deep black soils,  Rabi sorghum variety\n");
                        break;
                }
            }
        }


        else if (cropName.equals("Fibre")) {
            if (typeName.equals("Cotton")){
                maturity.setText("165-170  Total Days");
                Zones.setText("Punjab, Haryana, Rajasthan and Uttar Pradesh under normal sown and irrigated condition\n");
            }
            else if (typeName.equals("Jute")){
                maturity.setText("Not Available");
                Zones.setText("Tossa Jute growing belt of India for growing during mid-March to last week of April\n");
            }
            else if (typeName.equals("Mesta")){
                maturity.setText("Not Available");
                Zones.setText("Traditional Mesta growing belt of the country under mid and highland rainfed situations.\n");
            }
            else if (typeName.equals("Sun Hemp")){
                maturity.setText("Not Available");
                Zones.setText("Uttar Pradesh, Bihar, Rajasthan, Maharashtra, Odisha and Madhya Pradesh\n");
            }
        }

        else if(cropName.equals("Oil Seeds")){
            if (typeName.equals("Castor")){
                maturity.setText("Late  123-148 Days");
                Zones.setText("Gujarat, Rajasthan, Uttar Pradesh and Haryana\n");
            }
            else if (typeName.equals("Indian Mustard")){
                switch (varietyName){
                    case "CORAL-437  (PAC-437)":
                        maturity.setText("Medium  140-150");
                        Zones.setText("Punjab, Haryana, New Delhi, Jammu & Rajasthan under irrigated condition");
                        break;
                    case "Pant Rai-19 (PR-2006-1)":
                        maturity.setText("Medium early 99-133");
                        Zones.setText("Jammu & Kashmir, Punjab, Haryana, New Delhi under irrigated condition in Rabi season\n");
                        break;
                    case "RGN-229":
                        maturity.setText("Medium  140-150");
                        Zones.setText("Delhi, Haryana, Punjab, Jammu and all parts of Rajasthan, suitable for rainfed condition\n");
                        break;
                    case "RGN-236":
                        maturity.setText("Medium 126-128");
                        Zones.setText("Punjab, Haryana, New Delhi, Jammu and parts of Rajasthan for late sown irrigated condition in Rabi season\n");
                        break;
                }
            }
            else if (typeName.equals("Sesame")){
                switch (varietyName){
                    case "DSS-9":
                        maturity.setText("Medium  90-95 Days");
                        Zones.setText("Assured rainfall zone of Khandesh and adjoining areas of Vidharba, Marathwada region\n");
                        break;
                    case "JLT-408":
                        maturity.setText("Medium early 85-91");
                        Zones.setText("Assured rainfall zone of Khandesh and adjoining areas of Vidharba, Marathwada region\n");
                        break;
                }
            }
            else if (typeName.equals("Sun-flower")){
                switch (varietyName){
                    case "RSFH-130 (Bhadra)":
                        maturity.setText("Medium  95-98 Days");
                        Zones.setText("Zone-II (Karnataka)\n");
                        break;
                    case "RSFV-901 (Kanthi)":
                        maturity.setText("Medium early 85-91");
                        Zones.setText("Zone-II (Karnataka\n");
                        break;
                }
            }
        }




        else if(cropName.equals("Pulses")) {
            if (typeName.equals("Black Gram")) {
                maturity.setText("NA");
                Zones.setText("Maharashtra, Gujarat, Madhya Pradesh, Chhattisgarh, Bundelkhand region of Uttar Pradesh and part of Rajasthan\n");
            }
            else if(typeName.equals("Chick-pea")){
                switch (varietyName){
                    case "HK-4  (HK 05-169)":
                        maturity.setText("136 Days");
                        Zones.setText("Punjab, Haryana, Rajasthan, Uttar Pradesh & Uttrakhand\n");
                        break;
                    case "L-555 (GLK-26155)":
                        maturity.setText("Medium 140-146 Days");
                        Zones.setText("Punjab, Haryana, Rajasthan, Uttar Pradesh & Uttrakhand\n");
                        break;
                    case "Raj Vijay Gram 203 (RVG 203)":
                        maturity.setText("Medium 123-131 Days");
                        Zones.setText("Madhya Pradesh, Gujarat, Maharashtra, Bundel kh and areas of Uttar Pradesh and Southern Rajasthan\n");
                        break;
                }
            }
            else if (typeName.equals("Cowpea")) {
                maturity.setText("Medium 90 Days");
                Zones.setText("Karnataka, Kerala, Andhra Pradesh, Tamilnadu and Pondicherry (Rainfed Eco-system)\n");
            }
            else if (typeName.equals("Green gram (Moong)")) {
                maturity.setText("Medium 90 Days");
                Zones.setText("Karnataka, Andhra Pradesh, Tamilnadu and Pondicherry (Rainfed)\n");
            }
            else if (typeName.equals("Horse gram")) {
                maturity.setText("Medium 90 Days");
                Zones.setText("Gujarat,Rajasthan,  Uttarakhand, Jharkhand, Uttar Pradesh and Maharashtra under rainfed condition in kharif season\n");
            }
            else if (typeName.equals("Lentil")) {
                maturity.setText("Rabi Season / 90 Days");
                Zones.setText("Madhya Pradesh, Chhattisgarh, Parts of Rajasthan and  Bundelkhand of Uttar Pradesh under normal sown\n");
            }
        }

        else if(cropName.equals("Sugar Crops")) {
            if (typeName.equals("Sugar Cane")) {
               switch (varietyName){
                   case "Co 0237":
                       maturity.setText("Medium 180-210 Total");
                       Zones.setText("Punjab, Haryana, Rajasthan, Uttarakhand and Uttar Pradesh\n");
                       break;

                   case "Co 0403":
                       maturity.setText("Medium 180-210 Total");
                       Zones.setText("Peninsular zone of India\n");
                       break;

                   case "CoVSI-9805":
                       maturity.setText("Mid late 150-170");
                       Zones.setText("Maharashtta");
                       break;

                   case "Karan-9  (Co-05011)":
                       maturity.setText("Mid late 154-171");
                       Zones.setText("Punjab, Haryana, Rajasthan, Uttarakhand, Western and Central U.P.  under normal climatic condition\n");
                       break;

                   case "Pratap Ganna-1  (CoPk-05191)":
                       maturity.setText("Early 240-300 Days");
                       Zones.setText("Uttar Pradesh, Uttrakhand, Haryana, Punjab & Rajasthan\n");
                       break;

               }
            }
        }


        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView(Paper.book().read("language"));

    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        /*crop_descr.setText(resources.getString(R.string.crop_discription));
        type.setText(resources.getString(R.string.type));
        crop.setText(resources.getString(R.string.crop));
        variety.setText(resources.getString(R.string.variety));
        Maturity.setText(resources.getString(R.string.maturity));*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.language_en)
        {
            Paper.book().write("language","en");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_hi)
        {
            Paper.book().write("language","hi");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_ta)
        {
            Paper.book().write("language","ta");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_mr)
        {
            Paper.book().write("language","mr");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_bn)
        {
            Paper.book().write("language","bn");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_pa)
        {
            Paper.book().write("language","pa");
            updateView(Paper.book().read("language"));
        }

        return true;
    }

}