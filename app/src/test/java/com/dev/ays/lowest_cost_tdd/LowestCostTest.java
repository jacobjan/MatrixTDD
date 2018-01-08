package com.dev.ays.lowest_cost_tdd;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LowestCostTest {
    public String rawFolderPath = "app/src/main/res/raw/";

    @Test
    public void all_rows_start_gt50() throws Exception {
        ShortestPath( get_inputStream( "all_rows_start_gt50.txt" ) );
    }

    @Test
    public void invalid_matrix() throws Exception {
        ShortestPath( get_inputStream( "invalid_matrix.txt" ) );
    }
    @Test
    public void matrix1x1() throws Exception {
        ShortestPath( get_inputStream( "matrix1x1.txt" ) );
    }

    @Test
    public void matrix1x5() throws Exception {
        ShortestPath( get_inputStream( "matrix1x5.txt" ) );
    }
    @Test
    public void matrix2x20() throws Exception {
        ShortestPath( get_inputStream( "matrix2x20.txt" ) );
    }
    @Test
    public void matrix4x2() throws Exception {
        ShortestPath( get_inputStream( "matrix4x2.txt" ) );
    }
    @Test
    public void matrix5x1() throws Exception {
        ShortestPath( get_inputStream( "matrix5x1.txt" ) );
    }
    @Test
    public void matrixSum11() throws Exception {
        ShortestPath( get_inputStream( "matrix11.txt" ) );
    }
    @Test
    public void matrixSum16() throws Exception {
        ShortestPath( get_inputStream( "matrix16.txt" ) );
    }

    @Test
    public void AllRowsStartGreaterThan50() throws Exception {
        ShortestPath( get_inputStream( "matrix_r1c1_gt50.txt" ) );
    }
    @Test
    public void negative_values() throws Exception {
        ShortestPath( get_inputStream( "negative_values.txt" ) );
    }

    @Test
    public void matrixall_rows_start_gt50() throws Exception {
        ShortestPath( get_inputStream( "all_rows_start_gt50.txt" ) );
    }

    @Test
    public void NoPathLessThan50() throws Exception {
        ShortestPath( get_inputStream( "no_path_lt50.txt" ) );
    }


    public InputStream get_inputStream(String rawFileName) throws Exception {
        File fh = new File( rawFolderPath + rawFileName );
        return (new FileInputStream( fh ));
    }

    public void ShortestPath(InputStream inps) throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String expectedResponse = mat.FillMatrix(inps);

        if ( expectedResponse.contains("Invalid")) {
            junit.framework.Assert.assertEquals(expectedResponse, "Invalid Matrix");
        } else {
            String[] expected = expectedResponse.split(",");
            GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
            String res = shortestpath.TheShortestPath(mat.matrix);
            String[] parts = res.split(",");
            int sum = Integer.parseInt(parts[1]);
            System.out.println(res);
            junit.framework.Assert.assertEquals(expected[0], parts[0]);
            junit.framework.Assert.assertEquals(expected[1], parts[1]);
            junit.framework.Assert.assertEquals(expected[2], parts[2]);
        }
    }
 }