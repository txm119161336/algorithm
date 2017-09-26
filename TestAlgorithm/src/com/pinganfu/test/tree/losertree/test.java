package com.pingan.test.tree.losertree;

import java.io.File;

/**
 * Created by lenovo on 2017/3/19.
 */
public class test {
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();
        File inputFile=new File("E:\\outterSort\\myInputFile.txt");
        File outputFile=new File("E:\\outterSort\\outputFile.txt");
        File tempFile=new File("E:\\outterSort\\tempFile");
        if (outputFile.exists())
            outputFile.delete();
        main.test(inputFile,outputFile,tempFile);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
