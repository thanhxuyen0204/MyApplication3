package com.thanhxuyen.baiktra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[]= {"GREEN XMAS - GIÁNG SINH XANH", "KHUYẾN MÃI TỪ PASSIO COFFEE", "SIÊU ƯU ĐÃI","PASSIO KHAI TRƯƠNG - HẢI CHÂU","KHUYẾN MÃI TỪ PASSIO COFFEE",};
    String mDescription[]={"GREEN XMAS - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa giáng sinh lại đến đánh dấu sự.....","Từ 18h - 23h mỗi ngày, khi mua 01 ly size L các món Latte đá, Passio Choco,Passio Chill, .....",
            "Hãy cùng Passio XÕA XỊN SÒ với dòng thức uống CỰC XÕA, CỰC CHILL. Đặc biệt, giá YOLO chỉ 29k trong...","GREEN XMAS - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa giáng sinh lại đến đánh dấu sự.....",
            "Từ 18h - 23h mỗi ngày, khi mua 01 ly size L các món Latte đá, Passio Choco,Passio Chill, ....."};
    int images[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv);
        ImageView im_qu =(ImageView)findViewById(R.id.qua);
        ImageView im_dinhvi =(ImageView)findViewById(R.id.dinhvi);
        ImageView im_thbao =(ImageView)findViewById(R.id.tbao);
        ImageView im_canhan =(ImageView)findViewById(R.id.canhan);
        ImageButton imageButton=(ImageButton)findViewById(R.id.menu);
        MyAdapter adapter = new MyAdapter( this, mTitle,mDescription,images);
        listView.setAdapter(adapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, gridviewActivity.class);
                startActivity(intent);
            }
        });
        im_qu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        im_thbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, notificationActivity.class);
                startActivity(intent);
            }
        });
        im_canhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, profileActivity.class);
                startActivity(intent);
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        MyAdapter (Context c, String title[], String description[], int imgs[] ){
            super(c,R.layout.activity_list, R.id.textview1,title);
            this.context =c;
            this.rTitle=title;
            this.rDescription=description;
            this.rImgs=imgs;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.activity_list,parent, false);
            ImageView images= row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }

    }
}