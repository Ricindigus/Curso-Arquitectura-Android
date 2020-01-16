package com.anncode.offersandcoupons.model

import androidx.lifecycle.MutableLiveData

interface CouponRepositoryAPI {
    fun getCouponsAPI() : MutableLiveData<List<Coupon>>
    fun callCouponsAPI()

}