package cl.empresapjm.flash.views.chat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.empresapjm.flash.R;
import cl.empresapjm.flash.views.main.chats.ChatsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageInputFragment extends Fragment {


    public MessageInputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_input, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final String key =  getActivity().getIntent().getStringExtra(ChatsFragment.CHAT_KEY);

        final EditText editText =  view.findViewById(R.id.userInputEt);
        editText.setHint("Escriba un mensaje");

        ImageButton imageButton = view.findViewById(R.id.sendBtn);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new SendMessage().validateMessage(editText.getText().toString(), key);
                editText.setText("");



            }
        });


    }



}
