package jisakeyian.com.sqlitelab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Insert: ", "Inserting...");
        db.addContacts(new Contacts("Beth Wangui", "0723894536"));
        db.addContacts(new Contacts("Brian Sigei", "0712234561"));
        db.addContacts(new Contacts("Anne Wangari", "07153456789"));
        db.addContacts(new Contacts("Ronaldo Chrsistiano", "07356783484"));

        Log.d("Reading: ", "Reading all contacts...");
        List<Contacts> contacts = db.getAllContacts();

        for(Contacts cn :contacts){
            String log = "Id: "+cn.getID()+", Name: "+ cn.getName() + ",Phone Number: " +cn.getPhone();
            Log.d("Name: ", log);
        }

        Log.d("Insert: ", "Inserting...");
        db.addStudents(new Students("Raila Odinga", "Nasa"));
        db.addStudents(new Students("Bony Khalwale", "JPG "));
        db.addStudents(new Students("Olmarekai John", "CCM"));
        db.addStudents(new Students("Anne Wangari", "FIT "));

        Log.d("Reading: ", "Reading all students...");
        List<Students> students = db.getAllStudents();

        for(Students st :students){
            String log = "Id: "+st.getID()+", Name: "+ st.getSName() + ",Course: " +st.getCourse();
            Log.d("Name: ", log);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
