package com.example.brevageaiapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.brevageaiapp.databinding.RecognitionItemBinding
import com.example.brevageaiapp.viewmodel.Recognition

class RecognitionAdapter(private val ctx: Context):
    ListAdapter<Recognition, RecognitionViewHolder>(RecognitionDiffUtil()){

    class RecognitionDiffUtil: DiffUtil.ItemCallback<Recognition>() {
        override fun areItemsTheSame(oldItem: Recognition, newItem: Recognition): Boolean {
            return oldItem.label == newItem.label
        }

        override fun areContentsTheSame(oldItem: Recognition, newItem: Recognition): Boolean {
            return oldItem.confidence == newItem.confidence
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecognitionViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val binding = RecognitionItemBinding.inflate(inflater, parent, false)
        return RecognitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecognitionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RecognitionViewHolder(private val binding: RecognitionItemBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bind(recognition: Recognition){
        binding.recognitionItem = recognition
        binding.executePendingBindings()
    }

}
