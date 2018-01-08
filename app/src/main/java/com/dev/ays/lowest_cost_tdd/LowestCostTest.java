package com.dev.ays.lowest_cost_tdd;

import android.util.Log;
import android.widget.TextView;

import junit.framework.Assert;

import java.io.InputStream;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LowestCostTest {

    TextView mResults;
    LowestCostTest(TextView showTestResult) {
        mResults = showTestResult;
    }

    public final String TAG = "Matrix"+this.getClass().getSimpleName();

    public void ShortestPath(InputStream inps) throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String expectedResponse = mat.FillMatrix(inps);
        String[] expected = expectedResponse.split(",");
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        String res = shortestpath.TheShortestPath(mat.matrix);
        Log.i(TAG, "TheShortestPath Actual :" + res + "\nExpected " + expectedResponse);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals(expected[0], parts[0]);
        Assert.assertEquals(expected[1], parts[1]);
        Assert.assertEquals(expected[2], parts[2]);
        mResults.append(res);
    }
}