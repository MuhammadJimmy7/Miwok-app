package com.example.android.miwok;

import android.app.Activity;
import android.app.LauncherActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Words> {
    int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Words> numbersArrayList, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, numbersArrayList);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Words currentWordsLocation = getItem(position);

        TextView miwok = (TextView) listItemView.findViewById(R.id.Miwok);
        TextView english = (TextView) listItemView.findViewById(R.id.English);
        ImageView icon = (ImageView) listItemView.findViewById(R.id.image);
        miwok.setText(currentWordsLocation.getmMiwokTranslation());
        english.setText(currentWordsLocation.getmDefaultTranslation());
        if (currentWordsLocation.hasImage()) {
            icon.setImageResource(currentWordsLocation.getImageResourceId());
            icon.setVisibility(View.VISIBLE);
        } else {
            icon.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
