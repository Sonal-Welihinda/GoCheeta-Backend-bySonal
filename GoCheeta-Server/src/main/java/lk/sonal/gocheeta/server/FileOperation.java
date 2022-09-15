/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import java.io.FileOutputStream;
import java.util.Base64;
import javax.ws.rs.core.Response;

/**
 *
 * @author sonal
 */
public class FileOperation {
    
    
    public void SaveFile(String fileName, ImgFile imgFile) throws Exception{
        try
        {
            FileOutputStream fos;
            fos = new FileOutputStream(fileName);
            byte byteArray[] = Base64.getMimeDecoder().decode(imgFile.getImgBase64().split(",")[1]);
            
            fos.write(byteArray);
            fos.flush();
            fos.close();
            System.out.print(fileName);
            
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    
}
