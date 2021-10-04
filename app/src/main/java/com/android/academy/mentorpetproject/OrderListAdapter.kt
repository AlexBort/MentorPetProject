package com.hermes.returns.ui.returning.whatsinsidethebox.orderlist

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.mentorpetproject.R
import com.android.academy.mentorpetproject.Repository
import com.google.android.material.card.MaterialCardView


class OrderListAdapter(
    context: Context/*, private val onOrderSelected: (Repository.OrderDetail) -> Unit*/
) : RecyclerView.Adapter<OrderListAdapter.OrderListViewHolder>() {
    fun updateOrderList(orders: List<Repository.OrderDetail>) {
        this.orders = orders
        notifyDataSetChanged()
    }

    val mContext: Context = context

    private lateinit var orders: List<Repository.OrderDetail>

    inner class OrderListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
//            view.setOnClickListener {
//                if (adapterPosition != INVALID_POSITION) {
//                    onOrderSelected(orders[adapterPosition])
//                }
//            }
        }

        fun bind(order: Repository.OrderDetail) {
//            val some = DateTime.parse(order.orderDate)
//            val str = some.specialFormat(mContext, TemporalFormat.RETURNS_ORDER_DATE)
            val resours = mContext.resources

            val big = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                resours.getDimension(R.dimen.big), resours.displayMetrics
            ).toInt()
            val small = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                resours.getDimension(R.dimen.small), resours.displayMetrics
            ).toInt()
            view.minimumHeight = if (order.allItemsReturned) {
                big
            } else {
                small
            }

//            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics)
            view.findViewById<TextView>(R.id.order_date).text = order.orderDate

            view.findViewById<TextView>(R.id.order_total_value).text = order.itemPrice
            view.findViewById<TextView>(R.id.order_number_value).text = order.orderNumber
            view.findViewById<MaterialCardView>(R.id.all_items_returned_card).visibility = if (order.allItemsReturned) VISIBLE else GONE
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        OrderListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                viewType, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: OrderListViewHolder, position: Int) =
        holder.bind(orders[position])

    override fun getItemCount() = orders.size

    companion object {
        private const val INVALID_POSITION = -1
    }
}

