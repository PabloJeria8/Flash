package cl.empresapjm.flash.views.main.finder;

/**
 * Created by Pablo on 08-09-2017.
 */

public interface FinderCallback {

    void error(String error);
    void success();
    void notFound();
}
