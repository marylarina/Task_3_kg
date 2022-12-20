package com.cgvsu.objwriter;

import com.cgvsu.math.Vector2f;
import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Polygon;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objreader.ObjReaderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjWriterTest {

    @Test
    public void testWriteVertex01(){
        ArrayList<Vector3f> vTest = new ArrayList<>();
        Vector3f v1 = new Vector3f(1.0F, 1.02F, 1.03F);
        vTest.add(v1);
        String result = ObjWriter.writeVertex(vTest);
        String expected = "v  1.00 1.02 1.03\n" + "# 1 vertices" + "\n\n";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testWriteVertex02(){
        ArrayList<Vector3f> vTest = new ArrayList<>();
        Vector3f v2 = new Vector3f(1.0F, 1.02F, 1.10F);
        vTest.add(v2);
        String result = ObjWriter.writeVertex(vTest);
        String expected = "v  1.00 1.02 1.10\n" + "# 1 vertices" + "\n\n";
        Assertions.assertEquals(expected, result);
    }


    @Test
    void testWriteTextureVertexes01() {
        ArrayList<Vector2f> vt = new ArrayList<>();
        Vector2f v1 = new Vector2f(1.01F, 1.02F);
        vt.add(v1);
        String result = ObjWriter.writeTextureVertex(vt);
        String expected = "vt 1.01 1.02 0.0\n" + "# 1 texture vertices" + "\n\n";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testWriteTextureVertexes02() {
        ArrayList<Vector2f> vt = new ArrayList<>();
        Vector2f v2 = new Vector2f(1.01F, 1.2F);
        vt.add(v2);
        String result = ObjWriter.writeTextureVertex(vt);
        String expected = "vt 1.01 1.2 0.0\n" + "# 1 texture vertices" + "\n\n";
        Assertions.assertNotEquals(result, expected);
    }

    @Test
    void testWriteNormals01() {
        ArrayList<Vector3f> vt = new ArrayList<>();
        Vector3f v1 = new Vector3f(1.01F, 1.2F, 2.02F);
        vt.add(v1);
        String result = ObjWriter.writeNormals(vt);
        String expected = "vn 1.01 1.20 2.02\n" + "# 1 normals" + "\n\n";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testWriteNormals02() {
        ArrayList<Vector3f> vt = new ArrayList<>();
        Vector3f v2 = new Vector3f(1.01F, 1.2F, 2.02F);
        vt.add(v2);
        String result = ObjWriter.writeNormals(vt);
        String expected = "vn 1.01 1.20 2.02\n" + "# 2 normals" + "\n\n";
        Assertions.assertNotEquals(expected, result);
    }

    @Test
    void testWritePolygons01() {

        ArrayList<Polygon> polygons = new ArrayList<>();
        Polygon polygon = new Polygon();
        polygon.addVertexIndex(0);
        polygon.addVertexIndex(1);
        polygon.addVertexIndex(2);

        polygons.add(polygon);

        String res = ObjWriter.writePolygons(polygons);
        String expected = "f 1 2 3 \n" + "# 1 polygons" + "\n\n";
        Assertions.assertEquals(expected, res);
    }

    @Test
    void testWritePolygons02() {

        ArrayList<Polygon> polygons = new ArrayList<>();
        Polygon polygon = new Polygon();
        polygon.addVertexIndex(4);
        polygon.addVertexIndex(1);
        polygon.addVertexIndex(2);

        polygons.add(polygon);

        String res = ObjWriter.writePolygons(polygons);
        String expected = "f 1 2 3 \n" + "# 1 polygons" + "\n\n";
        Assertions.assertNotEquals(expected, res);
    }

    @Test
    void testWritePolygons03() {
        ArrayList<Polygon> polygons = new ArrayList<>();
        Polygon polygon = new Polygon();
        polygon.addVertexIndex(0);
        polygon.addVertexIndex(1);
        polygon.addVertexIndex(2);
        polygon.addVertexIndex(3);
        polygon.addNormalIndex(0);
        polygon.addNormalIndex(1);
        polygon.addNormalIndex(2);
        polygon.addNormalIndex(3);
        polygon.addTextureVertexIndex(0);
        polygon.addTextureVertexIndex(1);
        polygon.addTextureVertexIndex(2);
        polygon.addTextureVertexIndex(3);

        polygons.add(polygon);

        String res = ObjWriter.writePolygons(polygons);
        String expected = "f 1/1/1 2/2/2 3/3/3 4/4/4 \n" + "# 1 polygons" + "\n\n";
        Assertions.assertEquals(expected, res);
    }

    @Test
    void testWritePolygons04() {
        ArrayList<Polygon> polygons = new ArrayList<>();
        Polygon polygon = new Polygon();
        polygon.addVertexIndex(0);
        polygon.addVertexIndex(1);
        polygon.addVertexIndex(2);
        polygon.addVertexIndex(3);
        polygon.addNormalIndex(0);
        polygon.addNormalIndex(1);
        polygon.addNormalIndex(2);
        polygon.addNormalIndex(3);

        polygons.add(polygon);

        String res = ObjWriter.writePolygons(polygons);
        String expected = "f 1//1 2//2 3//3 4//4 \n" + "# 1 polygons" + "\n\n";
        Assertions.assertEquals(expected, res);
    }

    @Test
    void testWritePolygons05() {
        ArrayList<Polygon> polygons = new ArrayList<>();
        Polygon polygon = new Polygon();
        polygon.addVertexIndex(0);
        polygon.addVertexIndex(1);
        polygon.addVertexIndex(2);
        polygon.addVertexIndex(3);
        polygon.addTextureVertexIndex(0);
        polygon.addTextureVertexIndex(1);
        polygon.addTextureVertexIndex(2);
        polygon.addTextureVertexIndex(3);

        polygons.add(polygon);

        String res = ObjWriter.writePolygons(polygons);
        String expected = "f 1/1 2/2 3/3 4/4 \n" + "# 1 polygons" + "\n\n";
        Assertions.assertEquals(expected, res);
    }
}
