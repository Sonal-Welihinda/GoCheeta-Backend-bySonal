/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author sonal
 */
public class FileOperation {
    
    
    public String SaveFile(String folder, String ImgBase64) throws Exception{
        try
        {
            String fileName ="ServerFiles/"+folder+"/"+System.currentTimeMillis()+"."+ImgBase64.substring("data:image/".length(), ImgBase64.indexOf(";base64"));
            FileOutputStream fos;
            fos = new FileOutputStream(fileName);
            byte byteArray[] = Base64.getDecoder().decode(ImgBase64.split(",")[1]);
            
            fos.write(byteArray);
            fos.flush();
            fos.close();
            return fileName;
        }
        catch (IOException e)
        {
            return "";
            
        }
        
      
    }
    
    
    public String readFile(String location) {
        try {
            String encodedString = "" ;
            byte[] fileContent = FileUtils.readFileToByteArray(new File(location));
            encodedString += "data:image/";
            encodedString += FilenameUtils.getExtension(location)+ ";base64,";
            encodedString += Base64.getMimeEncoder().encodeToString(fileContent);
            
            return encodedString;
        } catch (IOException ex) {
            Logger.getLogger(FileOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean deleteFile(String location){
        File file= new File(location); 
        
        if(file.delete()){
            return true;
        }else{
            return false;
        }
        
        
    }
    
}
