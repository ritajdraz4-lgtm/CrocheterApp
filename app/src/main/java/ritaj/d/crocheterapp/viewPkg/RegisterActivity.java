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

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText etFullName, etEmail, etPassword, etConfirmPassword;
    private MaterialButton btnRegister;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Bind Views
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        // Sign Up Click Listener
        btnRegister.setOnClickListener(v -> {
            if (validateInputs()) {
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
                // هنا يتم حفظ البيانات في قاعدة البيانات (Room أو Firebase)
            }
        });

        // Navigate back to Login Activity
        tvLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this,sign_in.class);
            startActivity(intent);
            finish();
        });
    }

    // دالة الفحص الشاملة للشروط القياسية
    private boolean validateInputs() {
        String fullName = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
        String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";
        String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString().trim() : "";

        // 1. فحص الاسم الكامل
        if (fullName.isEmpty()) {
            etFullName.setError("Full name is required");
            etFullName.requestFocus();
            return false;
        }
        if (fullName.length() < 3) {
            etFullName.setError("Name must be at least 3 characters");
            etFullName.requestFocus();
            return false;
        }

        // 2. فحص البريد الإلكتروني وصيغته الصحيحة
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email address");
            etEmail.requestFocus();
            return false;
        }

        // 3. فحص كلمة المرور (8 خانات على الأقل + حرف كبير/صغير + رقم)
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return false;
        }
        if (password.length() < 8) {
            etPassword.setError("Password must be at least 8 characters");
            etPassword.requestFocus();
            return false;
        }
        // التأكد من احتوائها على حروف وأرقام معاً
        if (!password.matches(".*[A-Za-z].*") || !password.matches(".*[0-9].*")) {
            etPassword.setError("Password must contain both letters and numbers");
            etPassword.requestFocus();
            return false;
        }

        // 4. فحص تطابق كلمة المرور
        if (confirmPassword.isEmpty()) {
            etConfirmPassword.setError("Please confirm your password");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            etConfirmPassword.requestFocus();
            return false;
        }

        return true; // جميع الشروط مستوفاة
    }
}