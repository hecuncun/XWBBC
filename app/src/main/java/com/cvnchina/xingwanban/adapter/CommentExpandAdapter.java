package com.cvnchina.xingwanban.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cvnchina.xingwanban.R;
import com.cvnchina.xingwanban.bean.EvaluateListBean;
import com.cvnchina.xingwanban.glide.GlideUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: Moos
 * E-mail: moosphon@gmail.com
 * Date:  18/4/20.
 * Desc: 评论与回复列表的适配器
 */

public class CommentExpandAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "CommentExpandAdapter";
    private List<EvaluateListBean.DataBean.ItemsBean> commentBeanList;
    private List<EvaluateListBean.DataBean.ItemsBean.ChildCommentBean> replyBeanList;
    private Context context;
    private int pageIndex = 1;

    public CommentExpandAdapter(Context context, List<EvaluateListBean.DataBean.ItemsBean> commentBeanList) {
        this.context = context;
        this.commentBeanList = commentBeanList;
    }

    @Override
    public int getGroupCount() {
        return commentBeanList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        if(commentBeanList.get(i).getChildComment()== null){
            return 0;
        }else {
            return commentBeanList.get(i).getChildComment().size()>0 ? commentBeanList.get(i).getChildComment().size():0;
        }

    }

    @Override
    public Object getGroup(int i) {
        return commentBeanList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return commentBeanList.get(i).getChildComment().get(i1);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getCombinedChildId(groupPosition, childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    boolean isLike = false;

    @Override
    public View getGroupView(final int groupPosition, boolean isExpand, View convertView, ViewGroup viewGroup) {
        final GroupHolder groupHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_item_layout, viewGroup, false);
            groupHolder = new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        }else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        GlideUtils.showCircle(groupHolder.logo,commentBeanList.get(groupPosition).getUserHeadPic(),R.mipmap.head1);
        groupHolder.tv_name.setText(commentBeanList.get(groupPosition).getUserNickName());
        groupHolder.tv_content.setText(commentBeanList.get(groupPosition).getContent()+"  "+commentBeanList.get(groupPosition).getCreateDate());
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        final ChildHolder childHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_reply_item_layout,viewGroup, false);
            childHolder = new ChildHolder(convertView);
            convertView.setTag(childHolder);
        }
        else {
            childHolder = (ChildHolder) convertView.getTag();
        }

        String replyUser = commentBeanList.get(groupPosition).getChildComment().get(childPosition).getUserNickName();
        if(!TextUtils.isEmpty(replyUser)){
            childHolder.tv_name.setText(replyUser + ":");
        }else {
            childHolder.tv_name.setText("无名"+":");
        }

        childHolder.tv_content.setText(commentBeanList.get(groupPosition).getChildComment().get(childPosition).getContent());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private class GroupHolder{
        private ImageView logo;
        private TextView tv_name, tv_content, tv_time;
        private ImageView iv_like;
        public GroupHolder(View view) {
            logo = (ImageView) view.findViewById(R.id.iv_head_photo);
            tv_content = (TextView) view.findViewById(R.id.tv_content);
            tv_name = (TextView) view.findViewById(R.id.tv_nick_name);
        }
    }

    private class ChildHolder{
        private TextView tv_name, tv_content;
        public ChildHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_content = (TextView) view.findViewById(R.id.tv_reply);
        }
    }


    /**
     * by moos on 2018/04/20
     * func:评论成功后插入一条数据
     * @param commentDetailBean 新的评论数据
     */
    public void addTheCommentData(EvaluateListBean.DataBean.ItemsBean commentDetailBean){
        if(commentDetailBean!=null){

            commentBeanList.add(commentDetailBean);
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("评论数据为空!");
        }

    }

    /**
     * by moos on 2018/04/20
     * func:回复成功后插入一条数据
     * @param replyDetailBean 新的回复数据
     */
    public void addTheReplyData(EvaluateListBean.DataBean.ItemsBean.ChildCommentBean replyDetailBean, int groupPosition){
        if(replyDetailBean!=null){
            Log.e(TAG, "addTheReplyData: >>>>该刷新回复列表了:"+replyDetailBean.toString() );
            if(commentBeanList.get(groupPosition).getChildComment() != null ){
                commentBeanList.get(groupPosition).getChildComment().add(replyDetailBean);
            }else {
                List<EvaluateListBean.DataBean.ItemsBean.ChildCommentBean> replyList = new ArrayList<>();
                replyList.add(replyDetailBean);
                commentBeanList.get(groupPosition).setChildComment(replyList);
            }
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("回复数据为空!");
        }

    }

    /**
     * by moos on 2018/04/20
     * func:添加和展示所有回复
     * @param replyBeanList 所有回复数据
     * @param groupPosition 当前的评论
     */
    private void addReplyList(List<EvaluateListBean.DataBean.ItemsBean.ChildCommentBean> replyBeanList, int groupPosition){
        if(commentBeanList.get(groupPosition).getChildComment() != null ){
            commentBeanList.get(groupPosition).getChildComment().clear();
            commentBeanList.get(groupPosition).getChildComment().addAll(replyBeanList);
        }else {

            commentBeanList.get(groupPosition).setChildComment(replyBeanList);
        }

        notifyDataSetChanged();
    }

}
