package xyz.kalinski.perform.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/*
* Implementation in code:
*
* Declaration:
* ViewPager mViewPager;
* NameAdapter mNameAdapter;
*
* Code:
* mNameAdapter = new PagerAdapter(getSupportFragmentManager(), this);
* mViewPager.setAdapter(this.mNameAdapter);
* */

internal abstract class FragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val PAGES = 3
    val X_FRAGMENT = 1
    val Y_FRAGMENT = 2
    val Z_FRAGMENT = 3

    override fun getItem(position: Int): Fragment? {
        when (position) {
            X_FRAGMENT -> {
                return null    //Change to fragment.getInstance() method of selected fragment
            }
            Y_FRAGMENT -> {
                return null
            }
            Z_FRAGMENT -> {
                return null
            }
            else -> return null
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            X_FRAGMENT -> {
                return ""  //Change to name of fragment from R.string
            }
            Y_FRAGMENT -> {
                return ""
            }
            Z_FRAGMENT -> {
                return ""
            }
            else -> return ""
        }
    }

    override fun getCount(): Int {
        return PAGES
    }
}
