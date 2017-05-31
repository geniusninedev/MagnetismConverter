package com.nineinfosys.magnetismconverter.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.nineinfosys.magnetismconverter.R;
import com.nineinfosys.magnetismconverter.Supporter.ItemList;

import java.util.List;


/**
 * Created by AndriodDev5 on 18-04-2017.
 */

public class RecyclerViewConversionListAdapter extends RecyclerView.Adapter<RecyclerViewConversionListAdapter.RecyclerViewHolders> {

   // private List<ItemObject> itemList;
    private Context context;
    private String [] unitNameList;
    private List<ItemList> unitvalue;
    View layoutView;
    private final View.OnClickListener mOnClickListener = new MyItemClickListener ();


    public RecyclerViewConversionListAdapter(Context context, List<ItemList> unitvalue) {

        this.context = context;
        //this.unitNameList=unitNameList;
        this.unitvalue = unitvalue;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversion_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        layoutView.setOnClickListener(mOnClickListener);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.unitshortForm.setText(unitvalue.get(position).getUnitnameshortform());
        holder.unitName.setText(unitvalue.get(position).getUnitname());
        holder.unitValue.setText(unitvalue.get(position).getUnitvalue());
        holder.unitvaluename.setText(unitvalue.get(position).getUnitvaluename());


    }

    @Override
    public int getItemCount() {
        return this.unitvalue.size();
    }




    public class RecyclerViewHolders extends RecyclerView.ViewHolder {

        public TextView unitshortForm,unitName;
        public TextView unitValue,unitvaluename;


        public RecyclerViewHolders(View itemView) {
            super(itemView);
         //   itemView.setOnClickListener(this);

            unitshortForm = (TextView)itemView.findViewById(R.id.Unitshortform);
            unitName = (TextView)itemView.findViewById(R.id.Unitname);
            unitValue = (TextView)itemView.findViewById(R.id.unitvalue);
            unitvaluename = (TextView)itemView.findViewById(R.id.unitvaluename);


        }

/*
        @Override
        public void onClick(View view) {
           // Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
          *//*  switch (getPosition())
            {
                case 0:
                    Intent i=new Intent(context,LengthActivity.class);
                    context.startActivity(i);
                    break;
                case 1:
                    Intent i1=new Intent(context,LengthActivity.class);
                    context.startActivity(i1);
                    break;
                case 2:
                    Intent i2=new Intent(context,LengthActivity.class);
                    context.startActivity(i2);
                    break;
                case 3:
                    Intent i3=new Intent(context,TempertureActivity.class);
                    context.startActivity(i3);
                    break;
                case 4:
                    Intent i4=new Intent(context,LengthActivity.class);
                    context.startActivity(i4);
                    break;
                case 5:
                    Intent i5=new Intent(context,LengthActivity.class);
                    context.startActivity(i5);
                    break;
                case 6:
                    Intent i6=new Intent(context,LengthActivity.class);
                    context.startActivity(i6);
                    break;
                case 7:
                    Intent i7=new Intent(context,LengthActivity.class);
                    context.startActivity(i7);
                    break;
                case 8:
                    Intent i8=new Intent(context,LengthActivity.class);
                    context.startActivity(i8);
                    break;
                case 9:
                    Intent i9=new Intent(context,LengthActivity.class);
                    context.startActivity(i9);
                    break;


            }*//*


        }*/



    }
}