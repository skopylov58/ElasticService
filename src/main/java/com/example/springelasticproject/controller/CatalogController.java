package com.example.springelasticproject.controller;


import com.example.springelasticproject.model.CatalogImportRequest;
import com.example.springelasticproject.service.CatalogImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

        catalogImportService.importCatalogFromUrl(url);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


}
