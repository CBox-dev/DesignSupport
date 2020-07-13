package com.store.data;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SampleAdapter extends FragmentPagerAdapter
{
    private final Context ctxt;
    private int pageCount = 3;

    public SampleAdapter(Context ctxt, FragmentManager mgr)
    {
        super(mgr);

        this.ctxt = ctxt;
    }

    @Override
    public int getCount()
    {
        return(pageCount);
    }

    @Override
    public Fragment getItem(int position)
    {
        return DataFragment.newInstance(position);
    }

    @Override
    public String getPageTitle(int position)
    {
        return DataFragment.getTitle(ctxt, position);
    }

    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }
}
