package com.entreprise.davfou.projectporte.utilsRecyclerView;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.entreprise.davfou.projectporte.R;

import java.util.ArrayList;

public class AdapterDataDoor extends RecyclerView.Adapter<AdapterDataDoor.Holder> {

    private ArrayList<DataDoor> serieDS;
    public Context context;

    public AdapterDataDoor(ArrayList<DataDoor> serieDS, Context context) {
        this.serieDS = serieDS;
        this.context = context;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textTemp;
        public TextView textLight;
        public TextView textacy;
        public TextView textacx;
        public TextView textacz;
        public TextView textgyy;
        public TextView textgyx;
        public TextView textTime;
        public TextView textgyz;


        public RelativeLayout cardviewBackground;
        public RelativeLayout layoutDetail;


        public Holder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textRentrer);
            cardviewBackground = (RelativeLayout) itemView.findViewById(R.id.cardviewBackground);
            layoutDetail = (RelativeLayout) itemView.findViewById(R.id.layoutDetail);
            textTemp = (TextView) itemView.findViewById(R.id.textTemp);
            textLight = (TextView) itemView.findViewById(R.id.textLight);
            textacy = (TextView) itemView.findViewById(R.id.textacy);
            textacx = (TextView) itemView.findViewById(R.id.textacx);
            textacz = (TextView) itemView.findViewById(R.id.textacz);
            textgyy = (TextView) itemView.findViewById(R.id.textgyy);
            textgyx = (TextView) itemView.findViewById(R.id.textgyx);
            textTime = (TextView) itemView.findViewById(R.id.textTime);
            textgyz = (TextView) itemView.findViewById(R.id.textgyz);



        }

        public void display(DataDoor dataDoor,int position, Context context) {
            textView.setText("Rentrer");
            textTime.setText("Date : "+dataDoor.timestmp);
            textTemp.setText("Température : "+dataDoor.tmp);
            textLight.setText("Lumière : "+dataDoor.light);
            textacx.setText("Acx : "+dataDoor.acx);
            textacy.setText("Acy : "+dataDoor.acy);
            textacz.setText("Acz : "+dataDoor.acz);
            textgyx.setText("Gyx : "+dataDoor.gyx);
            textgyy.setText("Gyy : "+dataDoor.gyy);
            textgyz.setText("Gyz : "+dataDoor.gyz);
            if (dataDoor.light<800){
                textView.setText("Sortir");
                cardviewBackground.setBackgroundColor(ContextCompat.getColor(context, R.color.red));

            }else{
                textView.setText("Entrer");
                cardviewBackground.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
            }



        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int position) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               RelativeLayout detail = (RelativeLayout) v.findViewById(R.id.layoutDetail);


                if (detail.getVisibility() == View.GONE){

                    ToolsforList.expand(detail);

                }
                else{

                    ToolsforList.collapse(detail);

                }
            }
        });
        holder.display(serieDS.get(position),position, context);
    }

    @Override
    public int getItemCount() {
        return serieDS.size();
    }

}
