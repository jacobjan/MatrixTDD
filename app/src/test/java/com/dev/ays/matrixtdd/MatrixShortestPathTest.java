package com.dev.ays.matrixtdd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import com.dev.ays.matrixtdd.ReadMatrix;
import com.dev.ays.matrixtdd.GetShortestPath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MatrixShortestPathTest {

    @Test
    public void MatrixIsCreated() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix16.txt";
        String res = mat.FillMatrix(filepath);
        Assert.assertEquals("5 6", res);
    }

    @Test
    public void ShortestPath() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix16.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(16, Integer.parseInt(parts[1]));
        Assert.assertEquals("1 2 3 4 4 5", parts[2]);
    }

    @Test
    public void ShortestPath11() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix11.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(11, Integer.parseInt(parts[1]));
        Assert.assertEquals("1 2 1 5 4 5", parts[2]);
    }

    @Test
    public void matrix1x5() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix1x5.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(26, Integer.parseInt(parts[1]));
        Assert.assertEquals("1 1 1 1 1", parts[2]);
    }

    @Test
    public void matrix5x1() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix5x1.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(3, Integer.parseInt(parts[1]));
        Assert.assertEquals("4", parts[2]);
    }

    @Test
    public void matrix4x2() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix4x2.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(10, Integer.parseInt(parts[1]));
        Assert.assertEquals("4 4", parts[2]);
    }

    @Test
    public void matrix2x20() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix2x20.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(20, Integer.parseInt(parts[1]));
        Assert.assertEquals("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1", parts[2]);
     }

    @Test
    public void matrixOneGT50() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrixOneGT50.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(14, Integer.parseInt(parts[1]));
        Assert.assertEquals("3 2 1 3", parts[2]);
    }

    @Test
    public void matrix1x1() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix1x1.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(4, Integer.parseInt(parts[1]));
        Assert.assertEquals("1", parts[2]);
    }

    @Test
    public void negative_values() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "negative_values.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(0, Integer.parseInt(parts[1]));
        Assert.assertEquals("2 3 4 1", parts[2]);
    }

    @Test
    public void InValidMatrix() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "invalid_matrix.txt";
        mat.FillMatrix(filepath);
        assertEquals("Invalid Matrix", 3, mat.rows);
    }
    @Test
    public void NoPathLessThan50() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "noPathLessT50.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("NO", parts[0]);
        Assert.assertEquals(48, Integer.parseInt(parts[1]));
        Assert.assertEquals("1 1 1", parts[2]);
    }

    @Test
    public void AllRowsStartGreaterThan50() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "AllRowsStartGT50.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("NO", parts[0]);
        Assert.assertEquals(0, Integer.parseInt(parts[1]));
        Assert.assertEquals("[]", parts[2]);
    }
}