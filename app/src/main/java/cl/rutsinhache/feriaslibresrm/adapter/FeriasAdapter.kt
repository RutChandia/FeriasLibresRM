package cl.rutsinhache.feriaslibresrm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.rutsinhache.feriaslibresrm.R
import cl.rutsinhache.feriaslibresrm.databinding.ItemLayoutBinding
import cl.rutsinhache.feriaslibresrm.model.FeriasItem

class FeriasAdapter : RecyclerView.Adapter<FeriasAdapter.CustomViewHolder>() {
    private var list: List<FeriasItem> = ArrayList()

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val b = ItemLayoutBinding.bind(itemView)
        fun bindData(item: FeriasItem) {
            b.txtName.text = item.nombre
            b.txtComuna.text = item.comuna
            b.txtDirex.text = item.lugar
            b.txtDays.text = item.dia
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateList(list: List<FeriasItem>) {
        this.list = list
        notifyDataSetChanged()
    }
}