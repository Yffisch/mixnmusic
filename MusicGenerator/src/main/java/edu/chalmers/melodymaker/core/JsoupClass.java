

package edu.chalmers.melodymaker.core;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author Yff
 */
public class JsoupClass {
    public JsoupClass(){
        
    }
    
    public static String getTextFrom(String site, String div){
         try {
 
            Document doc = Jsoup.connect(site).timeout(300000).get();

            Elements els = doc.select(div);
            System.out.println(els.text());
            div = els.text() + "\n";
            StringBuilder sb = new StringBuilder(div);
            System.out.print("sb" +sb.length());
            for(int i = 0; i <= sb.length()-1; i++){
                if(sb.charAt(i) == '.'){
                    sb.setCharAt(i, '\n');
                    div = sb.toString();
                }
            }
            
           Elements test = doc.select("img[src$=.png]");
            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
 
            int i = 0;
            for (Element image : images) {
                try {
                    System.out.println("src: " + image.attr("src"));
                    String src = image.attr("src");
 
                    // Read images
                    URL url = new URL(src);
                    InputStream in = new BufferedInputStream(url.openStream());
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    int n = 0;
                    while (-1 != (n = in.read(buf))) {
                        out.write(buf, 0, n);
                    }
                    out.close();
                    in.close();
                    byte[] response = out.toByteArray();
 
                    // Save images
                    FileOutputStream fos = new FileOutputStream("src/main/resources/bild-" + i + ".jpg");
                    fos.write(response);
                    fos.close();
                    i++;
 
                } catch (Exception e) {
                    System.out.println("Error in reading & storing images: " + e.getMessage());
                }
            }
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
 
        }
          return div;
    }
   
}
