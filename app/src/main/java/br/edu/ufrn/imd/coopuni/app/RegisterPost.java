package br.edu.ufrn.imd.coopuni.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class RegisterPost extends AppCompatActivity {
  private static final int FOTO = 1;
  private ImageButton fotoBtn;
  private Spinner areaSpinner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register_post);

    fotoBtn = (ImageButton) findViewById(R.id.fotoBtn);
    fotoBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, FOTO);
      }
    });

    areaSpinner = (Spinner) findViewById(R.id.areaSpinner);

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.areas_array, android.R.layout.simple_spinner_item);

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    areaSpinner.setAdapter(adapter);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(requestCode==FOTO) {
      Bitmap foto = (Bitmap) data.getExtras().get("data");

      fotoBtn.setImageBitmap(foto);
    }
  }
}
