package com.example.dell.trippy;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarsFrag extends Fragment {
    RadioGroup rg;
public int c,f=0,nu;
    EditText d;
    String n="0",dis="\0";
    public CarsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View rootView = inflater.inflate(R.layout.fragment_cars, container, false);

        rg=(RadioGroup)rootView.findViewById(R.id.radg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton r1 = (RadioButton) rootView.findViewById(R.id.rad1);

                {if(r1.isChecked())
                {   f=75;
                    //Toast.makeText(getContext(),"PETROL",Toast.LENGTH_LONG).show();
                }
                else{f=60;
                   // Toast.makeText(getContext(),"DIESEL",Toast.LENGTH_LONG).show();

                }}

            }
        });


        Spinner s = (Spinner)rootView.findViewById(R.id.spinnercars);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int idd = (int) id;
                switch (idd) {
                    case 0:
                        c = 16;
                       // Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        c = 15;
                        //                     Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();                       break;
                    case 2:
                        c = 11;

                        //                   Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        c = 16;
                        //                 Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        c = 18;
                        //               Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        c = 15;
                        //             Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        c = 15;
                        //           Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        c = 14;
                        //         Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();

                        break;
                    case 8:
                        c = 11;
                        //       Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        c = 12;
                        //     Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        c = 15;
                        //   Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        c = 16;
                        // Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 12:
                        c = 14;

                        //Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                        c = 19;
//                       Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 14:
                        c = 17;
                        //                     Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 15:
                        c = 18;
                        //                   Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 16:
                        c = 10;
                        //                 Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 17:
                        c = 16;
                        //               Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 18:
                        c = 11;
                        //             Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 19:
                        c = 12;
                        //           Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 20:
                        c = 15;
                        //         Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 21:
                        c = 15;
                        //       Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 22:
                        c = 14;
                        //     Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 23:
                        c = 15;
                        //   Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 24:
                        c = 18;
                        // Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 25:
                        c = 12;
//                       Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 26:
                        c = 11;
                        //                     Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();break;
                    case 27:
                        c = 11;
//                       Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();

                        break;
                    case 28:
                        c = 12;
                        //                     Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 29:
                        c = 12;
                        //                   Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 30:
                        c = 10;
                        //                 Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 31:
                        c = 14;
                        //               Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 32:
                        c = 14;
                        //             Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 33:
                        c = 12;
                        //           Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 34:
                        c = 15;
                        //         Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;
                    case 35:
                        c = 13;
                        //       Toast.makeText(parent.getContext(), "Average is " + c + "km/lt.", Toast.LENGTH_SHORT).show();
                        break;


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner ss = (Spinner)rootView.findViewById(R.id.spinnerpeople);
        ss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nu = (int) id;
                nu = nu + 1;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button b = (Button)rootView.findViewById(R.id.button3);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                d=(EditText)rootView.findViewById(R.id.takedis);
                dis = d.getText().toString();

                {
                    if (f==0){
                    Toast.makeText(getContext(), "Select PETROL or DIESEL", Toast.LENGTH_SHORT).show();

                }
                    else if (dis.isEmpty()) {
                        Toast.makeText(getContext(), "Enter Distance", Toast.LENGTH_SHORT).show();
                    }
                    else {
                    Intent i = new Intent(getActivity(), popup.class);
                    n = d.getText().toString();
                    //dis=Integer.parseInt(n);
                    int res = ((f / c) / nu);
                    SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getContext());
                    data.edit().putInt("pp", res).apply();
                    data.edit().putString("distance", n).apply();
                    //Toast.makeText(getContext(),dis,Toast.LENGTH_LONG).show();
                    startActivity(i);
                }
            }}
        });

        return rootView;
    }



}
