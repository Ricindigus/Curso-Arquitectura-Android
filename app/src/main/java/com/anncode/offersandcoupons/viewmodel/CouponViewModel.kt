package com.anncode.offersandcoupons.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponViewModel: ViewModel() {
    private var couponObservable = CouponObservable()
    private var recyclerCouponsAdapter:RecyclerCouponsAdapter? = null

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String?){
            imageUrl?.let {
                if (it.isNotEmpty()){
                    Picasso.get().load(it).into(imageView)
                }
            }
        }
    }

    fun callCoupons(){
        couponObservable.callCoupons()
    }

    fun getcoupons(): MutableLiveData<List<Coupon>>{
        return couponObservable.getCoupons()
    }

    fun setCouponsInRecycler(coupons: List<Coupon>){
        recyclerCouponsAdapter?.setCouponsList(coupons)
    }

    fun getRecyclerAdapter(): RecyclerCouponsAdapter?{
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this,R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun getCouponAt(position:Int) : Coupon?{
        var coupons = couponObservable.getCoupons().value
        return coupons?.get(position)
    }
}