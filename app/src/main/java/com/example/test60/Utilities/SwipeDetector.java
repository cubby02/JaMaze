package com.example.test60.Utilities;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class SwipeDetector {

    private GestureDetector gestureDetector;
    private OnSwipeListener onSwipeListener;

    public SwipeDetector(Context context, OnSwipeListener onSwipeListener) {
        gestureDetector = new GestureDetector(context, new GestureListener());
        this.onSwipeListener = onSwipeListener;
    }

    public void attachToView(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();

            if (Math.abs(diffX) > Math.abs(diffY)) {
                // Horizontal swipe
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        // Right swipe
                        onSwipeListener.onSwipeRight();
                    } else {
                        // Left swipe
                        onSwipeListener.onSwipeLeft();
                    }
                    return true;
                }
            } else {
                // Vertical swipe
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        // Down swipe
                        onSwipeListener.onSwipeDown();
                    } else {
                        // Up swipe
                        onSwipeListener.onSwipeUp();
                    }
                    return true;
                }
            }

            return false;
        }
    }

    public interface OnSwipeListener {
        void onSwipeLeft();

        void onSwipeRight();

        void onSwipeUp();

        void onSwipeDown();
    }
}
