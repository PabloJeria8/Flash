package cl.empresapjm.flash.views.main.drawer;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import cl.empresapjm.flash.data.CurrentUser;
import cl.empresapjm.flash.data.EmailProcessor;
import cl.empresapjm.flash.data.Nodes;
import cl.empresapjm.flash.data.PhotoPreference;
import cl.empresapjm.flash.models.LocalUser;

/**
 * Created by Pablo on 31-08-2017.
 */

public class UploadPhoto {

    private Context context;

    public UploadPhoto(Context context) {
        this.context = context;
    }

    public void toFirebase(String path){
        final CurrentUser currentUser = new CurrentUser();
        String folder = new EmailProcessor().sanitizedEmail(currentUser.email()+"/");
        /*String folder = currentUser.sanitizedEmail(currentUser.email()+"/");*/
        String photoName = "avatar.jpeg";
        String baseUrl = "gs://flash-359bc.appspot.com/avatars/";
        String redUrl = baseUrl+folder+photoName;

        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(redUrl);
        storageReference.putFile(Uri.parse(path)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                @SuppressWarnings("VisibleForTests") String[] fullUrl = taskSnapshot.getDownloadUrl().toString().split("&token");
                String url = fullUrl[0];

                new PhotoPreference(context).photosave(url);
                Log.d("URL",url);

                LocalUser user = new LocalUser();
                user.setEmail(currentUser.email());
                user.setName(currentUser.getCurrentUser().getDisplayName());
                user.setPhoto(url);
                user.setUid(currentUser.uid());

                String key = new EmailProcessor().sanitizedEmail(currentUser.email());
                /*String key = currentUser.sanitizedEmail(currentUser.email());*/
                /*new Nodes().users().child(key).setValue(user);*/

                new Nodes().user(key).setValue(user);
                FirebaseDatabase.getInstance().getReference().child("users").child(key).setValue(user);

            }
        });

    }

}
