package io.armcha.arch;


import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

/**
 * Created by glovebx on 20.05.2017.
 */

public abstract class BaseMVPPresenter<V extends BaseMVPContract.View> implements LifecycleObserver, BaseMVPContract.Presenter<V> {

    private Bundle stateBundle;
    private V view;

    @Override
    final public V getView() {
        return view;
    }

    @Override
    final public void attachLifecycle(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @Override
    final public void detachLifecycle(Lifecycle lifecycle) {
        lifecycle.removeObserver(this);
    }

    @Override
    final public void attachView(V view) {
        this.view = view;
    }

    @Override
    final public void detachView() {
        view = null;
    }

    @Override
    final public boolean isViewAttached() {
        return view != null;
    }

    @Override
    final public Bundle getStateBundle() {
        return stateBundle == null
                ? stateBundle = new Bundle()
                : stateBundle;
    }

    @CallSuper
    @Override
    public void onPresenterDestroy() {
        if (stateBundle != null && !stateBundle.isEmpty()) {
            stateBundle.clear();
        }
    }

    @Override
    public void onPresenterCreate() {
        //NO-OP
    }
}
