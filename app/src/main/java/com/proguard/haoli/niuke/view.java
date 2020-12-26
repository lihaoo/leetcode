package com.proguard.haoli.niuke;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class view {
    public static class MyBigFrameLayout extends FrameLayout {
        public MyBigFrameLayout(Context context) {
            super(context);
        }

        public MyBigFrameLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyBigFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        //    @Override
        //    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        //        Log.e("============", "   big ViewGroup requestDisallowInterceptTouchEvent ");
        //        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        //    }

        //    @Override
        //    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //        Log.e("============", "   big ViewGroup onInterceptTouchEvent ");
        //        return super.onInterceptTouchEvent(ev);
        //    }

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            Log.e("============", "   big ViewGroup dispatchTouchEvent ");
            return super.dispatchTouchEvent(ev);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Log.e("============", "   big ViewGroup onTouchEvent " + event.getAction());
            return super.onTouchEvent(event);
        }
    }

    public static class MyFrameLayout extends FrameLayout {
        public MyFrameLayout(Context context) {
            super(context);
            init();
        }

        public MyFrameLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public MyFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init();
        }

        private void init() {
            //        setOnTouchListener(new OnTouchListener() {
            //            @Override
            //            public boolean onTouch(View v, MotionEvent event) {
            //                Log.e("============", "   ViewGroup onTouch ");
            //                return true;
            //            }
            //        });
        }

        //    @Override
        //    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        //        Log.e("============", "   ViewGroup requestDisallowInterceptTouchEvent ");
        //        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        //    }
        //
        //    @Override
        //    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //        Log.e("============", "   ViewGroup onInterceptTouchEvent ");
        //        return super.onInterceptTouchEvent(ev);
        ////        return true;
        //    }

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            Log.e("============", "     ViewGroup dispatchTouchEvent ");
            return super.dispatchTouchEvent(ev);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Log.e("============", "     ViewGroup onTouchEvent " + event.getAction());
            //        return super.onTouchEvent(event);
            return true;
        }
    }

    public static class MyTextView extends View {
        public MyTextView(Context context) {
            super(context);
            init();
        }

        public MyTextView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init();
        }

        private void init() {

            //        setOnTouchListener(new OnTouchListener() {
            //            @Override
            //            public boolean onTouch(View v, MotionEvent event) {
            //                Log.e("============", "       View onTouch ");
            //                return true;
            //            }
            //        });
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            Log.e("============", "       View dispatchTouchEvent ");

            return super.dispatchTouchEvent(event);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Log.e("============", "        View onTouchEvent ");
            //        getParent().requestDisallowInterceptTouchEvent(true);
            return super.onTouchEvent(event);
            //        return true;
        }


    }
}
