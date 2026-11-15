package ritaj.d.crocheterapp.viewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import ritaj.d.crocheterapp.R;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Optional smooth fade-in animation for the logo
        ImageView ivLogo = findViewById(R.id.ivLogo);
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1000);
        ivLogo.startAnimation(fadeIn);

        // Delay for 2.5 seconds (2500ms) then open LoginActivity
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(splash.this, sign_in.class);
            startActivity(intent);
            finish(); // Prevents going back to Splash Screen when pressing Back
        }, 2500);
    }}