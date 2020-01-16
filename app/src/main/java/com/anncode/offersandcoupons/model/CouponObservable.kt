package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable: BaseObservable() {
    private var repositoryAPI = CouponRepositoryAPIImpl()

    //repository
    fun callCoupons(){
        repositoryAPI.callCouponsAPI()
    }
    //viewmodel
    fun getCoupons(): MutableLiveData<List<Coupon>>{
        return  repositoryAPI.getCouponsAPI()
    }
}