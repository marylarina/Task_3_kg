package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objwriter.ObjWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:/Users/Мария/Downloads/CGVSU-main/ObjModels/Faceform/WrapHand.obj");
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        String fileContent = sb.toString();

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());

        Model model1 = ObjReader.read(fileContent);

        System.out.println(ObjWriter.writePolygons(model.polygons));

        FileInputStream fis2 = new FileInputStream("C:/Users/Мария/Downloads/ObjReaderInitial/test.obj");
        FileOutputStream fileOutputStream = new FileOutputStream("test.obj");
        byte [] str = ObjWriter.write(model).getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(str);
        fis2.close();
    }
}
