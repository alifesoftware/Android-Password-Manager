package com.sladematthew.apm

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.sladematthew.apm.model.Password

import com.sladematthew.apm.model.PasswordList
import kotlinx.android.synthetic.main.item_password.view.*

class PasswordAdapter(var passwords: List<Password>,var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_password, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).itemView.name.text = passwords[position].label
    }

    override fun getItemCount(): Int {
        return passwords.size;
    }

    interface OnItemClickListener {
        fun onClick(viewHolder: ViewHolder, item: Password, position: Int)
        fun onLongClick(viewHolder: ViewHolder, item: Password, position: Int)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view),View.OnClickListener, View.OnLongClickListener
    {
        init
        {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(p0: View?): Boolean
        {
            var pos = layoutPosition
            if (pos < 0) {
                pos = 0
            }
            onItemClickListener.onLongClick(this,passwords[pos]!!, pos)
            return true
        }

        override fun onClick(v: View)
        {
            var pos = layoutPosition
            if (pos < 0) {
                pos = 0
            }
            onItemClickListener.onClick(this,passwords[pos]!!, pos)
        }
    }
}
