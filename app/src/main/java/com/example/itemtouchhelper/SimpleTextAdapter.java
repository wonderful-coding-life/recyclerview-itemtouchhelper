package com.example.itemtouchhelper;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.SimpleTextViewHolder> {
    private List<String> simpleTextList;
    private ItemTouchHelper itemTouchHelper;

    public SimpleTextAdapter(List<String> simpleTextList) {
        this.simpleTextList = simpleTextList;
    }

    public void setItemTouchHelper(ItemTouchHelper itemTouchHelper) {
        this.itemTouchHelper = itemTouchHelper;
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

    public class SimpleTextViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener, GestureDetector.OnGestureListener {
        private TextView simpleText;
        private GestureDetector gestureDetector;

        public SimpleTextViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleText = itemView.findViewById(R.id.simple_text);
            gestureDetector = new GestureDetector(itemView.getContext(), this);
            itemView.findViewById(R.id.drag_handle).setOnTouchListener(this);
        }

        public void bind(String city) {
            simpleText.setText(city);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            if (itemTouchHelper != null) {
                itemTouchHelper.startDrag(this);
                return true;
            }
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }
}
