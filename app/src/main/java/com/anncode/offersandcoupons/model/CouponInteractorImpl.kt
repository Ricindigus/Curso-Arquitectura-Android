package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

class CouponInteractorImpl(var couponPresenter: CouponPresenter):CouponInteractor {

    private var couponRepositoryAPI : CouponRepositoryAPI = CouponRepositoryAPIImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepositoryAPI.getCouponsAPI()
    }

    override fun getCouponsDB() {

    }
}