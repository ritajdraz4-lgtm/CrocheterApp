package ritaj.d.crocheterapp.viewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ritaj.d.crocheterapp.R;
import ritaj.d.crocheterapp.model.AppDataBase;
import ritaj.d.crocheterapp.model.mySubjectTable.MySubject;
import ritaj.d.crocheterapp.model.mySubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {
    private Button btnAddTaskScreen;
    private Button btnRegisterScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppDataBase db=AppDataBase.getDB(getApplicationContext());
        MySubjectQuery subjectQuery= db.getMySubjectQuery();
        MySubject s1=new MySubject();
        s1.setTitle("Math");
        MySubject s2=new MySubject();
        s2.title="Computers";
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);


        setContentView(R.layout.activity_main);
        btnAddTaskScreen=findViewById(R.id.btnAddTaskScreen);
        btnAddTaskScreen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Intent i=new Intent(MainActivity.this, AddTaskActivity1.class);
                startActivity(i);
            }
        });
        btnRegisterScreen=findViewById(R.id.btnRegisterScreen);
        btnRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    //معالجة حدث اختيار عنصر من القائمة
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (item.getItemId() == R.id.itmSettings) {
            Toast.makeText(this, " Settings", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
        }

        if(item.getItemId()==R.id.itmSignOut) {

                Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, SignOut.class);
            startActivity(i);
            }

            if (item.getItemId() == R.id.itmHistory) {
                Toast.makeText(this, "History", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, History.class);
                startActivity(i);
            }
            return true;


        }}