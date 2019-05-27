package com.example.elyar.fashion_store;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Recycle_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    SharedPreferences shared_data;
    SharedPreferences.Editor editor;
    String[] shirtModelNames = new String [] {"دارک","لیزر","آر.بی","بلوط","اسپلیت","یو.ام.دی","دارک(جدید)","لیزر(جدید)","آر.بی(جدید)","بلوط(جدید)"};
    String[] trousersModelsNames = new String[] {"حنایی","توسی","آبی","صورتی","قهوه ای","حنایی(جدید)","توسی(جدید)","آبی(جدید)","صورتی(جدید)","قهوه ای(جدید)"};
    String[] shoesModelNames = new String[] {"A-pack","M_N","rainBow","blu_sky","A_pack","Mcd PROJECT_DIRECTORY_N","rainBow","blu_Sky","A_pack","M_N"};
    int[] shirtModelPics = new int[]{R.drawable.shirt1,R.drawable.shirt2,R.drawable.shirt3,R.drawable.shirt4,R.drawable.shirt5,R.drawable.shirt6,R.drawable.shirt1,R.drawable.shirt2,R.drawable.shirt3,R.drawable.shirt4};
    int[] trousersModelPics = new int[]{R.drawable.trousers1,R.drawable.trousers2,R.drawable.trousers3,R.drawable.trousers4,R.drawable.trousers5,R.drawable.trousers1,R.drawable.trousers2,R.drawable.trousers3,R.drawable.trousers4,R.drawable.trousers5};
    int[] shoesModelPics = new int[]{R.drawable.shoe1,R.drawable.shoe2,R.drawable.shoe3,R.drawable.shoe4,R.drawable.shoe1,R.drawable.shoe2,R.drawable.shoe3,R.drawable.shoe4,R.drawable.shoe1,R.drawable.shoe2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        initialize();
    }


    private void initialize() {
        shared_data = Recycle_Activity.this.getSharedPreferences("shared_data",MODE_PRIVATE);
        editor = shared_data.edit();
        recyclerView = (RecyclerView) findViewById(R.id.Recycle_view);
        recyclerView.setAdapter(new CustomAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(Recycle_Activity.this));
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.viewHolder>{

        LayoutInflater inflater;

        public CustomAdapter(){
            inflater = (LayoutInflater) Recycle_Activity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new viewHolder(inflater.inflate(R.layout.recycle_view_item,parent,false));
        }

        @Override
        public void onBindViewHolder(viewHolder holder, int position) {
            if (shared_data.getString("list_determiner","").equals("shirts")){
                holder.imageView_recycleItem.setImageResource(shirtModelPics[position]);
                holder.textView_recycleItem.setText(shirtModelNames[position]);
            }else if (shared_data.getString("list_determiner","").equals("trousers")){
                holder.imageView_recycleItem.setImageResource(trousersModelPics[position]);
                holder.textView_recycleItem.setText(trousersModelsNames[position]);
            }else {
                holder.imageView_recycleItem.setImageResource(shoesModelPics[position]);
                holder.textView_recycleItem.setText(shoesModelNames[position]);
            }
        }

        @Override
        public int getItemCount() {
            return shirtModelNames.length;
        }

        public class viewHolder extends RecyclerView.ViewHolder{

            private ImageView imageView_recycleItem;
            private TextView textView_recycleItem;

            public viewHolder(View itemView) {
                super(itemView);

                imageView_recycleItem = (ImageView) itemView.findViewById(R.id.imageView_recycleItem);
                textView_recycleItem = (TextView) itemView.findViewById(R.id.textView_recycleItem);
            }
        }
    }
}
