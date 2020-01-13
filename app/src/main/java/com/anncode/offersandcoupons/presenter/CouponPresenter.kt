package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

interface CouponPresenter {
    fun getCoupons()
    fun showCoupons(coupons: ArrayList<Coupon>?)
}