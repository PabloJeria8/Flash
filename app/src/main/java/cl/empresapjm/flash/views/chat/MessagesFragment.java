package cl.empresapjm.flash.views.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.empresapjm.flash.R;
import cl.empresapjm.flash.adapters.MessageAdapter;
import cl.empresapjm.flash.adapters.MessagesCallback;
import cl.empresapjm.flash.views.main.chats.ChatsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment implements MessagesCallback {

    private MessageAdapter adapter;
    private RecyclerView recyclerView;

    public MessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String key = getActivity().getIntent().getStringExtra(ChatsFragment.CHAT_KEY);

        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter = new MessageAdapter(key, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void update() {
        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
    }
}
