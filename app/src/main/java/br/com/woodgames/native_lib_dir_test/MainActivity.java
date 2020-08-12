package br.com.woodgames.native_lib_dir_test;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    loadDefault();
  }

  private void loadDefault()
  {
    try
    {
      String path = String.format("%s/libstockfish.so", getApplicationInfo().nativeLibraryDir);
      Process process = Runtime.getRuntime().exec(path);

      try
      {
        process.waitFor();
      }
      catch (InterruptedException ignore)
      {}
    }
    catch (Exception e)
    {
      Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
      e.printStackTrace();
    }
  }
}