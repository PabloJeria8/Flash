package cl.empresapjm.flash.views.main.chats;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.empresapjm.flash.R;
import cl.empresapjm.flash.adapters.ChatsAdapter;
import cl.empresapjm.flash.adapters.ChatsListener;
import cl.empresapjm.flash.views.chat.ChatActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatsFragment extends Fragment implements ChatsListener{

    private ChatsAdapter adapter;
    public static final String CHAT_KEY = "cl.empresapjm.flash.views.main.chats.KEY.CHAT_KEY";
    public static final String CHAT_RECEIVER = "cl.empresapjm.flash.views.main.chats.KEY.CHAT_RECEIVER";

    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chats, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false );
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter =  new ChatsAdapter(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void clicked(String key, String mail) {
        Intent intent =  new Intent(getActivity(), ChatActivity.class);
        intent.putExtra(CHAT_KEY, key);
        intent.putExtra(CHAT_RECEIVER, mail);
        startActivity(intent);
    }
}
