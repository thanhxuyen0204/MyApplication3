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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class notificationActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[]= {"GREEN XMAS - GIÁNG SINH XANH", "KHUYẾN MÃI TỪ PASSIO COFFEE", "SIÊU ƯU ĐÃI","PASSIO KHAI TRƯƠNG - HẢI CHÂU","KHUYẾN MÃI TỪ PASSIO COFFEE", "SIÊU ƯU ĐÃI","PASSIO KHAI TRƯƠNG - HẢI CHÂU","KHUYẾN MÃI TỪ PASSIO COFFEE"};
    String mDescription[]={"GREEN XMAS - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa giáng sinh lại đến đánh dấu sự.....","Từ 18h - 23h mỗi ngày, khi mua 01 ly size L các món Latte đá, Passio Choco,Passio Chill, .....",
            "Hãy cùng Passio XÕA XỊN SÒ với dòng thức uống CỰC XÕA, CỰC CHILL. Đặc biệt, giá YOLO chỉ 29k trong...","GREEN XMAS - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa giáng sinh lại đến đánh dấu sự.....",
            "Từ 18h - 23h mỗi ngày, khi mua 01 ly size L các món Latte đá, Passio Choco,Passio Chill, .....","Hãy cùng Passio XÕA XỊN SÒ với dòng thức uống CỰC XÕA, CỰC CHILL. Đặc biệt, giá YOLO chỉ 29k trong...","GREEN XMAS - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa giáng sinh lại đến đánh dấu sự.....",
            "Từ 18h - 23h mỗi ngày, khi mua 01 ly size L các món Latte đá, Passio Choco,Passio Chill, ....."};
    int images[]={R.drawable.tb1,R.drawable.tb2,R.drawable.tb3,R.drawable.tb1,R.drawable.tb2,R.drawable.tb3,R.drawable.tb1,R.drawable.tb2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ImageView imageView=(ImageView)findViewById(R.id.back);
        listView=findViewById(R.id.lv);
        MyAdapter adapter = new MyAdapter( this, mTitle,mDescription,images);
        listView.setAdapter(adapter);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notificationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        MyAdapter (Context c, String title[],String description[],int imgs[] ){
            super(c,R.layout.item_notification, R.id.textview1,title);
            this.context =c;
            this.rTitle=title;
            this.rDescription=description;
            this.rImgs=imgs;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.item_notification,parent, false);
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