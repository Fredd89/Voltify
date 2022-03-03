package com.example.voltify;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.*;

public class ManageFile {
    public String readFile(String fileName, Context c) {

        BufferedReader fileIn;
        String outputFile;
        StringBuilder strB = new StringBuilder();

        try{
            fileIn= new BufferedReader(new InputStreamReader(c.openFileInput(fileName)));
            while((outputFile = fileIn.readLine()) != null) {
                strB.append(outputFile + "\n");
            }
        }
        catch(FileNotFoundException e){
            Log.e("!ifFileExists", "File does not exists");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strB.toString();

    }

    public String writeFile(String fileName, String str, Context c) {

        String result = "";
        FileOutputStream file;

        try
        {
            file = c.openFileOutput(fileName, Context.MODE_PRIVATE);
            file.write(str.getBytes());
            file.close();
            result = "File correctly written";
        }

        catch (FileNotFoundException e) {
            Log.e("ManageFile", "FNF error intercepted");
            e.printStackTrace();
            result = "File not found Exception";
        }

        catch (IOException e) {
            Log.e("ManageFile", "IO error intercepted");
            e.printStackTrace();
            result = "Input Output Exception";
        }
        return result;
    }

    public String readRawFile(Context c) {
        BufferedReader fileIn;
        Resources res = c.getResources();
        String outputFile = "";
        StringBuilder strB = new StringBuilder();

        try {
            InputStream is = res.openRawResource(R.raw.song);
            fileIn = new BufferedReader(new InputStreamReader(is));
            while ((outputFile = fileIn.readLine()) != null) {
                strB.append(outputFile + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return strB.toString();
    }

    public String readAssetsFile(Context c) {
        BufferedReader fileIn;
        String outputFile = "";
        AssetManager am = c.getAssets();
        StringBuilder strB = new StringBuilder();

        try {
            InputStream is = am.open("song.txt");
            fileIn = new BufferedReader(new InputStreamReader(is));
            while ((outputFile = fileIn.readLine()) != null) {
                strB.append(outputFile + "\n");
            }
        }
        catch (FileNotFoundException e) {
            Log.e("!ifFileExists", "File in Assets folder does not exists");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return strB.toString();
    }
}
