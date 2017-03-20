package com.yy.my.activity;

import android.animation.ObjectAnimator;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yy.my.R;
import com.yy.my.dialogs.WaitDialog;


public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private WaitDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("http://img.hb.aicdn.com/5f6c5653f06fdf58d985b98210b06084b1e846e410bd5-0PzRki_fw658");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);

        textView = (TextView)findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        /**
         * 属性动画
         */
        //通过ofFloat创建一个ValueAnimator实例，并传入参数，允许多个
        //ValueAnimator anim = ValueAnimator.ofFloat(0f, 5f, 3f, 10f);
        //设置动画运行时长
        //anim.setDuration(300);
        //添加一个更新回调，打印过渡的值，观察动画从0f到1f的过渡
        /*anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float)animation.getAnimatedValue();
                Log.v("print","动画过渡值："+currentValue);
            }
        });*/
        //设置动画延迟播放的时间
        //anim.setStartDelay(3000);
        //设置动画循环播放的次数
        //anim.setRepeatCount(2);
        //设置动画播放的模式  RESTART REVERSE 分别表示重新播放和倒序播放
        //anim.setRepeatMode(ValueAnimator.RESTART);
        //启动动画
        //anim.start();

        float ctranslationX = textView.getTranslationX();
        float ctranslationY = textView.getTranslationY();

        //ObjectAnimator anim = ObjectAnimator.ofFloat(textView,"translationX",ctranslationY,-500f,ctranslationY);
        ObjectAnimator anim = ObjectAnimator.ofFloat(textView,"scaleY",1f,3f,1f);
        anim.setDuration(5000);
        anim.start();

    }

    /**
     * 显示对话框
     */
    private void showDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
        if (dialog == null) {
            dialog = new WaitDialog(this);
            dialog.show();
        }
    }

    /**
     * 隐藏对话框
     */
    private void hideDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

}
