//package com.example.cguimfinalproj_dcardanalysis;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//
//public class RecyclerView_Config {
//
//    private Context mContext;
//    private DcardsAdapter mDcardsAdapter;
//    public void setConfig(RecyclerView recyclerView, Context context, List<Dcard> dcards){
//
//        mContext = context;
//        mDcardsAdapter = new DcardsAdapter(dcards);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        recyclerView.setAdapter(mDcardsAdapter);
//    }
//
//    class DcardItemView extends RecyclerView.ViewHolder{
//        private TextView mTitle;
//        private TextView mDate;
//        private TextView mContent;
//
//        public DcardItemView(ViewGroup parent) {
//            super(LayoutInflater.from(mContext).inflate(R.layout.article_list_item, parent, false));
//
//            mTitle = (TextView) itemView.findViewById(R.id.title_txtView);
//            mDate = (TextView) itemView.findViewById(R.id.date_txtView);
//            mContent = (TextView) itemView.findViewById(R.id.content_txtView);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(mContext, DcardDetailActivity.class);
//                    intent.putExtra("title", mTitle.getText().toString());
//                    intent.putExtra("content", mContent.getText().toString());
//                    intent.putExtra("date", mDate.getText().toString());
//
//                    mContext.startActivity(intent);
//                }
//            });
//        }
//
//        public void bind(Dcard dcard) {
//            mTitle.setText(dcard.getTitle());
//            mDate.setText(dcard.getDate());
//            mContent.setText(dcard.getContent());
//        }
//
//    }
//    class DcardsAdapter extends RecyclerView.Adapter<DcardItemView> {
//        private List<Dcard> mDcardList;
//
//        public DcardsAdapter(List<Dcard> mDcardList) {
//            this.mDcardList = mDcardList;
//        }
//
//        @NonNull
//        @NotNull
//        @Override
//        public DcardItemView onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//            return new DcardItemView(parent);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull @NotNull DcardItemView holder, int position) {
//            holder.bind(mDcardList.get(position));
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return mDcardList.size();
//        }
//    }
//}
