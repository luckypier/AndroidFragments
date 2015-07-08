package course.examples.fragments.staticlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ActivityDashboard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void startActivityStatic(View v) {
        Intent act = new Intent(this, ActivityStaticHdcc.class);
        super.startActivity(act);

    }

    public void startActivityDynamic(View v) {
        Intent act = new Intent(this, ActivityStaticHdcc.class);
        super.startActivity(act);

    }

}
