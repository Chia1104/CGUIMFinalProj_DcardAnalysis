package com.example.cguimfinalproj_dcardanalysis;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Dcard> dcards;
    private Context mContext;

    public Adapter(Context context, List<Dcard> dcards) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.dcards = dcards;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.article_list_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTitle.setText(dcards.get(position).getTitle());
        holder.mDate.setText(dcards.get(position).getDate());
        holder.mContent.setText(dcards.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return dcards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle, mDate, mContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title_txtView);
            mDate = (TextView) itemView.findViewById(R.id.date_txtView);
            mContent = (TextView) itemView.findViewById(R.id.content_txtView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
//                        //ERROR//Intent intent = new Intent(mContext, DcardDetailActivity.class);
//                        intent.putExtra("title", mTitle.getText().toString());
//                        intent.putExtra("content", mContent.getText().toString());
//                        intent.putExtra("date", mDate.getText().toString());
//                        mContext.startActivity(intent);//ERROR//
                        Toast.makeText(mContext,
                                "clicked",Toast.LENGTH_SHORT).show();
                    }
                    catch(Exception e) {
                        Toast.makeText(mContext,
                                "error",Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}
