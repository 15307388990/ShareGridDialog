package com.eascs.share.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eascs.share.dialog.ShareItemVM;
import com.eascs.shareutils.R;
import com.eascs.shareutils.databinding.ItemShareListBinding;

import java.util.List;

/**
 * @Author luoming
 * @Date 2018/11/6 3:54 PM
 */

public class ShareRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShareItemVM> list;
    private OnItemClickListener mItemClickListener;

    public ShareRecycleAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.mItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ShareRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShareListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_share_list, parent, false);

        binding.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemClickListener.onItemClick(view);
            }
        });

        return new ShareRecycleHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        getItemViewType(position);
        ShareItemVM shareItemVM = list.get(position);
        String name = shareItemVM.getTitle();
        int url = shareItemVM.getIconUrl();

        ShareRecycleHolder holder1 = (ShareRecycleHolder) holder;
        try {
            holder1.logo.setImageResource(url);
            holder1.name.setText(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder1.layout.setTag(position);

    }


    @Override
    public int getItemCount() {
        return list.size();

    }

    public void setList(List<ShareItemVM> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    class ShareRecycleHolder extends RecyclerView.ViewHolder {
        private ImageView logo;
        private TextView name;
        private LinearLayout layout;


        public ShareRecycleHolder(ItemShareListBinding binding) {
            super(binding.getRoot());
            this.logo = binding.logo;
            this.name = binding.name;
            this.layout = binding.layout;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view);
    }
}