package com.exomind.task.activities

import android.os.Build
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.exomind.task.R
import com.exomind.task.weather.WeatherActivity
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric.buildActivity
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class WeatherTestActivity {

    private lateinit var weatherTestActivity: WeatherActivity

    @Before
    fun setup(){
        weatherTestActivity =
            buildActivity(WeatherActivity::class.java)
                .create()
                .resume()
                .get()
    }

    @Test
    fun `validate recycler list shown`() {
        val repoListView =
            weatherTestActivity.findViewById<RecyclerView>(R.id.rvCities)
        assertThat(repoListView).isNotNull()
        assertThat(repoListView.isVisible)
    }

    @Test
    fun `validate sort menu is displayed`() {
        weatherTestActivity =
            buildActivity(WeatherActivity::class.java)
                .create()
                .visible()
                .get()
        val menu = Shadows.shadowOf(weatherTestActivity).optionsMenu
        val menuItemSortByName = menu.findItem(R.id.action_sort_by_name)
        assertThat(menuItemSortByName.isVisible)
    }

}