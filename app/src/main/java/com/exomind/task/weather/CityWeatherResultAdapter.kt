package com.exomind.task.weather

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exomind.data.global.Constants
import com.exomind.domain.weather.WeatherResponse
import com.exomind.task.R
import com.exomind.task.databinding.ItemWeatherBinding
import com.exomind.task.models.CityWeatherUiModel
import java.util.*

class CityWeatherResultAdapter(private val items: ArrayList<CityWeatherUiModel>) :
    RecyclerView.Adapter<CityWeatherResultAdapter.ResourceViewHolder>()  {

    private var lastSelectedPosition: Int = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return ResourceViewHolder(ItemWeatherBinding.inflate(inflater, parent, false))
    }
    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int): Unit =
        items.get(position).let {
            holder.bind(it, holder.layoutPosition)
           // holder.setData(it)
            items?.get(position)?.let { safeModel ->
                // tell the viewHolder to fill in correct data to the view
              //  holder.setData(safeModel)
            }}



    inner class ResourceViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(modelRepository: CityWeatherUiModel, position: Int) {
            binding.cityWeather = modelRepository
            binding.executePendingBindings()
          //  populateData(modelRepository)
            binding.containerWeather.setOnClickListener {
              //  expandCollapse(modelRepository, position)

            }

           /* if( binding.cityWeather.weather?.get(0)?.main.equals(Constants.CLOUDS_STATUS.CLEAR))
            {
                binding.ivCloudsIcon.setImageResource(R.drawable.ic_sun)

            } else if( binding.cityWeather.weather?.get(0)?.main.equals(Constants.CLOUDS_STATUS.CLEAR))
            {
                binding.ivCloudsIcon.setImageResource(R.drawable.ic_clouds)
            }*/
            binding.containerWeather.setOnLongClickListener {
               // onClick(modelRepository)
                return@setOnLongClickListener true
            }
        }

        private fun populateData(modelRepository: CityWeatherUiModel) {
            binding.apply {
                modelRepository.let { it ->
                    it.name?.let {
                        val rnd = Random()
                        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                        binding.ivCloudsIcon.setColorFilter(color)
}

                }
            }
        }


    }

    companion object {
        val ResourceDiffUtil =
            object : DiffUtil.ItemCallback<CityWeatherUiModel>() {
                override fun areItemsTheSame(
                    oldItem: CityWeatherUiModel,
                    newItem: CityWeatherUiModel
                ): Boolean = oldItem.name == newItem.name

                override fun areContentsTheSame(
                    oldItem: CityWeatherUiModel,
                    newItem: CityWeatherUiModel
                ): Boolean = oldItem == newItem

            }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}