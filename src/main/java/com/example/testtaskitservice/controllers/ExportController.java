package com.example.testtaskitservice.controllers;

import com.example.testtaskitservice.services.MagicSquareService;
import com.example.testtaskitservice.services.SubStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class ExportController {

    @Autowired
    MagicSquareService magicSquareService;
    @Autowired
    SubStringService subStringService;

    @PostMapping("/exportSquare")
    public ResponseEntity<Object> exportSquare(@RequestParam("squareId") Integer id) throws IOException {
        magicSquareService.saveToFile(id);
        return upload("square" + id.toString() + ".txt");
    }

    @PostMapping("exportSubstring")
    public ResponseEntity<Object> exportSubstring(@RequestParam("subStringId") Integer id) throws IOException {
        subStringService.saveToFile(id);
        return upload("substring" + id.toString() + ".txt");
    }

    private ResponseEntity<Object> upload(String filename) throws IOException{
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(
                file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

}
