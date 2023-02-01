package com.example.notesap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesap.databinding.RcItemBinding

class Adapter(private val viewModel: DataViewModel): RecyclerView.Adapter<Adapter.DataHolder>() {

    private var dataList = emptyList<Data>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val binding = RcItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataHolder(binding)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.bind(dataList[position])
        holder.myCheckBox.setOnCheckedChangeListener{
                _, isChecked ->
            if(isChecked){
                viewModel.removeData(dataList[position])
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun setList(updatedDataList: List<Data>){
        dataList = updatedDataList
        notifyDataSetChanged()
    }

    class DataHolder(private val binding: RcItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data){
            binding.sampleText.text = data.text
            binding.doneChacbox.isChecked = false
        }
        var myCheckBox = binding.doneChacbox
    }

}