package com.anncode.offersandcoupons.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.anncode.offersandcoupons.BR
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.viewmodel.CouponViewModel


class RecyclerCouponsAdapter(var couponViewModel: CouponViewModel, var resource: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    private var coupons : List<Coupon>? = null

    fun setCouponsList(coupons: List<Coupon>?){
        this.coupons = coupons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, resource: Int): CardCouponHolder {
        var layoutInflater = LayoutInflater.from(viewGroup!!.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater,resource, viewGroup, false)
        return CardCouponHolder(binding)
    }

    override fun getItemCount(): Int {
        return coupons?.size ?: 0
    }

    override fun onBindViewHolder(cardCouponHolder:  CardCouponHolder, position: Int) {
        cardCouponHolder.setDataCard(couponViewModel,position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position : Int) : Int{
        return resource
    }

    class CardCouponHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding:ViewDataBinding? =null

        init {
            this.binding = binding
        }

        fun setDataCard(couponViewModel: CouponViewModel, position:Int){
            binding?.setVariable(BR.model,couponViewModel)
            binding?.setVariable(BR.position,position)
            binding?.executePendingBindings()
        }

    }

}
