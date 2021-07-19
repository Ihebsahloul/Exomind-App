package com.exomind.task.weather

import android.content.ClipData.Item
import android.content.Intent
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
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.layout_error_status_notifier.*
import kotlinx.android.synthetic.main.layout_status_loading.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class IntroActivity : BaseActivity() {





    @InternalCoroutinesApi
    override fun initComponents(savedInstanceState: Bundle?) {


        addListeners()

    }


    override fun getLayoutId() = R.layout.activity_intro




    @InternalCoroutinesApi
    private fun addListeners() {

        weatherButton.setOnClickListener {

            val intent = Intent()
            intent.setClass(this, WeatherActivity::class.java)
            startActivity(intent)
        }

    }







    override fun onBackPressed() {
        super.onBackPressed()
    }
}
