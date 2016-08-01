package com.example.admin.simplelistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 8/1/2016.
 */
public class listAdapter extends ArrayAdapter<String> {

    private static final String TAG = "listAdapterTAG_";

    private TextView mName;
    private ImageView mIcon;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //converView is the view that will be inflate
        //parent is a helper tu get the actual context
        //Get the actual String from the ArrayList with the position
        //Create an inflater that uses the view parent context <-- xml to view
        //Compare the first letter (charAt) <-- vowel or consonant
        //Get the reference for the TextView and the ImageView findViewbyId
        //return the view that you just inflated

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View myView = inflater.inflate(R.layout.list_item, parent, false);

        mName = (TextView) myView.findViewById(R.id.a_textview_item);
        mIcon = (ImageView) myView.findViewById(R.id.a_image_item);

        String str = getItem(position).toLowerCase();
        char ch = str.charAt(0);
        switch (ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                Log.d(TAG, "getView: vowel");
                mName.setText(getItem(position));
                mIcon.setImageResource(R.drawable.ic_thumb_up_black_24dp);
                break;
            default:
                Log.d(TAG, "getView: consonant");
                mName.setText(getItem(position));
                mIcon.setImageResource(R.drawable.ic_thumb_down_black_24dp);
                break;
        }

        return myView;
    }

    public listAdapter(Context context, int resource) {
        super(context, resource);
    }

    public listAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public listAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public listAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public listAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public listAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
