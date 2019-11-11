package com.example.demo.controller;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2019/11/11.
 */

@RestController
@RequestMapping("/")
public class DemoController {
    @RequestMapping("clone")
    public String gitClone(String cloneURL){
        String localPath = "D:\\gitworkspace\\demo";
        String url = "https://github.com/ly774395333/jgitdemo001.git";
        return cloneRepository(url,localPath);
    }

    public static String cloneRepository(String url,String localPath)
    {
        try{
            System.out.println("开始下载......");
            CloneCommand cc = Git.cloneRepository().setURI(url);
            cc.setDirectory(new File(localPath)).call();
            System.out.println("下载完成......");
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
    }


}
