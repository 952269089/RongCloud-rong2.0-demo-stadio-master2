package rong.io.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;


public  class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String Token = "Ls5fgDHf3fvE7qdMKUS30z3tw/+YdcuJOgY8WXe71FzEpTqX7FYdu0U/p6GJBWTETDobCQMsWAQ2DhQ7xVIQfQ==";//test
        /**
         * IMKit SDK调用第二步
         *
         * 建立与服务器的连接
         *
         */
        RongIM.connect(Token, new RongIMClient.ConnectCallback() {

            /**
             * Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token
             */
            @Override
            public void onTokenIncorrect() {

                Log.d("LoginActivity", "--onTokenIncorrect");
                }

            /**
             * 连接融云成功
             * @param userid 当前 token
             */
            @Override
            public void onSuccess(String userid) {

                Log.d("LoginActivity", "--onSuccess" + userid);
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                finish();

            }

            /**
             * 连接融云失败
             * @param errorCode 错误码，可到官网 查看错误码对应的注释
             *                  http://www.rongcloud.cn/docs/android.html#常见错误码
             */
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

                Log.d("LoginActivity", "--onError" + errorCode);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /**
         * 启动单聊
         * context - 应用上下文。
         * targetUserId - 要与之聊天的用户 Id。
         * title - 聊天的标题，如果传入空值，则默认显示与之聊天的用户名称。
         */
        if (RongIM.getInstance() != null) {
         //danliao   //RongIM.getInstance().startPrivateChat(MainActivity.this, "2462", "hello");
          //  Toast.makeText(MainActivity.this, "你好!", Toast.LENGTH_LONG).show();
         //duorenliaotian
           RongIM.getInstance().startGroupChat(MainActivity.this, "9527", "标题");
            //Intent intent=new Intent(MainActivity.this,SubConversationListActivtiy.class);
            //startActivity(intent);
          //qidongtaolunzu
           // RongIM.getInstance().startDiscussionChat(MainActivity.this, "9527", "标题");
            startChatRoomChat(MainActivity.this,"001",true);
            //joinChatRoom("001",0);
        }

        return super.onOptionsItemSelected(item);
    }


    public  void startChatRoomChat(Context context,String chatRoomId,boolean createIfNotExist){};

    public  void joinChatRoom(final String chatroomId, final int defMessageCount){};

}
