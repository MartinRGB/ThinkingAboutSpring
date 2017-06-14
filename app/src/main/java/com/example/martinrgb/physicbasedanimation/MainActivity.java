/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.martinrgb.physicbasedanimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;

public class MainActivity extends Activity {

    private float downX, downY;
    private SeekBar damping, stiffness;
    private VelocityTracker velocityTracker;
    private SpringForce mSpringForce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        stiffness = (SeekBar) findViewById(R.id.stiffness);
        damping = (SeekBar) findViewById(R.id.damping);
        velocityTracker = VelocityTracker.obtain();
        final View box = findViewById(R.id.box);
        findViewById(R.id.root).setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downX = event.getX();
                        downY = event.getY();
                        velocityTracker.addMovement(event);
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        box.setTranslationX(event.getX() - downX);
                        box.setTranslationY(event.getY() - downY);
                        velocityTracker.addMovement(event);
                        return true;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        velocityTracker.computeCurrentVelocity(1000);
                        if (box.getTranslationX() != 0 || box.getTranslationY() != 0) {
                            SpringAnimation animX = new SpringAnimation(box, SpringAnimation.TRANSLATION_X, 0);

                            animX.getSpring().setStiffness(getStiffness());
                            animX.getSpring().setDampingRatio(getDamping());
                            animX.setStartVelocity(velocityTracker.getXVelocity());
                            animX.start();


                            SpringAnimation animY = new SpringAnimation(box, SpringAnimation.TRANSLATION_Y, 0);
                            animY.getSpring().setStiffness(getStiffness());
                            animY.getSpring().setDampingRatio(getDamping());
                            animY.setStartVelocity(velocityTracker.getYVelocity());
                            animY.start();
                        }
                        velocityTracker.clear();
                        return true;
                }
                return false;
            }
        });
    }

    private float getStiffness() {
        return Math.max(stiffness.getProgress(), 1f);
    }

    private float getDamping() {
        return damping.getProgress() / 100f;
    }
}