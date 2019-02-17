package app.learn.koin.domain.router

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import app.learn.koin.external.constant.Constant

fun FragmentManager.openFragment (
    container: Int,
    fragment: Fragment,
    bundle: Bundle? ) {

    bundle?.let {
        fragment.arguments = it
    }

    val transaction = beginTransaction()
    transaction.replace(container, fragment)
    transaction.commit()
}