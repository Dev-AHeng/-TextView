package aheng.view_textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import aheng.view_textview.view.MyTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 获取自定义的 MyTextView
        MyTextView myTextView = findViewById(R.id.myTextView);
    }

    // This method is called when the activity is no longer visible to the user.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clean up resources or references if needed
    }

    // This method is called when the activity is about to be destroyed.
    @Override
    protected void onStop() {
        super.onStop();
        // Additional cleanup can be done here if necessary
    }

    // show toast message
    private void showToast(String message) {
        // Implementation for showing a toast message
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(android.view.Gravity.CENTER, 0, 0);
        toast.show();
    }

}