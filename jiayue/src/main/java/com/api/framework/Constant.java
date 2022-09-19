package com.api.framework;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Constant {
    private List<String> list;
    public Constant() throws FileNotFoundException {
        list = new LinkedList<>();
        Scanner scan = new Scanner(new File("jiayue/src/main/java/com/api/utility/baseURLs"));
        while (scan.hasNextLine())
            list.add(scan.nextLine());
    }
    public List<String> getList(){
        return list;
    }
}
