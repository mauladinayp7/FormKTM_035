/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.a.formktm;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mladi
 */
@Controller
public class Controllerktm {
    @RequestMapping("/view")
    public String getData(@RequestParam("gambar") MultipartFile gambar,
                          @RequestParam("nama") String text,
                          @RequestParam("nim") String number,
                          @RequestParam("fakultas") String fakultas,
                          @RequestParam("jurusan") String jurusan,
                          Model paket )
            throws IOException
    {
        String blob = Base64.encodeBase64String(gambar.getBytes());
        
        String isigambar = "data:image/*;base64, "+blob+" ";
        
        paket.addAttribute("gbr", isigambar);
        paket.addAttribute("nama", text);
        paket.addAttribute("nim", number);
        paket.addAttribute("fakultas", fakultas);
        paket.addAttribute("jurusan", jurusan);
        
        return "view";
    
    
    }
}
