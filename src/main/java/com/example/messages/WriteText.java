package com.example.messages;

        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.PrintWriter;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class WriteText extends AppCompatActivity {
    public static final String FILE_NAME = "test.txt";
    private ArrayList<String> writeArr;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_text);
        writeArr = new ArrayList<String>();
        mEditText = findViewById(R.id.write_here);

    }

    public void Save(View v) throws IOException {
        String text = mEditText.getText().toString();
        FileOutputStream oFP = null;

        oFP = openFileOutput(FILE_NAME, MODE_APPEND);

        oFP.write(text.getBytes());
        oFP.write(System.getProperty("line.separator").getBytes());

        mEditText.getText().clear();
        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();

        oFP.flush();

        if (oFP != null) {
            oFP.close();
        }
    }

    public void Delete(View v) throws IOException {
        FileOutputStream fos = null;
        fos = openFileOutput(FILE_NAME, MODE_PRIVATE);

        fos.write("".getBytes());
        fos.close();

        Toast.makeText(this, "Restart app to delete all text", Toast.LENGTH_LONG).show();


    }

}