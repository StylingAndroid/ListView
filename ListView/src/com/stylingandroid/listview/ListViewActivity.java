package com.stylingandroid.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class ListViewActivity extends Activity
{
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.main );

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		for ( int i = 1; i <= 10; i++ )
		{
			Map<String, String> item = new HashMap<String, String>();
			item.put( "name", String.format( "Item %d", i ) );
			data.add( item );
		}

		String[] from = { "name" };
		int[] to = { android.R.id.text1 };

		SimpleAdapter adapter = new SimpleAdapter( this, data,
				android.R.layout.simple_list_item_1, from, to );
		
		ListView listView = (ListView)findViewById( android.R.id.list );
		listView.setAdapter( adapter );

		listView.setOnItemClickListener( new OnItemClickListener()
		{

			@Override
			public void onItemClick( AdapterView<?> listView, View view,
					int pos, long id )
			{
				TextView textView = (TextView) view.findViewById( android.R.id.text1 );
				toast( (String) textView.getText() );
			}
		} );

	}

	private void toast( String text )
	{
		Toast.makeText( ListViewActivity.this,
				String.format( "Item clicked: %s", text ), Toast.LENGTH_SHORT )
				.show();
	}
}