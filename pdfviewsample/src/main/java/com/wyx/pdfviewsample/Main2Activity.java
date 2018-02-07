package com.wyx.pdfviewsample;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import net.sf.andpdf.pdfviewer.gui.PdfView;
import net.sf.andpdf.utils.FileUtils;

public class Main2Activity
    extends Activity
    implements OnClickListener
{

  private PdfView pdfView;

  private View preview;

  private View next;

  private View zoomIn;

  private View zoomOut;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    pdfView = findViewById(R.id.pdf_view);

    preview = findViewById(R.id.preview);
    preview.setOnClickListener(this);

    next = findViewById(R.id.next);
    next.setOnClickListener(this);

    zoomIn = findViewById(R.id.zoomIn);
    zoomIn.setOnClickListener(this);

    zoomOut = findViewById(R.id.zoomOut);
    zoomOut.setOnClickListener(this);
  }

  @Override
  protected void onStart()
  {
    super.onStart();
    try
    {
      pdfView.parsePDF(FileUtils.fileFromAsset(this, "sample.pdf"), null);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    pdfView.startRenderThread(1, 1.0f);
  }

  @Override
  public void onClick(View v)
  {
    if (v == next)
    {
      pdfView.nextPage();
    }
    else if (v == preview)
    {
      pdfView.prevPage();
    }
    else if (v == zoomIn)
    {
      pdfView.zoomIn();
    }
    else if (v == zoomOut)
    {
      pdfView.zoomOut();
    }
  }

}
