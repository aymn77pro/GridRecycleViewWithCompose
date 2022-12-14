package com.example.gridwithcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridwithcompose.data.DataSource
import com.example.gridwithcompose.data.GridDataModel
import com.example.gridwithcompose.ui.theme.GridWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    GridApp()
        }
    }
}

@Composable
fun GridApp() {
    GridWithComposeTheme {
        GridList(
            gridList = DataSource.gridView
        )

    }

    }

@Composable
fun GridCard(gridDataModel: GridDataModel,modifier: Modifier = Modifier){
    Card(
        modifier.padding(4.dp)
    ) {
        Card(elevation = 4.dp) {
            Row {
                Box {
                    Image(
                        painter = painterResource(id = gridDataModel.image),
                        contentDescription = null,
                        modifier = modifier
                            .size(width = 68.dp, height = 68.dp)
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )
                }

                Column {
                    Text(
                        text = stringResource(id = gridDataModel.text),
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp
                        )
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_grid_24dp),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(12.dp)
                        )
                        Text(
                            text = gridDataModel.number.toString(),
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }
}
}

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun GridList(gridList:List<GridDataModel>,modifier: Modifier = Modifier){
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ){
            items(gridList){ gridList ->

                GridCard(gridDataModel = gridList)
            }
        }
        
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GridWithComposeTheme {
        GridApp()
    }
}