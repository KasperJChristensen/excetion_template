package com.example.exceptions;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/exp")
public class ExceptController {

    @GetMapping("")
    public String hello() {
        return "hej";
    }


    @GetMapping("/file/{filename}")
    public String getFileName(@PathVariable String filename) throws IOException {
        String fileContent = "";
        try {
            FileInputStream fs = new FileInputStream("C:/AFILE/" + filename);
        } catch (FileNotFoundException e) {
            fileContent = e.getMessage();
        }

        return fileContent;
    }


    @GetMapping("/div/{divnum1}/{divnum2}")
    public int getDivNum(@PathVariable int divnum1, @PathVariable int divnum2) {

            int result = divnum1 / divnum2;

        return result;
    }

    @GetMapping("/loop/{loopnum}")
    public int getLoopNum(@PathVariable int loopnum){
        int x =0;
        for (int i = 0; i < loopnum; i++){
            x++;
        }
        return x;
    }
}
