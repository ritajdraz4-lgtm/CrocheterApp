package ritaj.d.crocheterapp.viewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
}