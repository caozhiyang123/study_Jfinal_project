package com.study.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;

public class FileController extends Controller
{
    
    
    public void uploadSuccess(){
        render("../view/success.html");
    }
    
    public void upload(){
        UploadFile file = getFile("upload_file","/file/upload",5*1024*1024);
        saveUploadFile(file);
    }

    public void saveUploadFile(UploadFile file)
    {
        String path = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String fileName = file.getFileName();
        File source = file.getFile();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String prefix;
        if(".png".equalsIgnoreCase(extension) || ".jpg".equalsIgnoreCase(extension) || ".gif".equalsIgnoreCase(extension)){
            prefix = "img";
            fileName = generateWord() + extension;
        }else{
            prefix = "file";
        }
        JSONObject json = new JSONObject();
        try
        {
            FileInputStream fis = new FileInputStream(source);
            File targetDir = new File(PathKit.getWebRootPath() + "/upload/" + prefix + "/u/" + path);
            if (!targetDir.exists()) { targetDir.mkdirs();}
            File target = new File(targetDir, fileName);
            if (!target.exists()) { target.createNewFile();}
            FileOutputStream fos = new FileOutputStream(target);
            byte[] bts = new byte[1024];
            while (fis.read(bts, 0, 1024) != -1) {
                fos.write(bts, 0, 1024);
            }
            fos.close();
            fis.close();
            json.put("error", 0);
            json.put("url", "/" + prefix + "/u/" + path + "/" + fileName);
            source.delete();
            
        } catch (FileNotFoundException e)
        {
            json.put("error", 1);
            json.put("message", "upload image error and try again");
        }catch (IOException e1){
            json.put("error", 1);
            json.put("message", "io exception and try again");
        }
        if(Integer.parseInt(json.get("error").toString()) == 1){
            renderJson(json.toJSONString());
        }else{
            renderHtml("<script>alert('upload success');location.href='/file/load/uploadSuccess'</script>");
        }
    }
    
    private String generateWord() {
        String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z" };
        List<String> list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(5, 9);
        return result;
    }
    
    public void downTempFile(){
        String tempName = getPara("tempName");
        renderFile(new File(PathKit.getWebRootPath() + "/download/"+tempName));
    }
}
