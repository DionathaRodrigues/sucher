/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maquinadebusca.app.model.service;

import com.maquinadebusca.app.model.Documento;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author dionatharodrigues
 */

public class ColetorService {
    
public List<Documento> iniciar(){
    List<Documento> documentos = new LinkedList ();
    List<URL> urls = this.getURLs();
    for(URL url:urls )
        documentos.add (coletar(url));
    return documentos;
}    
    
public List<URL> getURLs(){
    List<URL> urls = new LinkedList();
    try{
    urls.add(new URL("https://www.google.com.br"));
    urls.add(new URL("https://www.facebook.com"));
    urls.add(new URL("https://www.twitter.com"));
    } catch(Exception e){
        e.printStackTrace();
    }
    return urls;

}    
        
public Documento coletar (URL url) {
 Documento d = new Documento ();
 try {
 Document doc = Jsoup.connect (url.toString ()).get ();
 Elements links = doc.select ("a[href]");
 d.setUrl (url);
 d.setTexto (doc.html ());
 d.setVisao (doc.text ());
 List<String> urls = new LinkedList ();
 for (Element link : links)
 if ((! link.attr("abs:href").equals ("") && (link.attr("abs:href") != null)))
 urls.add (link.attr("abs:href"));
 d.setUrls (urls);

 System.out.println
("\n\n\n=================================================");
 System.out.println (">>> URL:");
 System.out.println ("=================================================");
 System.out.println (d.getUrl ());
 System.out.println
("\n\n\n=================================================");
 System.out.println (">>> Página:");
 System.out.println ("=================================================");
 System.out.println (d.getTexto ());
 System.out.println
("\n\n\n=================================================");
 System.out.println (">>> Visão:");
 System.out.println ("=================================================");
 System.out.println (d.getVisao ());
 System.out.println
("\n\n\n=================================================");
 System.out.println (">>> URLs:");
 System.out.println ("=================================================");
 urls = d.getUrls ();
 for (String u: urls)
 System.out.println (u);
 } catch (Exception e) {
 System.out.println ("Erro ao coletar a página.");
 e.printStackTrace ();
 }
 return d;
 }
    
}

