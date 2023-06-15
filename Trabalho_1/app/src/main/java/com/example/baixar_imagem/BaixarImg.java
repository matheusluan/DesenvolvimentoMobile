package com.example.baixar_imagem;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class BaixarImg extends AsyncTask<String, Void, Bitmap> {
    ImageButton btnBaixar;

    ProgressBar progressBar;
    ImageView imgView;

    public BaixarImg(ImageButton downloadBtn, ImageView imgView, ProgressBar progressBar) {
        this.btnBaixar = downloadBtn;
        this.imgView = imgView;
        this.progressBar = progressBar;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        Bitmap bitmap = null;

        try {
            InputStream in = new URL(url).openStream();

            bitmap = BitmapFactory.decodeStream(in);

            in.close();
        } catch (IOException e) {
            Log.e("DownloadTask", "Erro ao baixar imagem.");
        }

        return bitmap;
    }

    @Override
    protected void onPreExecute() {
        btnBaixar.setEnabled(false);
        imgView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        progressBar.setVisibility(View.INVISIBLE);
        imgView.setImageBitmap(bitmap);
        imgView.setVisibility(View.VISIBLE);
        btnBaixar.setEnabled(true);
    }
}
