package ritaj.d.crocheterapp.viewPkg;

import android.os.Bundle;
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

        // Bind Views
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogle = findViewById(R.id.btnGoogle);
        tvRegister = findViewById(R.id.tvRegister);
        tvGuest = findViewById(R.id.tvGuest);

        // Sign In Click
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
            String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Signed in successfully", Toast.LENGTH_SHORT).show();
            }
        });

        // Google Sign In Click
        btnGoogle.setOnClickListener(v -> {
            Toast.makeText(this, "Google Sign In Clicked", Toast.LENGTH_SHORT).show();
        });

        // Register Click
        tvRegister.setOnClickListener(v -> {
            // Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            // startActivity(intent);
        });

        // Guest Click
        tvGuest.setOnClickListener(v -> {
            // Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            // startActivity(intent);
        });}}

