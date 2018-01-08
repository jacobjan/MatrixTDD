package com.dev.ays.lowest_cost_tdd;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MatrixOpsActivity extends AppCompatActivity {

    TextView mResults;
    String[] rawFilesArray;
    List<Integer> rawlstid = new ArrayList<>();
    public final String TAG = "LowestCostMatrix";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tdd_activity );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        int spinnerPosition=-1;
        setSupportActionBar(toolbar);
        try {
            rawlstid = getRawFiles();
            int resid;
            rawFilesArray = new String[ rawlstid.size() ];
            for(int i=0; i < rawlstid.size(); i++) {
                rawFilesArray[i] = get_file_name( getResources().getString( rawlstid.get(i) ) );
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mResults = (TextView) findViewById(R.id.results);
        mResults.setTypeface(null, Typeface.BOLD | Typeface.ITALIC);
        // This allows us to later extend the text buffer.
        mResults.setMovementMethod(new ScrollingMovementMethod());
        mResults.setText(mResults.getText(), TextView.BufferType.EDITABLE);

        Spinner spnr = (Spinner) findViewById(R.id.rawfiles_spinner);
        // Populate spinner with all files in res/raw
        /**
         * spinner.setOnItemSelectedListener(null);
         adapter.notifyDatasetChanged();
         spinner.setSelection(0, false);
         spinner.setOnItemSelectedListener(onItemSelectedListener);
         */
        ArrayAdapter<String> rawFileArrayAdapter= new ArrayAdapter<String>(MatrixOpsActivity.this,
                android.R.layout.simple_spinner_item,
                rawFilesArray);

        rawFileArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spnr.setAdapter(rawFileArrayAdapter);
        mResults.setText("Test Result :\n");
        final ReadMatrix mat = new ReadMatrix();
        final LowestCostTest minCost = new LowestCostTest(mResults);
//        spnr.setOnItemClickListener(null);
//        rawFileArrayAdapter.notifyDataSetChanged();
        spnr.setSelection(0, false);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        Log.i(TAG, "Spinner1: position=" + position + " file=" + rawFilesArray[position]);
                        try {
                            InputStream finps = getResources().openRawResource(rawlstid.get(position));
                            String fillMatResult = mat.FillMatrix(finps);  // Fill matrix from inputstream and get expected response
                            if ( fillMatResult.contains("Invalid")) {
                                mResults.append("\n\nInvalid Matrix");
                            } else {
                                String showMatrixRes = mat.ShowMatrix( finps );
                                mResults.append( showMatrixRes ); // Display matrix in textview
                                mResults.append("Expecting :"+fillMatResult);
                                mResults.append("\nAnd the Response :");
                                finps = getResources().openRawResource(rawlstid.get(position));
                                minCost.ShortestPath(finps);
                            }
                        } catch (InputMismatchException numEx ){

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Log.i("LowestCostTest", "Spinner1: unselected" );
                    }
                });

        // Watch for button clicks.
        Button b = (Button) findViewById(R.id.clear);
        b.setOnClickListener(mClearText);
    }

    private View.OnClickListener mClearText = new View.OnClickListener() {
        public void onClick(View v) {
           mResults.setText("Test Result :\n"); // Clear test result textview, but refill with caption text
           mResults.scrollTo(0,0);  // Move back to top of textview display in case we scroll down.
        }
    };

    public String get_file_name(String fpath ) {
        String[] parts = fpath.split("/");
        return parts[parts.length-1];
    }

    public List<Integer> getRawFiles() throws IllegalAccessException {
        List<Integer> rawFileIds = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        // loop for every file in raw folder
        for(int count=0; count < fields.length; count++){
            int rid = fields[count].getInt(fields[count]);
            // Use that if you just need the file name
            rawFileIds.add( rid );
        }
        return rawFileIds;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_matrix_ops, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
