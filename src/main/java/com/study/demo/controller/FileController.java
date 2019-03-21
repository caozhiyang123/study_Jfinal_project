package com.study.demo.controller;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class FileController extends Controller
{
    public void upload(){
        UploadFile file = getFile();
        renderText(file == null?"file is null":"upload file success");
    }
}
