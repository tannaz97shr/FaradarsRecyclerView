package com.example.faradarsrecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private static int [] ATTRS = {
            android.R.attr.listDivider
    };
    private Drawable divider;
    private int orientation;
    public DividerItemDecoration (Context context, int orientation){
        TypedArray arr = context.obtainStyledAttributes(ATTRS);
        divider= arr.getDrawable(0);
        arr.recycle();
        setOrientation(orientation);
    }

    private void setOrientation(int orientation) {
        if(orientation != LinearLayoutManager.VERTICAL &&
                orientation != LinearLayoutManager.HORIZONTAL){
            throw new IllegalArgumentException("wrong orientation");
        }
        this.orientation=orientation;
    }

    private void drawVertical(Canvas c , RecyclerView recyclerView){
        int left= recyclerView.getPaddingLeft();
        int right= recyclerView.getWidth()-recyclerView.getPaddingRight();
        for (int i=0; i<recyclerView.getChildCount();i++){
            View childView= recyclerView.getChildAt(i);
            RecyclerView.LayoutParams params=
                    (RecyclerView.LayoutParams) childView.getLayoutParams();
            int top=childView.getBottom()+params.bottomMargin ;
            int bottom=top+divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }

    }
    private void drawHorizontal(Canvas c , RecyclerView recyclerView){
        int top= recyclerView.getPaddingTop();
        int bottom=recyclerView.getHeight() - recyclerView.getPaddingBottom();
        for (int i=0; i<recyclerView.getChildCount();i++){
            View childView= recyclerView.getChildAt(i);
            RecyclerView.LayoutParams params=
                    (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left= childView.getRight()+params.leftMargin;
            int right= left+divider.getIntrinsicWidth();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(orientation==LinearLayoutManager.VERTICAL){
            drawVertical(c , parent);
        }else if (orientation==LinearLayoutManager.HORIZONTAL){
            drawHorizontal(c , parent);
        }
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(orientation==LinearLayoutManager.VERTICAL){
            outRect.set(0,0,0,divider.getIntrinsicHeight());
        }else if (orientation==LinearLayoutManager.HORIZONTAL){
            outRect.set(0,0,divider.getIntrinsicWidth(),0);
        }
        super.getItemOffsets(outRect, view, parent, state);
    }
}
