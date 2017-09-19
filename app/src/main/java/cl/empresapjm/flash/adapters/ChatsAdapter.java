package cl.empresapjm.flash.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.github.siyamed.shapeimageview.BubbleImageView;
import com.squareup.picasso.Picasso;

import cl.empresapjm.flash.R;
import cl.empresapjm.flash.data.CurrentUser;
import cl.empresapjm.flash.data.Nodes;
import cl.empresapjm.flash.models.Chat;

/**
 * Created by Pablo on 09-09-2017.
 */

public class ChatsAdapter extends FirebaseRecyclerAdapter<Chat, ChatsAdapter.ChatHolder> {

    private ChatsListener listener;

    public ChatsAdapter(ChatsListener listener) {
        super(Chat.class, R.layout.list_item_chat, ChatHolder.class, new Nodes().userChat(new CurrentUser().uid()));
        this.listener = listener;
    }

    @Override
    protected void populateViewHolder(final ChatHolder viewHolder, Chat model, int position) {
        Picasso.with(viewHolder.view.getContext()).load(model.getPhoto()).centerCrop().fit().into(viewHolder.photo);
        viewHolder.email.setText(model.getReceiver());

        if (model.isNotification())
        {
            viewHolder.view.setVisibility(View.VISIBLE);
        }else
        {
            viewHolder.view.setVisibility(View.GONE);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Chat auxChat = getItem(viewHolder.getAdapterPosition());
                listener.clicked(auxChat.getKey(), auxChat.getReceiver());

            }
        });



/*        viewHolder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chat auxChat = getItem(viewHolder.getAdapterPosition());
                listener.clicked(auxChat.getKey(), auxChat.getReceiver());


            }
        });*/

    }

    public static class ChatHolder extends RecyclerView.ViewHolder{
        private BubbleImageView photo;
        private TextView email;
        private View view;

        public ChatHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photoBiv);
            email = itemView.findViewById(R.id.emailTv);
            view = itemView.findViewById(R.id.notificationV);
        }
    }

}
