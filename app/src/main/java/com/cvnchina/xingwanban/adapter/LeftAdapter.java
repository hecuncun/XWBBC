package com.cvnchina.xingwanban.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cvnchina.xingwanban.R;
import com.cvnchina.xingwanban.bean.ContentSortBean;

import java.util.List;

/**
 * Created by hecuncun on 2020-5-14
 */
public class LeftAdapter extends BaseAdapter {
    private Context mContext;
    private List<ContentSortBean.DataBean.ChildrenBeanX> mList;
    private int mCurSelectPosition = 0;

    public int getmCurSelectPosition() {
        return mCurSelectPosition;
    }

    public void setmCurSelectPosition(int mCurSelectPosition) {
        this.mCurSelectPosition = mCurSelectPosition;
    }

    public LeftAdapter(Context context, List<ContentSortBean.DataBean.ChildrenBeanX> list) {
        mContext=context;
        mList=list;
    }


    @Override
    public int getCount() {
        if (mList.size()>0){
            return mList.size();
        }else {
            return 0;
        }

    }

    @Override
    public Object getItem(int position) {
        if (mList.size()>0){
            return mList.get(position);
        }else {
            return null;
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater  = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_group, null);
            viewHolder.tv_group =convertView.findViewById(R.id.tv_group);
           convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        ContentSortBean.DataBean.ChildrenBeanX dataBean = mList.get(position);
        String group =dataBean.getColName();
        viewHolder.tv_group.setText(group);
        if (mCurSelectPosition==position){
            viewHolder.tv_group.setTextColor(mContext.getResources().getColor(R.color.color_primary_yellow));
            viewHolder.tv_group.setBackgroundColor(mContext.getResources().getColor(R.color.color_gray_151516));
        }else {
            viewHolder.tv_group.setTextColor(mContext.getResources().getColor(R.color.color_gray_F9F9F9));
            viewHolder.tv_group.setBackgroundColor(mContext.getResources().getColor(R.color.color_primary_bar));
        }
        return convertView;
    }

    static class ViewHolder {
         TextView tv_group;
    }
}
