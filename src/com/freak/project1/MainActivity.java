package com.freak.project1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.cordova.*;

import android.os.Bundle;

public class MainActivity extends DroidGap {

	 @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        // Set by <content src="index.html" /> in config.xml
	        super.loadUrl("file:///android_asset/www/index.html");
	        try
	        {
	            String pName = this.getClass().getPackage().getName();
	            this.copy("tanaman_herbal.sqlite","/data/data/"+pName+"/databases/");
	        }
	        catch (IOException e)
	        {
	        	e.printStackTrace();
	        }
	}
	    void copy(String file, String folder) throws IOException {
	    	File CheckDirectory;
	    	CheckDirectory = new File(folder);
	    	if (!CheckDirectory.exists())
	    	{ 
	    		CheckDirectory.mkdir();
	    	}

	    	InputStream in = getApplicationContext().getAssets().open(file);
	    	OutputStream out = new FileOutputStream(folder+file);

	    	// Transfer bytes from in to out
	    	byte[] buf = new byte[1024];
	    	int len; while ((len = in.read(buf)) > 0) out.write(buf, 0, len);
	    	in.close(); out.close();
	    
	    }
}
