package com.stylingandroid.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class ListViewActivity extends ListActivity
{
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.main );
		
		List<Map<String, String>> data = 
				new ArrayList<Map<String,String>>();
		for( int i = 1; i <= 10; i++ )
		{
			Map<String, String> item = 
					new HashMap<String, String>();
			item.put( "name", String.format( "Item %d", i ) );
			data.add( item );
		}
		
		String[] from = { "name" };
		int[] to = { android.R.id.text1 };
		
		SimpleAdapter adapter = new SimpleAdapter( this, data,
				android.R.layout.simple_list_item_1, from, to );
		setListAdapter( adapter );
	}
}