package cl.empresapjm.flash.views.chat;

import cl.empresapjm.flash.data.CurrentUser;
import cl.empresapjm.flash.data.Nodes;
import cl.empresapjm.flash.models.Message;

/**
 * Created by Pablo on 19-09-2017.
 */

public class SendMessage {

    public void validateMessage(String message, String chatId)
    {
        if (message.trim().length()>0)
        {
            String email = new CurrentUser().email();
            Message msg = new Message();
            msg.setContent(message);
            msg.setOwner(email);

            new Nodes().messages(chatId).push().setValue(msg);

        }

    }
}
