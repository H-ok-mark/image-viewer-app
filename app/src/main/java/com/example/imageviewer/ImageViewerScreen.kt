package com.example.imageviewer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageViewerScreen() {
    val imageList = listOf(
        R.drawable.`1`,
        R.drawable.`2`,
        R.drawable.`3`
    )
    val pagerState = rememberPagerState(pageCount = { imageList.size })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(id = imageList[page]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(imageList.size) { index ->
                    val color = if (index == pagerState.currentPage) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.White.copy(alpha = 0.45f)
                    }
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(color)
                            .padding(4.dp)
                    )
                }
            }
            Text(
                text = "${pagerState.currentPage + 1} / ${imageList.size}",
                color = Color.White
            )
        }
    }
}
