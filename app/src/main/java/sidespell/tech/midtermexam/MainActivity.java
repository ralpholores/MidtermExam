package sidespell.tech.midtermexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sidespell.tech.midtermexam.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       mainFragment = MainFragment.newInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,mainFragment).commit();
    }
}
