/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import javax.ejb.Asynchronous;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sonal
 */

@Path("FileService")
public class FileService {
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Upload")
    @Asynchronous
    public Response addBranch(String json) {
        FileOutputStream fos;
        Gson gson = new GsonBuilder().create();
        ImgFile imgFile = gson.fromJson(json, ImgFile.class);
        
        String fileName ="ServerFiles/"+imgFile.getFileLocaiton()+"/"+System.currentTimeMillis()+"."+imgFile.getImgBase64().substring("data:image/".length(), imgFile.getImgBase64().indexOf(";base64"));
        // decode Base64 String to image
        try
        {
            fos = new FileOutputStream(fileName);
            byte byteArray[] = Base64.getMimeDecoder().decode(imgFile.getImgBase64().split(",")[1]);
            
            fos.write(byteArray);
            fos.flush();
            fos.close();
            
            
           
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return Response.status(201).entity("{\"Error\":\""+e.getMessage()+"\"}").build();
        }

//        return result;
        
        return Response.status(201).entity("{\"ImgUrl\":\""+fileName+"\"}").build();
        
    }
    
    
    
    
}
