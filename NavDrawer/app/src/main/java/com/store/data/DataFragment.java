package com.store.data;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DataFragment extends Fragment
{
    private static final String KEY_POSITION = "position";

    public static DataFragment newInstance(int position) {
        DataFragment frag = new DataFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return frag;
    }
    
    public static String getTitle(Context ctxt, int position) {
        return String.format(ctxt.getString(R.string.content), position + 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_data_store, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        TextView data = (TextView) view.findViewById(R.id.dataFragment);
       
        int position = getArguments().getInt(KEY_POSITION, -1);
        data.setHint(getTitle(getActivity(), position));
        
    }
    
}
