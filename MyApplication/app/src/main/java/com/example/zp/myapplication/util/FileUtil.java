package com.example.zp.myapplication.util;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;

/**
 * Created by ZHANGPING129 on 2016-04-12.
 */
public class FileUtil {
    public final static String ALBUMPATH=".mySecretlife";//相册文件夹名称

    /**
     * 获取SD卡路径
     * @return sd卡路径
     */
    public static String getSDPath(){
        String mSDPath="";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return Environment.getExternalStorageDirectory().toString();
        } else {
            Log.e("SDCard", "no sdcard found!");
        }
        return mSDPath;
    }

    /**
     * 获取相册路径
     * @return mAlbumPath 相册路径
     */
    public static String getAlbumPath(){
        String mAlbumPath="";
        if(!TextUtils.isEmpty(getSDPath())){
            mAlbumPath=getSDPath()+ File.separator+ALBUMPATH;
        }
        return mAlbumPath;
    }

    /**
     * 创建相册文件夹
     */
    public static void createrAlbum(){
        String path=getAlbumPath();
        if(!isExists(path)){
            makeDir(path);
        }
    }

    /**
     * 判断文件（夹）是否存在
     * @param path
     * @return mExists
     */
    public static boolean isExists(String path){
        boolean mExists=false;
        try {
            File file= new File(path);
            if(file.exists()){
                mExists=true;
            }
        }
        catch(Exception e){
            Log.e("zp--fileisExists","no");
        }

        return mExists;
    }

    /**
     * 判断文件（夹）是否存在
     * @param file
     * @return mExists
     */
    public static boolean isExists(File file){
        boolean mExists=false;
        try {
            if(file.exists()){
                mExists=true;
            }
        }
        catch(Exception e){
            Log.e("zp--fileisExists","no");
        }
        return mExists;
    }

    /**
     * 创建文件夹
     */
    public static void makeDir(String path){
        try{
            File file = new File(path);
            if(!file.exists()){
                file.mkdir();
            }
        }catch(Exception e){
            Log.e("zp--filemkdir","err");
        }
    }

}
