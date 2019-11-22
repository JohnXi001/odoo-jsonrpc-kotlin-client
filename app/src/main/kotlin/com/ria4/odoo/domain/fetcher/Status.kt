package com.ria4.odoo.domain.fetcher

/**
 * Created by glovebx on 18.09.2017.
 */
sealed class Status {

    object LOADING : Status()
    object ERROR : Status()
    object SUCCESS : Status()
    object EMPTY_SUCCESS : Status()
    object IDLE : Status()
}