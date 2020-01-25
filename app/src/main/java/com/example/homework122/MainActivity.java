package com.example.homework122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private static final int INDEX_START = 1, INDEX_END = 10;

	private static String urlBase = "https://myfile.org/";
	private static int imageIndex =
			(int) (Math.random() * (INDEX_END - INDEX_START + 1)) + INDEX_START;

	private Button prevButton, nextButton;
	private TextView imageAddressText;

	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();

		url = urlBase + imageIndex;

		imageAddressText.setText(url);
		prevButton.setOnClickListener(v -> prev());
		nextButton.setOnClickListener(v -> next());
	}

	private void initViews() {
		prevButton = findViewById(R.id.prevButton);
		nextButton = findViewById(R.id.nextButton);
		imageAddressText = findViewById(R.id.imageAddressText);
	}

	private void prev() {
		if (imageIndex == INDEX_START)
			finishAffinity();
		else
			switchTo(imageIndex - 1);
	}

	private void next() {
		if (imageIndex == INDEX_END)
			Toast.makeText(this, R.string.end_message, Toast.LENGTH_SHORT).show();
		else
			switchTo(imageIndex + 1);
	}

	private void switchTo(int index) {
		imageIndex = index;
		startActivity(new Intent(this, MainActivity.class));
	}
}
