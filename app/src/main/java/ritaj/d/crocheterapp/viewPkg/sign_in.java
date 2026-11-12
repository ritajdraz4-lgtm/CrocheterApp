package ritaj.d.crocheterapp.viewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import ritaj.d.crocheterapp.R;

public class sign_in extends AppCompatActivity {

    private TextInputEditText etEmail, etPassword;
    private MaterialButton btnLogin, btnGoogle;
    private TextView tvRegister, tvGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // ربط العناصر مع الـ XML
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogle = findViewById(R.id.btnGoogle);
        tvRegister = findViewById(R.id.tvRegister);
        tvGuest = findViewById(R.id.tvGuest);

        // ==================================================================
        // هذا هو الجزء المحدّث لزر تسجيل الدخول (استبدل القديم بهذا):
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
            String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";

            // 1. فحص الإيميل
            if (email.isEmpty()) {
                etEmail.setError("Email is required");
                etEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Invalid email format");
                etEmail.requestFocus();
                return;
            }

            // 2. فحص كلمة المرور
            if (password.isEmpty()) {
                etPassword.setError("Password is required");
                etPassword.requestFocus();
                return;
            }

            // 3. في حال كانت البيانات سليمة
            Toast.makeText(this, "Signed in successfully", Toast.LENGTH_SHORT).show();
            // هنا تضع كود التحقق من قاعدة البيانات والانتقال للشاشة الرئيسية
        });
        // ==================================================================

        // زر التسجيل عبر جوجل
        btnGoogle.setOnClickListener(v -> {
            Toast.makeText(this, "Google Sign In Clicked", Toast.LENGTH_SHORT).show();
        });

        // الانتقال لصفحة إنشاء حساب جديد
        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(sign_in.this, RegisterActivity.class);
            startActivity(intent);
        });

        // الدخول كزائر
        tvGuest.setOnClickListener(v -> {
            // Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            // startActivity(intent);
        });
    }
}