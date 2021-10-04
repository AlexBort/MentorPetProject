package com.android.academy.mentorpetproject

import com.android.academy.mentorpetproject.Repository.OrderDetail
import java.util.ArrayList

class Repository {

    fun getOrderList(): List<OrderDetail> {
        return getList()
    }

    class OrderDetail(
        val orderDate: String,
        val orderNumber: String,
        val itemPrice: String,
        val allItemsReturned: Boolean
    )


    fun getReturnedOrder(): OrderDetail {
        return OrderDetail("28 вересня 2021", "L123456788", "$568.52", true)
    }

    fun getNotReturnedOrder(): OrderDetail {
        return OrderDetail("28 вересня 2021", "L123456788", "$568.52", false)
    }


   private fun getList(): List<OrderDetail> {
        val list: MutableList<OrderDetail> = ArrayList()
        list.add(getReturnedOrder())
        list.add(getNotReturnedOrder())
        list.add(getReturnedOrder())
        list.add(getReturnedOrder())
        list.add(getReturnedOrder())
        list.add(getNotReturnedOrder())
        list.add(getNotReturnedOrder())
        list.add(getReturnedOrder())
        list.add(getNotReturnedOrder())
        list.add(getReturnedOrder())
        list.add(getReturnedOrder())
        list.add(getReturnedOrder())
        list.add(getNotReturnedOrder())
        list.add(getReturnedOrder())
        list.add(getReturnedOrder())
        return list
    }


}