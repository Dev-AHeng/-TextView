package aheng.view_textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new TextView(this);
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