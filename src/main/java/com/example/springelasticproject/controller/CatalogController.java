package com.example.springelasticproject.controller;


import com.example.springelasticproject.model.CatalogImportRequest;
import com.example.springelasticproject.service.CatalogImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogImportService catalogImportService;

    @Autowired
    public CatalogController(CatalogImportService catalogImportService) {
        this.catalogImportService = catalogImportService;
    }

    @PostMapping("/import")
    public ResponseEntity<String> importCatalog(@RequestBody CatalogImportRequest request){

        String url = request.getUrl();

        try {
            new URL(url).toURI();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Malformed URL");
        }
        //TODO Проверить валидность url, вернуть 400 BadRequest если url malformed UPD: Исправлено

        //TODO можно послать запрос HEAD на проверку существования ресурса
        //Еcли не существует - вернуть 404 Not found
        try {
//            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//            connection.setRequestMethod("HEAD");
//            int responseCode = connection.getResponseCode();
//
//            if (responseCode != HttpURLConnection.HTTP_OK) {
//                return ResponseEntity.badRequest().body("404 not found");
//            }
            //FIXME Обработать исключения, вернуть 500 в случае исключения UPD: Неисправлено.
            // Почемо-то именно сайт из примера возвращает 404.
            catalogImportService.importCatalogFromUrl(url);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }

        //TODO В случае успешного импорта лучше вернуть 201 - Created UPD: Исправлено
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }


}
