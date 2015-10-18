package com.example.uipractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	private ListView msgListView;
	private EditText inputText;
	private Button send;
	private MsgAdapter adapter;
	private List<Msg> msgList=new ArrayList<Msg>();
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();
        adapter=new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
        inputText=(EditText) findViewById(R.id.input_text);
        send=(Button) findViewById(R.id.send);
        msgListView=(ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		String content=inputText.getText().toString();
        		if(!"".equals(content)){
        			Msg msg=new Msg(content,Msg.TYPE_SENT);
        			msgList.add(msg);
        			adapter.notifyDataSetChanged();
        			msgListView.setSelection(msgList.size());
        			inputText.setText("");
        		}
        	}
        	
        });
    }


	private void initMsgs() {
		Msg msg1=new Msg("岐王宅里寻常见",Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2=new Msg("崔九堂前几度闻",Msg.TYPE_SENT);
		msgList.add(msg2);
		Msg msg3=new Msg("正是江南好风景",Msg.TYPE_RECEIVED);
		msgList.add(msg3);
		Msg msg4=new Msg("落花时节又逢君",Msg.TYPE_SENT);
		msgList.add(msg4);
		
	}

  
}
