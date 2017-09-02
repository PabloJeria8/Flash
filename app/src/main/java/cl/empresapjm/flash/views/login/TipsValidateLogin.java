package cl.empresapjm.flash.views.login;

import cl.empresapjm.flash.data.CurrentUser;

public class TipsValidateLogin {

    private LoginCallback callback;

    public TipsValidateLogin(LoginCallback callback) {
        this.callback = callback;
    }

    public void LoginValidate (){
        if (new CurrentUser().getCurrentUser() != null){
            callback.logged();
        }else{
            callback.signUp();
        }

    }

}
