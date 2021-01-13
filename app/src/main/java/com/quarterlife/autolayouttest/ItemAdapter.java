package com.quarterlife.autolayouttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<ItemModel> cate_list;
    private Context context;

    public ItemAdapter(List<ItemModel> cate_list, Context context) {
        this.cate_list = cate_list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cate,parent,false));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            img = itemView.findViewById(R.id.item_img);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.title.setText(cate_list.get(position).getTitle());
        holder.img.setImageResource(cate_list.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return cate_list.size();
    }
}
