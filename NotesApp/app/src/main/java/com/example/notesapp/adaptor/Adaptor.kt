package com.example.notesapp.adaptor
import android.content.Context
import android.content.Intent
import android.database.DatabaseUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.databinding.RvlayoutBinding
import com.example.notesapp.roomdb.Notes

class Adaptor(val context: Context, private var list:List<Notes>, val Listener: OnItemClickListener) :RecyclerView.Adapter<Adaptor.MyHolder>() {

    interface OnItemClickListener{
        fun click(position:Int ,notes: Notes)
        fun onItemClick(position:Int, notes: Notes )
    }
    inner class MyHolder(val view :RvlayoutBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val myViewHolder = DataBindingUtil.inflate<RvlayoutBinding>(LayoutInflater.from(parent.context),
            R.layout.rvlayout,parent,false)
        return MyHolder(myViewHolder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var data = list[position]
        holder.view.tv1.text = data.title
        holder.view.tv2.text = "Dated:"+data.date

    }

}
