package com.exomind.task.weather

import android.content.ClipData.Item
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.exomind.data.global.Constants
import com.exomind.data.global.Constants.Parameters.MAX_TIME_TIMER
import com.exomind.data.global.Constants.Parameters.TICK_TIME
import com.exomind.data.utils.AppLogger
import com.exomind.task.R
import com.exomind.task.Utilities.*
import com.exomind.task.base.BaseActivity
import com.exomind.task.commons.Error
import com.exomind.task.commons.Loading
import com.exomind.task.commons.Success
import com.exomind.task.models.CityWeatherUiModel
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.layout_error_status_notifier.*
import kotlinx.android.synthetic.main.layout_status_loading.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class WeatherActivity : BaseActivity() {

    private lateinit var mCountDownTimer: CountDownTimer

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val WeatherViewModel: WeatherViewModel by viewModels { viewModelFactory }
    var progressStatus = 0
    var i = 0
    private val randomGenerator: Random? = Random()
    private val messagesList= ArrayList<String>()
    private  val cityWeahtersList = ArrayList<CityWeatherUiModel>()

    @InternalCoroutinesApi
    private lateinit var cityWeatherResultAdapter: CityWeatherResultAdapter




    @InternalCoroutinesApi
    override fun initComponents(savedInstanceState: Bundle?) {


        messagesList?.add(getString(R.string.first_msg))
        messagesList?.add(getString(R.string.second_msg))
        messagesList?.add(getString(R.string.third_msg))

        startTempProgress(temp_prgoress_bar, MAX_TIME_TIMER)
        observeUiState()
        observeSearchResults()
        addListeners()

    }

    @InternalCoroutinesApi
    fun startTempProgress(pb: ProgressBar, maxTime: Int) {
        i = 0
        cityWeahtersList.clear()
        layoutError.hide()
        loading_tv.show()
        start_progress_btn.hide()
        loading_msgs_tv.show()
        pb.show()
        progressStatus = 0

        mCountDownTimer = object : CountDownTimer(maxTime.toLong(), TICK_TIME) {
            override fun onTick(millisUntilFinished: Long) {

                i++
                pb.setProgress(i as Int * 100 / (maxTime / TICK_TIME.toInt()))
                val progressText = (i as Int * 100 / (maxTime / TICK_TIME)).toString()
                loading_tv.setText("$progressText %")

                if ( i == Constants.TIMEFRAMES.RENNES)
                {
                    fetchCityWeather(Constants.CITIES.RENNES)
                }
                if ( i == Constants.TIMEFRAMES.RENNES)
                {
                    fetchCityWeather(Constants.CITIES.PARIS)
                }
                if ( i == Constants.TIMEFRAMES.RENNES)
                {
                    fetchCityWeather(Constants.CITIES.NANTES)
                }
                if ( i == Constants.TIMEFRAMES.RENNES)
                {
                    fetchCityWeather(Constants.CITIES.BORDEAUX)
                }
                if ( i == Constants.TIMEFRAMES.RENNES)
                {
                    fetchCityWeather(Constants.CITIES.LYON)
                }

                if( i%6 == 0)
                    {

                        anyItem()
                    }


            }

            override fun onFinish() {
                pb.progress = 100
                pb.hide()
                loading_msgs_tv.hide()
                loading_tv.hide()

                if (!cityWeahtersList.isNullOrEmpty()) {
                    if (layoutError.isVisible) {
                        layoutError.hide()
                    }
                    start_progress_btn.show()
                    rvCities.show()

                    cityWeatherResultAdapter = CityWeatherResultAdapter(cityWeahtersList)
                    rvCities.apply {
                        adapter =
                            ScaleInAnimationAdapter(cityWeatherResultAdapter.apply { cityWeahtersList })
                         initRecyclerViewWithLineDecoration(this@WeatherActivity)
                    }
                } else

                    displayNoSearchResults()
            }
        }
        mCountDownTimer.start()
    }


    fun anyItem(): String? {
        val index: Int = randomGenerator!!.nextInt(messagesList!!.size)
        val item: String = messagesList.get(index)
        loading_msgs_tv.text = item
        return item
    }

    override fun getLayoutId() = R.layout.activity_weather

    private fun observeUiState() {
        WeatherViewModel.uiState.observe(this, Observer {
            when (it) {
                is Loading -> displayLoadingState()
                is Success -> hideLoadingState()
                is Error -> displayErrorState(it.error)
            }
        })
    }

    @InternalCoroutinesApi
    private fun observeSearchResults() {
        WeatherViewModel.searchResultsCategories.observe(this, Observer {
            displaySearchResults(it)
        })
    }

    @InternalCoroutinesApi
    private fun addListeners() {

        start_progress_btn.setOnClickListener {

            startTempProgress(temp_prgoress_bar,MAX_TIME_TIMER)
        }
        lookUpButton.setOnClickListener {

            startTempProgress(temp_prgoress_bar,MAX_TIME_TIMER)
        }

    }

    @InternalCoroutinesApi
    private fun fetchCityWeather(city :String) {
        WeatherViewModel.executeCityWeather(city)
    }


    private fun displayLoadingState() {
        rvCities.hide()
       // containerShimmer.show()
        //containerShimmer.startShimmer()
      //  containerShimmer.showShimmer(true)
    }

    private fun hideLoadingState() {
      //  rvCities.show()
        containerShimmer.hide()
        containerShimmer.stopShimmer()
    }

    @InternalCoroutinesApi
    private fun displaySearchResults(repoSearchResult: CityWeatherUiModel) {

            cityWeahtersList.add(repoSearchResult)
    }

    private fun displayNoSearchResults() {
        showSnackbar(
                rvCities,
                getString(R.string.label_no_times)
        )
        layoutError.show()
        loading_tv.hide()

    }

    private fun displayErrorState(error: Throwable) {
        hideLoadingState()
        showSnackbar(rvCities, "${error.message}")
        AppLogger.logD("activity", error.message)
    }



    override fun onBackPressed() {
        super.onBackPressed()
    }
}
