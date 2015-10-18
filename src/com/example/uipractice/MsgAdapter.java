package com.example.uipractice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {
	private int resourceid;
	
	public MsgAdapter(Context context,int textViewResourceId,List<Msg> objects){
		super(context,textViewResourceId,objects);
		resourceid=textViewResourceId;
	}
	
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		Msg msg=getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView==null){
			view=LayoutInflater.from(getContext()).inflate(resourceid, null);
			viewHolder=new ViewHolder();
			viewHolder.leftlayout=(LinearLayout) view.findViewById(R.id.left_layout);
			viewHolder.rightlayout=(LinearLayout) view.findViewById(R.id.right_layout);
			viewHolder.leftmsg=(TextView) view.findViewById(R.id.left_msg);
			viewHolder.rightmsg=(TextView) view.findViewById(R.id.right_msg);
			view.setTag(viewHolder);
		}else{
			view=convertView;
			viewHolder=(ViewHolder) view.getTag();
		}
		if(msg.getType()==Msg.TYPE_RECEIVED){
			viewHolder.leftlayout.setVisibility(View.VISIBLE);
			viewHolder.rightlayout.setVisibility(View.GONE);
			viewHolder.leftmsg.setText(msg.getContent());
		}else if(msg.getType()==Msg.TYPE_SENT){
			viewHolder.leftlayout.setVisibility(View.GONE);
			viewHolder.rightlayout.setVisibility(View.VISIBLE);
			viewHolder.rightmsg.setText(msg.getContent());}
		return view;
	}
	
	class ViewHolder{
		LinearLayout leftlayout;
		LinearLayout rightlayout;
		TextView leftmsg;
		TextView rightmsg;
	}

}
