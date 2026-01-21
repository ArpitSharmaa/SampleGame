package com.netomi.samplegame

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FlipCard(
    value: Int,
    isFlipped: Boolean,
    isMatched: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val rotation by animateFloatAsState(
        targetValue = if (isFlipped || isMatched) 180f else 0f,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing
        ),
        label = "cardRotation"
    )

    Card(
        modifier = modifier
            .aspectRatio(1f)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 12f * density
            }
            .clickable(enabled = !isMatched) { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    when {
                        isMatched -> getColorForValue(value)
                        rotation > 90f -> getColorForValue(value)
                        else -> Color(0xFF2196F3)
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            if (rotation > 90f) {
                Text(
                    text = value.toString(),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.graphicsLayer {
                        rotationY = 180f
                    }
                )
            }
        }
    }
}

private fun getColorForValue(value: Int): Color {
    return when (value % 8) {
        1 -> Color(0xFF81C784)
        2 -> Color(0xFFFFD54F)
        3 -> Color(0xFFFF8A65)
        4 -> Color(0xFFBA68C8)
        5 -> Color(0xFF4FC3F7)
        6 -> Color(0xFFA1887F)
        7 -> Color(0xFFE57373)
        0 -> Color(0xFF90A4AE)
        else -> Color(0xFF81C784)
    }
}
