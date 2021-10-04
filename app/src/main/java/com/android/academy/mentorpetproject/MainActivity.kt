package com.android.academy.mentorpetproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hermes.returns.ui.returning.whatsinsidethebox.orderlist.OrderListAdapter

class MainActivity : AppCompatActivity() {
    private val listAdapter by lazy { OrderListAdapter(this.baseContext) /*{ handleSelectedOrder(it) }*/ }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        listAdapter.updateOrderList(Repository().getOrderList())
    }

    private fun setupRecyclerView() {
        findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            itemAnimator = DefaultItemAnimator()
            adapter = listAdapter
            isNestedScrollingEnabled = true
        }
    }

}