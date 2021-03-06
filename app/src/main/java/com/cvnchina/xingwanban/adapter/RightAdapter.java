package com.cvnchina.xingwanban.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cvnchina.xingwanban.R;
import com.cvnchina.xingwanban.bean.ContentSortBean;

import java.util.List;

/**
 * Created by hecuncun on 2020-5-14
 */
public class RightAdapter extends BaseAdapter {
    private Context mContext;
    private List<ContentSortBean.DataBean.ChildrenBeanX.ChildrenBean> mList;
    private int mCurSelectPosition = -1;

    public int getmCurSelectPosition() {
        return mCurSelectPosition;
    }

    public void setmCurSelectPosition(int mCurSelectPosition) {
        this.mCurSelectPosition = mCurSelectPosition;
    }

    public RightAdapter(Context context, List<ContentSortBean.DataBean.ChildrenBeanX.ChildrenBean> list) {
        mContext=context;
        mList=list;
    }

    public void setData(List<ContentSortBean.DataBean.ChildrenBeanX.ChildrenBean> list){
        mList=list;
        notifyDataSetChanged();
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
            convertView = inflater.inflate(R.layout.item_child, null);
            viewHolder.tv_group =convertView.findViewById(R.id.tv_child);
            viewHolder.iv_select =convertView.findViewById(R.id.iv_select);
           convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        ContentSortBean.DataBean.ChildrenBeanX.ChildrenBean dataBean = mList.get(position);
        String group =dataBean.getColName();
        viewHolder.tv_group.setText(group);
        if (mCurSelectPosition==position){
            viewHolder.iv_select.setImageResource(R.mipmap.icon_selected);
        }else {
            viewHolder.iv_select.setImageResource(R.mipmap.icon_normal);
        }
        return convertView;
    }

    static class ViewHolder {
         TextView tv_group;
         ImageView iv_select;
    }
}
