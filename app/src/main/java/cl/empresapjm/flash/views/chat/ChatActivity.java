package cl.empresapjm.flash.views.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cl.empresapjm.flash.R;
import cl.empresapjm.flash.views.main.chats.ChatsFragment;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        String key = getIntent().getStringExtra(ChatsFragment.CHAT_KEY);


        String email = getIntent().getStringExtra(ChatsFragment.CHAT_RECEIVER);

        getSupportActionBar().setTitle(email);

    }
}
