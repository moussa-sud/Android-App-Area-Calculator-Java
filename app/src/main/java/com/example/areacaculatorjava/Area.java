package com.example.areacaculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Area extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);





        Spinner shapes_spinner = findViewById(R.id.area_sp_shapes);

        EditText rectangel_width = findViewById(R.id.areas_et_rectangel_width);
        EditText rectangel_hieght = findViewById(R.id.areas_et_rectangel_hieght);


        EditText  circle_radius  = findViewById(R.id.areas_et_circle_raduis);


        EditText triangle_base  = findViewById(R.id.areas_et_triangle_base);
        EditText triangle_Height = findViewById(R.id.areas_et_triangle_hieght);


        TextView Result_View = findViewById(R.id.showResult);
        Button Calculate_Button = findViewById(R.id.area_bt_calculator);




        shapes_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch (position){
                    case 0 :
                        rectangel_width.setVisibility(View.VISIBLE);
                        rectangel_hieght.setVisibility(View.VISIBLE);
                        circle_radius.setVisibility(View.GONE);
                        triangle_base.setVisibility(View.GONE);
                        triangle_Height.setVisibility(View.GONE);
                        Calculate_Button.setText("Calculate Rectangle");



                        break;
                    case 1 :
                        rectangel_width.setVisibility(View.GONE);
                        rectangel_hieght.setVisibility(View.GONE);
                        circle_radius.setVisibility(View.VISIBLE);
                        triangle_base.setVisibility(View.GONE);
                        triangle_Height.setVisibility(View.GONE);
                        Calculate_Button.setText("Calculate Circle");

                        break;
                    case 2 :
                        rectangel_width.setVisibility(View.GONE);
                        rectangel_hieght.setVisibility(View.GONE);
                        circle_radius.setVisibility(View.GONE);
                        triangle_base.setVisibility(View.VISIBLE);
                        triangle_Height.setVisibility(View.VISIBLE);
                        Calculate_Button.setText("Calculate Triangle");

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }




        });




        Calculate_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double result  = 0 ;

                int index = shapes_spinner.getSelectedItemPosition();

                switch(index){

                    case 0 :


                        String widthStr = rectangel_width.getText().toString().trim();
                        String heightStr = rectangel_hieght.getText().toString().trim();

                        if (!widthStr.isEmpty() && !heightStr.isEmpty()) {

                            double width = Double.parseDouble(widthStr);
                            double height = Double.parseDouble(heightStr);
                            result = width * height;

                        } else {
                            Toast.makeText(getApplicationContext(), "Please Fill The Blank", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        break;
                    case 1:


                        String radiusStr = circle_radius.getText().toString().trim();

                        if (!radiusStr.isEmpty()) {
                            double radius = Double.parseDouble(radiusStr);
                            result = Math.round(Math.PI * Math.pow(radius, 2) * 1000.0) / 1000.0;
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Fill The Blank", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;

                    case 2:


                        String heightTStr = triangle_Height.getText().toString().trim();
                        String baseStr = triangle_base.getText().toString().trim();

                        if (!heightTStr.isEmpty() && !baseStr.isEmpty()) {
                            double heightT = Double.parseDouble(heightTStr);
                            double base = Double.parseDouble(baseStr);
                            result = 0.5 * base * heightT;
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Fill The Blank", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;


                }

                Result_View.setText(result+"");









            }
        });




    }
}