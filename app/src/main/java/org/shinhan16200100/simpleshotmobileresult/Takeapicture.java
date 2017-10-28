package org.shinhan16200100.simpleshotmobileresult;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.Matrix;

import java.io.File;
import java.io.IOException;

public class Takeapicture extends AppCompatActivity {
    public static final int REQUEST_IMAGE_CAPTURE = 1001;

    File file = null;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeapicture);

        picture = (ImageView)findViewById(R.id.picture);

        try {
            file = createFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void onButtonClicked(View v){
        Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        if (intent.resolveActivity((getPackageManager())) != null){
            startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
        }
    }
    private File createFile() throws IOException{
        String imageFileName = "receipt.jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File curFile = new File(storageDir,imageFileName);
        return curFile;
    }
    public int exifOrientationToDegrees(int exifOrientation){
        if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_90)
        {
            return 90;
        }
        else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_180)
        {
            return 180;
        }
        else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_270)
        {
            return 270;
        }
        return 0;
    }
    public Bitmap rotate(Bitmap bitmap, int degrees){
        if(degrees != 0 && bitmap != null)
        {
            Matrix m = new Matrix();
            m.setRotate(degrees, (float) bitmap.getWidth() / 2,
                    (float) bitmap.getHeight() / 2);

            try
            {
                Bitmap converted = Bitmap.createBitmap(bitmap, 0, 0,
                        bitmap.getWidth(), bitmap.getHeight(), m, true);
                if(bitmap != converted)
                {
                    bitmap.recycle();
                    bitmap = converted;
                }
            }
            catch(OutOfMemoryError ex)
            {
                // 메모리가 부족하여 회전을 시키지 못할 경우 그냥 원본을 반환합니다.
            }
        }
        return bitmap;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;

            if (file != null) {
                String imagePath = Uri.fromFile(file).getPath();
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);

                try {
                    //이미지 상황에 맞게 회전시킨다
                    ExifInterface exif = new ExifInterface(file.getAbsolutePath());

                    int exifOrienetation = exif.getAttributeInt(
                            ExifInterface.TAG_ORIENTATION,
                            ExifInterface.ORIENTATION_NORMAL);
                    int exifDegree = exifOrientationToDegrees(exifOrienetation);
                    bitmap = rotate(bitmap, exifDegree);

                    picture.setImageBitmap(bitmap);
                }
                catch(Exception e)
                {
                    Toast.makeText(this, "error start: " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "File is null.", Toast.LENGTH_LONG).show();
            }
        }
    }

}