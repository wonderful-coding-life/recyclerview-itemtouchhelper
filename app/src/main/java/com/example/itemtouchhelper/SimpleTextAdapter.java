package com.example.itemtouchhelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.SimpleTextViewHolder> {
    private List<String> simpleTextList;

    public SimpleTextAdapter(List<String> simpleTextList) {
        this.simpleTextList = simpleTextList;
    }

    @NonNull
    @Override
    public SimpleTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_simple_text, parent, false);
        return new SimpleTextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleTextViewHolder holder, int position) {
        holder.bind(simpleTextList.get(position));
    }

    @Override
    public int getItemCount() {
        if (simpleTextList != null) {
            return simpleTextList.size();
        }
        return 0;
    }

    public boolean moveItem(int fromPosition, int toPosition) {
        String simpleText = simpleTextList.get(fromPosition);
        simpleTextList.remove(fromPosition);
        simpleTextList.add(toPosition, simpleText);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public void removeItem(int position) {
        simpleTextList.remove(position);
        notifyItemRemoved(position);
    }

    public class SimpleTextViewHolder extends RecyclerView.ViewHolder {
        private TextView simpleText;

        public SimpleTextViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleText = itemView.findViewById(R.id.simple_text);
        }

        public void bind(String city) {
            simpleText.setText(city);
        }

        public void remove() {
            removeItem(getAdapterPosition());
        }
    }
}
