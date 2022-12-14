package com.example.gridwithcompose.data

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class GridDataModel(
   @StringRes val text: Int,
   @IntegerRes val number: Int,
   @DrawableRes val image: Int
                    ) {

}
