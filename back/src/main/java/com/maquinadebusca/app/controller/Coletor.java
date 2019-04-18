package com.maquinadebusca.app.controller;
import java.net.URL;
import java.util.List;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.maquinadebusca.app.model.Documento;
import com.maquinadebusca.app.model.service.ColetorService;

@RestController
@RequestMapping ("/coletor") // URL: http://localhost:8080/coletor
public class Coletor {
 // URL: http://localhost:8080/coletor/iniciar
 @GetMapping (value = "/iniciar", produces =
MediaType.APPLICATION_JSON_UTF8_VALUE)
 public List<Documento> iniciar () {
 
ColetorService cs = new ColetorService();
return cs.iniciar();

 } 
}