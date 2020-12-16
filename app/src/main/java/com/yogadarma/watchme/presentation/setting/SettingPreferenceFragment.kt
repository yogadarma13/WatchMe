package com.yogadarma.watchme.presentation.setting

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.yogadarma.watchme.R

class SettingPreferenceFragment: PreferenceFragmentCompat() {

    private lateinit var languagePreference: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
        init()
        setupListener()
    }

    private fun init() {
        languagePreference = findPreference<Preference>("language") as Preference
    }

    private fun setupListener() {
        languagePreference.setOnPreferenceClickListener {
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
            true
        }
    }
}